package tbz.m326.StockManagementSystem.Controller;

import tbz.m326.StockManagementSystem.Data.Sql;
import tbz.m326.StockManagementSystem.Data.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogIn {

    public SignUp signUp = new SignUp();
    public User user = new User();

    public void checkLogIn() throws SQLException{
        boolean checkLog = true;
        Sql sql = new Sql();
        while (checkLog){

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your username:");
            String username = sc.nextLine();
            System.out.println("Enter your password:");
            String password = sc.nextLine();

            PreparedStatement ps;
            ResultSet rs;
            String query = "SELECT * FROM `user` WHERE username =? AND user.password =?";

            try {
                ps = sql.sqlCon().prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);

                rs = ps.executeQuery();

                if(rs.next())
                {
                    System.out.println("LogIn was successful");
                    user.setUser_id(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setCreditcard(rs.getString("creditcard"));
                    user.setEmail(rs.getString("email"));
                    user.setMoney(rs.getFloat("money"));
                    checkLog = false;
                }
                else{
                    System.err.println("LogIn failed. Options: \n 1. Try again | 2. Sign Up");
                    int opt = sc.nextInt();
                    switch (opt){
                        case 1:
                            break;
                        case 2:
                            signUp.makeSignUp();
                            checkLog = false;
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }

        sql.sqlCon().close();
    }
}
