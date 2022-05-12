package tbz.m326.StockManagementSystem.Controller;

import tbz.m326.StockManagementSystem.Data.Sql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Funds {
    public SignUp signUp = new SignUp();

    public void addFunds(float amount, String username) {
        boolean checkLog = true;
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps;
        int rs;
        Sql sql = new Sql();
        String query = "UPDATE sms.user SET money = money + ? where username = ?";
        while (checkLog){
            try {
                ps = sql.sqlCon().prepareStatement(query);
                ps.setFloat(1, amount);
                ps.setString(2, username);

                rs = ps.executeUpdate();

                if(rs == 1)
                {
                    System.out.println("Money was added to your account");
                    checkLog = false;
                }
                else{
                    System.err.println("Adding Funds Failed. Options: \n 1. Try again | 2. Abort");
                    int opt = sc.nextInt();
                    switch (opt){
                        case 1:
                            break;
                        case 2:
                            checkLog = false;
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }

    }
}
