package tbz.m326.StockManagementSystem.Controller;

import tbz.m326.StockManagementSystem.Data.Sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {

    public void makeSignUp() throws SQLException {
        ValidateCC validateCC = new ValidateCC();
        Scanner sc = new Scanner(System.in);
        Sql sql = new Sql();
        String username = "";
        String email = "";
        String cc = "";
        String password = "";

        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM `user` WHERE username =?";

        boolean check = true;
        while (check) {

            System.out.println("Please enter your Username:");
            String searchUsername = sc.nextLine();
            ps = sql.sqlCon().prepareStatement(query);
            ps.setString(1, searchUsername);

            rs = ps.executeQuery();

            if (rs.next()) {
                System.err.println("Username already exist, Try again");
            }
            else {
                username = searchUsername;
                check = false;
            }

        }
        System.out.println("Please enter your password:");
        password = sc.nextLine();

        boolean checkMail = true;
        while(checkMail){

            System.out.println("Please enter your E-Mail:");
            String tryMail = sc.nextLine();
            if (tryMail.contains("@")){
                email = tryMail;
                checkMail = false;
            }
            else {
                System.err.println("E-Mail is invalid. Try again");
            }
        }

        boolean checkCC = true;

        while (checkCC){
            System.out.println("Please enter your CreditCard number:");
            String tryCC = sc.nextLine();
            boolean isValid = validateCC.validateCreditCardNumber(tryCC);
            if (isValid){
                cc = tryCC;
                checkCC = false;
            }
            else{
                System.err.println("CreditCard invalid. Try again:");
            }
        }

        sql.addUser(username, email, cc, password);
        sql.sqlCon().close();
    }
}
