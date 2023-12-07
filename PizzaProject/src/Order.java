import java.util.*;

public class Order {
    private int paymentID = 0;
    private Account accountID;
    public String paymentType;
    public boolean isDelivery;
    public double balanceDue;
    public Cart items; //change to cart class and refer to cart.items

    //constructor method for the Order class
    public Order(int paymentID, Account accountID, Cart items, boolean isDelivery,
                 String paymentType, double balanceDue){
        paymentID++;
        this.paymentID = paymentID;
        this.accountID = accountID;
        this.items = items;
        this.isDelivery = isDelivery;
        this.paymentType = paymentType;
        this.balanceDue = balanceDue;
    }

    public String generateReceipt(){
        String receipt;
        //adds string values of each order attribute and returns string to receipt
        receipt = String.valueOf (paymentID) + accountID.getAccountID()
                + isDelivery + paymentType + balanceDue;
        return receipt;
    }

    public String getPaymentType(){
        return paymentType;
    }

    public double getBalanceDue(){
        return balanceDue;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public Account getAccountID() {
        return accountID;
    }
}
