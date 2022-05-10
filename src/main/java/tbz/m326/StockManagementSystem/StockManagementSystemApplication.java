package tbz.m326.StockManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tbz.m326.StockManagementSystem.Controller.ValidateCC;
import tbz.m326.StockManagementSystem.Data.Stock;
import tbz.m326.StockManagementSystem.Data.User;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class StockManagementSystemApplication {
	public static ValidateCC validateCC = new ValidateCC();

	@Autowired

	public static void main(String[] args) throws IOException {
		while (true) {
			Stock stockData = new Stock();
			ValidateCC ccValidator = new ValidateCC();
			Scanner sc = new Scanner(System.in);
			User user = new User();
			System.out.println("Options: \n 1.) Get Stock Data \n 2.) Buy Stock \n 3.) Sell Stock \n 4.) Show Portfolio \n 5.) Add Funds \n 6.) Withdraw Funds \n 7.) Exit");
			int option = sc.nextInt();
			switch (option) {
				//Get Stock Data
				case 1:
					System.out.println("Which Stock do you want to see?");
					sc.nextLine();
					String stock = sc.nextLine();
					String data = stockData.getData(stock);
					System.out.println(data);
					break;
				//Buy Stocks
				case 2:
					System.out.println("Which Stock would you like to buy?");
					sc.nextLine();
					String stockToBuy = sc.nextLine();
					String stockToBuyData = stockData.getData(stockToBuy);
					break;
				//Sell Stocks
				case 3:
					System.out.println("Test 3");
					break;
				//Show Portfolio
				case 4:
					user.showPortfolio();
					break;
				//Add Funds
				case 5:
					System.out.println("Input your Credit Card number");
					sc.nextLine();
					String ccNumber = sc.nextLine();
					if (ccValidator.validateCreditCardNumber(ccNumber) == true) {
						System.out.println(ccNumber + " is a valid Credit Card Number");
						//Add funds to the account
					} else {
						System.out.println(ccNumber + " is not a valid Credit Card Number");
					}
					break;
				//Withdraw Funds
				case 6:
					System.out.println("Test 6");
					break;
				//Exit
				case 7:
					System.exit(0);
					break;
			}
		}
	}

}