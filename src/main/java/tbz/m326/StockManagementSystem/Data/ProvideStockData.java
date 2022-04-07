package tbz.m326.StockManagementSystem.Data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class ProvideStockData {
    public StockWrapper findStock (final String ticker){
        try{
            return new StockWrapper (YahooFinance.get(ticker)) ;
        }
        catch (Exception ex){
            System.err.println(ex);
        }
        return null;
    }

    public BigDecimal findPrice(final StockWrapper stock) throws IOException {
        return stock.getStock().getQuote(true).getPrice();
    }

}
