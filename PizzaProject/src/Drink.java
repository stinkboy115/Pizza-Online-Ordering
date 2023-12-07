public class Drink extends Item{
    private String drinkName;
    private String drinkSize;

    public Drink(){} //default constructor for Drink

    public Drink(String name, double drinkPrice, String size){ //constructor for Drink
        drinkName=name;
        price=drinkPrice;
        drinkSize = size;
    }

    public String getDrinkName(){ //returns the drinkName
        return drinkName;
    } //getter method for drinkName

    public void setDrinkName(String newName){ //changes the drinkName
        drinkName=newName;
    } //setter method for drinkName

    public String getDrinkSize(){ //returns the drinkSize
        return drinkSize;
    } //getter method for drinkSize

    public void setDrinkSize(String newSize){ //changes the drinkSize
        drinkSize = newSize;
    } //setter method for drinkSize
}
