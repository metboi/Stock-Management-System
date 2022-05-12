package tbz.m326.StockManagementSystem.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

@Getter
@With
@AllArgsConstructor
public class Stock {

    public String getData(String Stock) throws IOException {
        yahoofinance.Stock stock = YahooFinance.get(Stock);
        StockQuote quote = stock.getQuote();
        BigDecimal price = quote.getPrice();
        return (price + " USD");
    }

    public float getPriceOnly (String Stock) throws IOException{
        yahoofinance.Stock stock = YahooFinance.get(Stock);
        StockQuote quote = stock.getQuote();
        BigDecimal price = quote.getPrice();
        float fPrice = price.floatValue();
        return fPrice;

    }


    public String sellStock(String Stock) throws IOException {
        this.getData(Stock);
        //TODO: Implement Database sell Logic
        return "";
    }

    public void showPortfolio(String username){
        boolean checkLog = true;
        PreparedStatement ps;
        ResultSet rs;
        Sql sql = new Sql();
        String query = "select * from user where username = ?";
        String query2 = "select stockName, buyPrice, amount from stocks where user_id = ?";
        while (checkLog){
            try {
                ps = sql.sqlCon().prepareStatement(query);
                ps.setString(1, username);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    ps = sql.sqlCon().prepareStatement(query2);
                    ps.setInt(1, user_id);
                    rs = ps.executeQuery();
                    while(rs.next())
                    {
                        String stockName = rs.getString("stockName");
                        float buyPrice = rs.getFloat("buyPrice");
                        int amount = rs.getInt("amount");
                        System.out.println("Stock Name: " + stockName + "| Buy Price: " + buyPrice + "| Amount: " + amount);
                        checkLog = false;
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }
}


