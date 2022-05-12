package tbz.m326.StockManagementSystem.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.math.BigDecimal;

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

    public String buyStock(String Stock) throws IOException {
        this.getData(Stock);
        //TODO: Implement Database buy Logic
        return "";
    }

    public String sellStock(String Stock) throws IOException {
        this.getData(Stock);
        //TODO: Implement Database sell Logic
        return "";
    }

}


