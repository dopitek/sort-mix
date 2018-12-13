/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author dariu
 */
public class Repository {

    private final Connection con;

    public Repository(Connection connection) {
        this.con = connection;
    }

    public void createTable() throws SQLException {
        Statement statement = this.con.createStatement();
        // Tworzymy pola tabeli
        statement.executeUpdate("CREATE TABLE Data "
                + "(inputText VARCHAR(1000), resultText VARCHAR(1000), "
                + "sortingMode VARCHAR(5), date VARCHAR(100))");
    }

    public void insertData(Data data) throws SQLException {

        Statement statement = this.con.createStatement();
        // Wypełniamy wiersze tabeli Data
        statement.executeUpdate(String.format("INSERT INTO Data(inputText, resultText, sortingMode, date) VALUES ('%s', '%s', '%s', '%s')",
                data.getInitText(),
                data.getResultText(),
                data.getSortingMode(),
                data.getDate()));
    }

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
