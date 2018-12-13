/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import sortmix.dao.DbContext;
import sortmix.dao.Repository;
import sortmix.model.TextSorterModel;

/**
 *
 * @author dariu
 */
public class BaseServlet extends HttpServlet {

    protected Repository repository;

    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();

        Connection connection = (Connection) context.getAttribute("dbConnection");
        if (connection == null) {
            connection = new DbContext().connect();
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
