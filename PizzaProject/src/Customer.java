import java.util.*;

public class Customer {
    public static int customerIDincrementer=0;
    public int customerID;
    private String name;
    private String phone;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String city;
    private int zipcode;

    public Customer (String name, String phone, String email, String addressLine1
                     ){ //constructor method for Customer class
        customerIDincrementer++;
        this.customerID=customerIDincrementer;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = "GA";
        this.city = "Marrietta";
        this.zipcode = 30008;

    }

    // Getter and setter method for the customer information (lines 39-109)


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
