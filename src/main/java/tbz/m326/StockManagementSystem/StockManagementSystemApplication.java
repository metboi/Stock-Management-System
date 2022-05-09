package tbz.m326.StockManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tbz.m326.StockManagementSystem.Controller.ValidateCC;
import tbz.m326.StockManagementSystem.Data.ProvideStockData;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class StockManagementSystemApplication {
	public static ValidateCC validateCC = new ValidateCC();

	@Autowired

	public static void main(String[] args) throws IOException {
		while (true) {
			ProvideStockData stockData = new ProvideStockData();
			Scanner sc = new Scanner(System.in);
			System.out.println("Options: \n 1.) Get Stock Data \n 2.) Buy Stock \n 3.) Sell Stock \n 4.) Show Portfolio \n 5.) Exit");
			int option = sc.nextInt();
			switch (option) {
				case 1:
					System.out.println("Which Stock do you want to see?");
					sc.nextLine();
					String stock = sc.nextLine();
					String data = stockData.getData(stock);
					System.out.println(data);
					break;
				case 2:
					System.out.println("Which Stock would you like to buy?");
					sc.nextLine();
					String stockToBuy = sc.nextLine();
					String stockToBuyData = stockData.getData(stockToBuy);
					break;
				case 3:
					System.out.println("Test 3");
					break;
				case 4:
					System.out.println("Test 4");
					break;
				case 5:
					System.exit(0);
					break;
			}
		}


		//validateCC.validateCreditCardNumber("000000000000000");
	}

}