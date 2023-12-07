public class Item {
    public String itemName;
    public int itemID=0;
    public static int itemIDCreator=0;
    public double price=0.00;

    public Item(){} //default constructor for Item

    public Item(double newPrice){ //constructor for Item and needs a newPrice
        price = newPrice;
        itemID=itemIDCreator;
        itemIDCreator++;
    }

    public double getPrice(){ //getter method for price
        return price;
    } //getter method for price

    public void setPrice(double newPrice){ //setter method for price
        price=newPrice;
    } //setter method for price
}
