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


    public void addUser(String username, String email, String cc, String password) throws SQLException{
        PreparedStatement ps;
        String query = "INSERT INTO sms.user(username, email, creditcard, password) VALUE (?, ?, ?, ?)";
        ps = sqlCon().prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, email);
        ps.setString(3, cc);
        ps.setString(4, password);
        ps.execute();

        System.out.println("Success!");

    }
}

//User Portfolio
//select `sms`.`user`.`username` AS `username`, `s`.`name` AS `name`
//from (`sms`.`user` join `sms`.`stocks` `s` on ((`sms`.`user`.`user_id` = `s`.`user_id`)));
//--------------------------------------------------------------------------------------------
//User
//
//
//
//
//
//
//
//
//