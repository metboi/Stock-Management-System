package tbz.m326.StockManagementSystem.Data;

import java.sql.*;

public class Sql {
    public void sqlCon() throws SQLException {
        Connection con= null;
        con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/sms","root","$$TBZrootMK$$");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from user");
        while(rs.next())
            System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getString(3));
        con.close();
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