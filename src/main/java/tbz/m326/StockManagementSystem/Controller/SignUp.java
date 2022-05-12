package tbz.m326.StockManagementSystem.Controller;

import tbz.m326.StockManagementSystem.Data.Sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SignUp {

    public void makeSignUp(){
        Scanner sc = new Scanner(System.in);
        Sql sql = new Sql();

        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM `user` WHERE username =? AND user.password =?";

        boolean check = true;
        while(true){
            System.out.println("Please enter your Username");
            String username = sc.nextLine();

        }
    }
}
