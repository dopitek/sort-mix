package sortmix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class used to establish connection to the database
 *
 * @author Dariusz Opitek
 * @version 1.3
 */
public class DbContext {

    /**
     *
     * @param clientDriver driver used to connect to database
     * @param address database address
     * @param user database user
     * @param pass database user password
     * @return returns connection to the database
     */
    public Connection connect(String clientDriver, String address, String user, String pass) {
        Connection con = null;
        try {
            Class.forName(clientDriver);
            con = DriverManager.getConnection(address, user, pass);
        } catch (SQLException sqle) {
            System.err.println("SQL exception: " + sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("ClassNotFound exception: " + cnfe.getMessage());
        }
        return con;
    }
}
