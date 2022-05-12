package tbz.m326.StockManagementSystem.Controller;

import tbz.m326.StockManagementSystem.Data.Sql;
import tbz.m326.StockManagementSystem.Data.Stock;
import tbz.m326.StockManagementSystem.Data.User;

import java.io.IOException;
import java.util.Scanner;

public class BuyStock {
    Stock stock = new Stock();
    Scanner sc = new Scanner(System.in);
    Sql sql = new Sql();
    User user;
    public String buyStock(String Stock) throws IOException {
        float stockPrice = stock.getPriceOnly(Stock);
        System.out.println("Stock Price: " + stock.getData(Stock));
        System.out.println("How many do you want?");
        int amount = sc.nextInt();
        float money = user.getMoney();
        float cost = stockPrice * amount;
        System.out.println("");
        return "Stock successfully bought";
    }
}
