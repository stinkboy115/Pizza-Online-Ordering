public class Pizza extends Item{
    private int pizzaSize;
    public String crust;

    public Pizza(Topping[] toppingList,String nameOfPizza, Integer size, String crustType){
        for(int x=0;x< toppingList.length;x++){// takes the price of all toppings and adds it to the pizza's price
            this.price=toppingList[x].price+this.price;
        }
        itemName=nameOfPizza;
        pizzaSize= size;
        crust = crustType;

        switch(crust){ //changes the price of pizza depending on the crust
            case "thin":
                this.price=this.price+4.00;
                break;
            case "thick":
                this.price=this.price+5.00;
                break;
            case "extra thick":
                this.price=this.price+6.00;
                break;
            case "deep dish":
                this.price=this.price+7.00;
                break;
        }

        switch(pizzaSize){ //changes the price of pizza depending on the pizzaSize
            case 10:
                this.price=this.price+1.00;
                break;
            case 12:
                this.price=this.price+2.00;
                break;
            case 14:
                this.price=this.price+3.00;
                break;
            case 20:
                this.price=this.price+5.00;
                break;
        }

    }
}