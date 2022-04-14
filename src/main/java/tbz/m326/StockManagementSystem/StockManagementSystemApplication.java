package tbz.m326.StockManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tbz.m326.StockManagementSystem.Data.ProvideStockData;

import java.io.IOException;

@SpringBootApplication
public class StockManagementSystemApplication {

	@Autowired

	public static void main(String[] args) throws IOException {
		ProvideStockData stock = new ProvideStockData();
		String data = stock.getData("TSLA");
		System.out.println(data);
	}

}
