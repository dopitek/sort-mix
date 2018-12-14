package sortmix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class used for handling basic read write database operations
 * @author Dariusz Opitek
 * @version 1.3
 */
public class Repository {

    /**
     * stores connection to database
     */
    private final Connection con;

    /**
     * Constructor to create repository
     * @param connection connection to database
     */
    public Repository(Connection connection) {
        this.con = connection;
    }

    /**
     * Method used to create main table
     * @throws SQLException throws exception when create table fails
     */
    public void createTable() throws SQLException {
        Statement statement = this.con.createStatement();
        // Tworzymy pola tabeli
        statement.executeUpdate("CREATE TABLE Data "
                + "(inputText VARCHAR(1000), resultText VARCHAR(1000), "
                + "sortingMode VARCHAR(5), date VARCHAR(100))");
    }

    /**
     * Inserts data to database
     * @param data data inserted to database
     * @throws SQLException throws exception when insert data fails
     */
    public void insertData(Data data) throws SQLException {

        Statement statement = this.con.createStatement();
        statement.executeUpdate(String.format("INSERT INTO Data(inputText, resultText, sortingMode, date) VALUES ('%s', '%s', '%s', '%s')",
                data.getInitText(),
                data.getResultText(),
                data.getSortingMode(),
                data.getDate()));
    }

    /**
     * Selects data from database
     * @return returns data from database
     * @throws SQLException  throws exception when reading data fails
     */
    public ArrayList<Data> selectData() throws SQLException {
        ArrayList<Data> list = new ArrayList<>();
        Statement statement = this.con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Data");

        while (rs.next()) {
            Data data = new Data();
            data.setInitText(rs.getString("inputText"));
            data.setResultText(rs.getString("resultText"));
            data.setSortingMode(rs.getString("sortingMode"));
            data.setDate(rs.getString("date"));
            list.add(data);
        }
        rs.close();
        return list;
    }
}
