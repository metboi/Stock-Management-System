package tbz.m326.StockManagementSystem.Data;

import java.sql.*;

public class Sql {
    public Connection sqlCon() throws SQLException {
        Connection con= null;
        con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/sms","root","$$TBZrootMK$$");
        Statement stmt=con.createStatement();
        return con;
    }


    public void addUser(String username, String email, String cc, String password){

    }
}

