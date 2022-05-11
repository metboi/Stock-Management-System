package tbz.m326.StockManagementSystem.Controller;

import tbz.m326.StockManagementSystem.Data.Sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogIn {

    public void checkLogIn(){
        Scanner sc = new Scanner(System.in);
        Sql sql = new Sql();
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM `user` WHERE `username` =? AND 'password' =?";

        try {
            ps = sql.sqlCon().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if(rs.next())
            {
                System.out.println("juhu");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
