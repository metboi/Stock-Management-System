package tbz.m326.StockManagementSystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tbz.m326.StockManagementSystem.Controller.SignUp;
import tbz.m326.StockManagementSystem.Data.Sql;

import java.sql.SQLException;

@SpringBootTest
class StementSystemockManagApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void tryData() throws SQLException{
		Sql sql = new Sql();

		sql.sqlCon();
	}

	@Test
	void TrySignup() throws SQLException{
		SignUp signUp = new SignUp();

		signUp.makeSignUp();
	}

}
