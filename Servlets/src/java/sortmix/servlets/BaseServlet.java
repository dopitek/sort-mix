package sortmix.servlets;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import sortmix.dao.DbContext;
import sortmix.dao.Repository;

/**
 * Base servlet to establish connection to database
 * @author Dariusz Opitek
 * @version 1.3
 */
public class BaseServlet extends HttpServlet {

    /**
     * used for handling basic read write database operations
     */
    protected Repository repository;

    /**
     * Instantiates connection to database and creates main table
     * @throws ServletException throws exception when creating table fails
     */
    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        
        Connection connection = (Connection) context.getAttribute("dbConnection");
        if (connection == null) {
            connection = new DbContext().connect(
                    context.getInitParameter("ClientDriver"),
                    context.getInitParameter("Address"),
                    context.getInitParameter("User"),
                    context.getInitParameter("Pass")
            );
            context.setAttribute("dbConnection", connection);
            repository = new Repository(connection);
            try {
                repository.createTable();
            } catch (SQLException ex) {
                System.err.println("SQL exception: " + ex.getMessage());
            }
        } else {
            repository = new Repository(connection);
        }

    }
}
