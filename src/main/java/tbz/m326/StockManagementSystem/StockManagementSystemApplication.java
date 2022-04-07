package tbz.m326.StockManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tbz.m326.StockManagementSystem.Data.ProvideStockData;
import tbz.m326.StockManagementSystem.Data.StockWrapper;
import yahoofinance.Stock;

@SpringBootApplication
public class StockManagementSystemApplication {

	@Autowired
	private static ProvideStockData provideStockData = new ProvideStockData();

	public static void main(String[] args) {
		SpringApplication.run(StockManagementSystemApplication.class, args);
		System.out.println("");
		final StockWrapper stockWrapper = provideStockData.findStock("UU.L");
		System.out.println(stockWrapper.getStock());
	}

}
