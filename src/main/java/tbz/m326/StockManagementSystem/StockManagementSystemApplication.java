package tbz.m326.StockManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tbz.m326.StockManagementSystem.Controller.*;
import tbz.m326.StockManagementSystem.Data.Stock;
import tbz.m326.StockManagementSystem.Data.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class StockManagementSystemApplication {
	public static ValidateCC validateCC = new ValidateCC();

	@Autowired

	public static void main(String[] args) throws IOException, SQLException {
		LogIn logIn = new LogIn();
		SignUp signUp = new SignUp();
		Scanner sc = new Scanner(System.in);
		boolean auth = true;

		while (auth){
			System.out.println("1. Log In | 2. Sign Up");
			int firstMove = sc.nextInt();
			switch (firstMove){
				case 1:
					logIn.checkLogIn();
					auth = false;
					break;
				case 2:
					signUp.makeSignUp();
					auth = false;
					break;
				default:
					System.out.println("Option not available. Please try again.");
					break;
			}
		}

		while (true) {
			Stock stockData = new Stock();
			ValidateCC ccValidator = new ValidateCC();
			User user = new User();
			Funds funds = new Funds();
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
					String stocktobuy = sc.nextLine();
					BuyStock buyStock= new BuyStock();
					buyStock.buyStock(stocktobuy);
					break;
				//Sell Stocks
				case 3:
					System.out.println("Test 3");
					break;
				//Show Portfolio
				case 4:
					System.out.println("Input Username");
					sc.nextLine();
					String username = sc.nextLine();
					Stock stocks = new Stock();
					stocks.showPortfolio(username);
					break;
				//Add Funds
				case 5:
					System.out.println("Input your Credit Card number");
					sc.nextLine();
					String ccNumber = sc.nextLine();
					if (ccValidator.validateCreditCardNumber(ccNumber) == true) {
						System.out.println(ccNumber + " is a valid Credit Card Number");
						System.out.println("Inpt your username");
						String username3 = sc.nextLine();
						System.out.println("How much money do you want to add to the Account?");
						float amount = sc.nextFloat();
						funds.addFunds(amount, username3);
					} else {
						System.out.println(ccNumber + " is not a valid Credit Card Number");
					}
					break;
				//Withdraw Funds
				case 6:
					System.out.println("Input your Credit Card number");
					sc.nextLine();
					String ccN = sc.nextLine();
					if (ccValidator.validateCreditCardNumber(ccN) == true) {
						System.out.println(ccN + " is a valid Credit Card Number");
						System.out.println("Inpt your username");
						String username2 = sc.nextLine();
						System.out.println("How much money do you want to withdraw from the Account?");
						float amount = sc.nextFloat();
						funds.removeFunds(amount, username2);
					} else {
						System.out.println(ccN + " is not a valid Credit Card Number");
					}
					break;
				//Exit
				case 7:
					System.exit(0);
					break;
			}
		}
	}

}