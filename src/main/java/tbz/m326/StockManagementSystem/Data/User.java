package tbz.m326.StockManagementSystem.Data;

public class User {



    private int user_id;

    private String username;

    private String email;
    private String password;
    private String creditcard;

    private float money;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }

    public void loginUser() {

    }

    public String showPortfolio() {
        //TODO: Read Stocks owned by users from Database and return them.
        System.out.println("Test");
        return "";
    }



}
