public class Account {
    private int accountID = 1000;
    private Customer customer;
    private String username;
    private String password;

    public Account (Customer newCustomer, String password, String username){ //constructor for Account class
        this.username = username;
        this.password = password;
        this.customer = newCustomer;
        accountID++;
    }

    public int getAccountID() {
        return accountID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
