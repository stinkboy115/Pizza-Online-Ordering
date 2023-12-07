import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaOrderingGUI extends JFrame {




    private JButton returnHome=new JButton("Return Home");

    private JLabel titleLabel = new JLabel("Pizza Ordering Menu");
    //radio buttons for size of pizza
    private JLabel sizeLabel = new JLabel("Select Size:");


    private JRadioButton smallRadio = new JRadioButton("Small");
    private JRadioButton mediumRadio = new JRadioButton("Medium");
    private JRadioButton largeRadio = new JRadioButton("Large");
    private JRadioButton extraLargeRadio = new JRadioButton("Extra Large");

    //radio buttons for crust type
    private JLabel crustLabel = new JLabel("Select Crust:");
    private JRadioButton thinRadio = new JRadioButton("Thin");
    private JRadioButton thickRadio = new JRadioButton("Thick");
    private JRadioButton extraThickRadio = new JRadioButton("Extra Thick");
    private JRadioButton deepDishRadio = new JRadioButton("Deep Dish");

    //toppings
    private JLabel toppingsLabel = new JLabel("Select Toppings:");
    private JCheckBox pepperoniCheckbox = new JCheckBox("Pepperoni");
    private JCheckBox mushroomsCheckbox = new JCheckBox("Mushrooms");
    private JCheckBox sausageCheckbox = new JCheckBox("Sausage");
    private JCheckBox baconCheckbox = new JCheckBox("Bacon");
    private JCheckBox bbqChickenCheckbox = new JCheckBox("BBQ Chicken");
    private JCheckBox hamCheckbox = new JCheckBox("Ham");
    private JCheckBox oliveCheckbox = new JCheckBox("Olive");
    private JCheckBox pineappleCheckbox = new JCheckBox("Pineapple");
    private JCheckBox pepperCheckbox = new JCheckBox("Pepper");
    private JCheckBox marinaraCheckbox = new JCheckBox("Marinara");
    private JCheckBox ranchCheckbox = new JCheckBox("Ranch");
    private JCheckBox garlicButterCheckbox = new JCheckBox("Garlic Butter");
    private JButton orderButton = new JButton("Confirm Pizza");
    private JTextArea orderDetailsArea = new JTextArea(10, 30);
    private JButton completeOrderButton = new JButton("Complete Order");
    private JButton emptyCartButton = new JButton("Empty Cart");
    //already created pizza buttons
    private JButton addMeatLoversPizza= new JButton("Meat Lovers Pizza");
    private JButton addSixCheesePizza= new JButton("Six Cheese Pizza");
    private JButton addDeluxePizza= new JButton("Deluxe Pizza");
    private JButton addHawaiianPizza= new JButton("Hawaiian Pizza");
    private JButton addPhillyCheeseSteak= new JButton("Philly CheeseSteak pizza");
    private JButton addVeggiePizza= new JButton("Veggie Pizza");
    private JButton addPepperoniParmesan= new JButton("Pepperoni Parmesan Pizza");
    private JButton addBacCheeseBurger= new JButton("Bacon CheeseBurger Pizza");

    private double totalPrice = 0.0;
    JPanel panel1 = new JPanel();




    public PizzaOrderingGUI(Customer currentCustomer) {

        setTitle("Pizza Ordering Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(387, 593);

        //Panels
        panel1.setLayout(new GridLayout(1, 2, 10, 10));


        JPanel pizzaTypePanel = createPizzaTypePanel();
        JPanel sizeCrustPanel = createSizeCrustPanel();
        JPanel toppingsPanel = createToppingsPanel();

        panel1.add(pizzaTypePanel);
        panel1.add(sizeCrustPanel);
        panel1.add(toppingsPanel);

        add(panel1);

        //normal topping objects
        Topping pepperoni=new Topping("pepperoni",.50);
        Topping bacon=new Topping("bacon",1.50);
        Topping sausage=new Topping("sausage",1.75);
        Topping bbqChicken=new Topping("bbqChicken",2.00);
        Topping ham=new Topping("ham",.75);
        Topping mushroom=new Topping("mushroom",.50);
        Topping olive= new Topping("olive",.50);
        Topping pineapple= new Topping("pineapple",1.25);
        Topping pepper= new Topping("pepper",.75);
        Topping beef= new Topping("beef",3.00);
        Topping sixCheese= new Topping("6-cheeses",3.00);
        //sauces here and below
        Topping marinara= new Topping("marinara",2.75);
        Topping ranch= new Topping("ranch",3.75);
        Topping garlicButter= new Topping("garlic butter",3.75);

        //static pizza toppings for pizza objects
        Topping[] meatloversToppings =new Topping[4];meatloversToppings[0]=pepperoni;meatloversToppings[1]=bacon;meatloversToppings[2]=sausage;meatloversToppings[3]=ham;
        Topping[] sixCheesePizzaToppings= new Topping[2];sixCheesePizzaToppings[0]=sixCheese;sixCheesePizzaToppings[1]=marinara;
        Topping[] deluxePizzaToppings= new Topping[3];deluxePizzaToppings[0]=pepper;deluxePizzaToppings[1]=mushroom;deluxePizzaToppings[2]=olive;
        Topping[] hawaiianPizzaToppings= new Topping[3];hawaiianPizzaToppings[0]=ham;hawaiianPizzaToppings[1]=pineapple;hawaiianPizzaToppings[2]=bbqChicken;
        Topping[] phillyCheeseSteakToppings= new Topping[2];phillyCheeseSteakToppings[0]=beef;phillyCheeseSteakToppings[1]=mushroom;
        Topping[] veggiePizzaToppings= new Topping[3];veggiePizzaToppings[0]=pepper;veggiePizzaToppings[1]=mushroom;veggiePizzaToppings[2]=olive;
        Topping[] pepperroniParmesanToppings= new Topping[2];pepperroniParmesanToppings[0]=pepperoni;pepperroniParmesanToppings[1]=sixCheese;
        Topping[] baconCheeseBurgerToppings= new Topping[2];baconCheeseBurgerToppings[0]=sixCheese;baconCheeseBurgerToppings[1]=beef;

        //pizzas objects that are set buttons created
        Pizza meatLoversPizza = new Pizza(meatloversToppings,"Meat Lover's Pizza", 12, "thick");//default pizzas for selection
        Pizza sixCheesePizza = new Pizza(sixCheesePizzaToppings,"Six Cheese Pizza", 12, "thick");
        Pizza deluxePizza = new Pizza(deluxePizzaToppings,"Deluxe Pizza", 12, "thick");
        Pizza hawaiianPizza = new Pizza(hawaiianPizzaToppings,"Hawaiian Pizza", 12, "thick");
        Pizza phillyCheesesteak = new Pizza(phillyCheeseSteakToppings, "Philly Cheesesteak", 12, "thick");
        Pizza veggiePizza = new Pizza(veggiePizzaToppings,"Veggie Pizza", 12, "thick");
        Pizza pepperroniParmesan = new Pizza(pepperroniParmesanToppings,"Pepperoni Parmesan", 12, "thick");
        Pizza baconCheeseburger = new Pizza(baconCheeseBurgerToppings,"Bacon Cheeseburger", 12,"thick");
        final Pizza[] customPizza = new Pizza[1];

        //customers cart holding the items
        Cart customersCart=new Cart();

        setTitle("Pizza Ordering Menu");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        ButtonGroup sizeGroup = new ButtonGroup();//groups buttons by ype
        sizeGroup.add(smallRadio);
        sizeGroup.add(mediumRadio);
        sizeGroup.add(largeRadio);
        sizeGroup.add(extraLargeRadio);

        ButtonGroup crustGroup=new ButtonGroup();
        crustGroup.add(thinRadio);
        crustGroup.add(thickRadio);
        crustGroup.add(extraThickRadio);
        crustGroup.add(deepDishRadio);
        final StringBuilder[] orderSummary = {new StringBuilder("Order Summary:\n")};


        //preprepared pizza button action listeners
        addMeatLoversPizza.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                customersCart.addLastNode(meatLoversPizza);
                orderSummary[0].append("Meat Lovers Pizza \n");
                orderDetailsArea.setText(orderSummary[0].toString());

            }
        });
        addSixCheesePizza.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                customersCart.addLastNode(sixCheesePizza);
                orderSummary[0].append("6 cheese pizza \n");
                orderDetailsArea.setText(orderSummary[0].toString());

            }
        });
        addDeluxePizza.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                customersCart.addLastNode(deluxePizza);
                orderSummary[0].append("Deluxe pizza \n");
                orderDetailsArea.setText(orderSummary[0].toString());
            }
        });
        addHawaiianPizza.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                customersCart.addLastNode(hawaiianPizza);
                orderSummary[0].append("Hawaiian Pizza \n");
                orderDetailsArea.setText(orderSummary[0].toString());

            }
        });
        addPhillyCheeseSteak.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                customersCart.addLastNode(phillyCheesesteak);
                orderSummary[0].append("Philly CheeseSteak Pizza \n");
                orderDetailsArea.setText(orderSummary[0].toString());

            }
        });
        addVeggiePizza.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                customersCart.addLastNode(veggiePizza);
                orderSummary[0].append("Veggie Pizza \n");
                orderDetailsArea.setText(orderSummary[0].toString());

            }
        });
        addPepperoniParmesan.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                customersCart.addLastNode(pepperroniParmesan);
                orderSummary[0].append("Pepperoni Parmesan Pizza \n");
                orderDetailsArea.setText(orderSummary[0].toString());

            }
        });
        addBacCheeseBurger.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                customersCart.addLastNode(baconCheeseburger);
                orderSummary[0].append("Bacon Cheeseburger Pizza \n");
                orderDetailsArea.append(orderSummary[0].toString());


            }
        });


        orderButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // Process the selected items and update order details
                orderSummary[0].append("Custom Pizza: \n");

                int pizzaSize=10;
                String crustType="thick";


                //radio buttons for size of pizza
                if (smallRadio.isSelected()) {
                    orderSummary[0].append("Size: Small\n");
                    pizzaSize=10;

                } else if (mediumRadio.isSelected()) {
                    orderSummary[0].append("Size: Medium\n");
                    pizzaSize=12;

                } else if (largeRadio.isSelected()) {
                    orderSummary[0].append("Size: Large\n");
                    pizzaSize=20;

                }else if (extraLargeRadio.isSelected()) {
                    orderSummary[0].append("Size: Extra Large\n");
                    pizzaSize=20;

                }


                //radio buttons for crust type
                if (thinRadio.isSelected()) {
                    orderSummary[0].append("Crust: Thin\n");
                    crustType="thin";

                } else if (thickRadio.isSelected()) {
                    orderSummary[0].append("Crust: Thick\n");
                    crustType="thick";

                } else if (extraThickRadio.isSelected()) {
                    orderSummary[0].append("Crust: Extra Thick\n");
                    crustType="extra thick";
                } else if (deepDishRadio.isSelected()) {
                    orderSummary[0].append("Crust: Deep Dish\n");
                    crustType="deep dish";

                }

                orderSummary[0].append("Toppings:\n");
                int numberOfToppings=0;

                //all these if statements for determining how many toppings selected
                if (pepperoniCheckbox.isSelected()) {
                    orderSummary[0].append(" - Pepperoni\n");
                    numberOfToppings++;

                }
                if (mushroomsCheckbox.isSelected()) {
                    orderSummary[0].append(" - Mushrooms\n");
                    numberOfToppings++;

                }
                if (sausageCheckbox.isSelected()) {
                    orderSummary[0].append(" - Sausage\n");
                    numberOfToppings++;
                }
                if (baconCheckbox.isSelected()) {
                    orderSummary[0].append(" - Bacon\n");
                    numberOfToppings++;
                }
                if (bbqChickenCheckbox.isSelected()) {
                    orderSummary[0].append(" - BBQ Chicken\n");
                    numberOfToppings++;
                }
                if (hamCheckbox.isSelected()) {
                    orderSummary[0].append(" - Ham\n");
                    numberOfToppings++;
                }
                if (oliveCheckbox.isSelected()) {
                    orderSummary[0].append(" - Olives\n");
                    numberOfToppings++;
                }
                if (pineappleCheckbox.isSelected()) {
                    orderSummary[0].append(" - Pineapple\n");
                    numberOfToppings++;
                }
                if (pepperCheckbox.isSelected()) {
                    orderSummary[0].append(" - Pepper\n");
                    numberOfToppings++;
                }
                if (marinaraCheckbox.isSelected()) {
                    orderSummary[0].append(" - Marinara Sauce\n");
                    numberOfToppings++;
                }
                if (ranchCheckbox.isSelected()) {
                    orderSummary[0].append(" - Ranch Sauce\n");
                    numberOfToppings++;
                }
                if (garlicButterCheckbox.isSelected()) {
                    orderSummary[0].append(" - Garlic Butter Sauce\n");
                    numberOfToppings++;
                }

                //all the if statements to add the chosen toppings to the pizza
                int currentToppingCount=0;
                Topping[] customPizzaToppings = new Topping[numberOfToppings];
                if (pepperoniCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=pepperoni;
                    currentToppingCount++;

                }
                if (mushroomsCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=mushroom;
                    currentToppingCount++;

                }
                if (sausageCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=sausage;
                    currentToppingCount++;
                }
                if (baconCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=bacon;
                    currentToppingCount++;
                }
                if (bbqChickenCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=bbqChicken;
                    currentToppingCount++;
                }
                if (hamCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=ham;
                    currentToppingCount++;
                }
                if (oliveCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=olive;
                    currentToppingCount++;
                }
                if (pineappleCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=pineapple;
                    currentToppingCount++;
                }
                if (pepperCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=pepper;
                }
                if (marinaraCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=marinara;
                    currentToppingCount++;
                }
                if (ranchCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=ranch;
                    currentToppingCount++;
                }
                if (garlicButterCheckbox.isSelected()) {
                    customPizzaToppings[currentToppingCount]=garlicButter;

                }


                customPizza[0] =new Pizza(customPizzaToppings,"custom pizza",pizzaSize,crustType);//stores pizza into pizza array
                customersCart.addFirstNode(customPizza[0]);


                orderDetailsArea.setText(orderSummary[0].toString());
                orderSummary[0] =new StringBuilder();//resets order summary
            }
        });

        completeOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display the order details and total price
                String orderSummary = orderDetailsArea.getText();
                totalPrice=customersCart.totalPrice();
                orderSummary += String.format("\nTotal Price: $%.2f", totalPrice);
                JOptionPane.showMessageDialog(null, orderSummary, "Order Details", JOptionPane.INFORMATION_MESSAGE);
                carryoutdelivierypage newPage=new carryoutdelivierypage(customersCart,currentCustomer);//sends customer to the payment screen and asks them to select their delivery options
                newPage.setVisible(true);
                setVisible(false);



            }
        });
        emptyCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                customersCart.emptyCart();
                orderDetailsArea.setText("Empty");
                totalPrice=0;

            }
        });
//adds everything to the ui
        add(titleLabel); //made title in mainframe

        add(orderDetailsArea);
        add(completeOrderButton);
        add(emptyCartButton);
        add(orderButton);

    }
    private JPanel createPizzaTypePanel() {
        JPanel pizzaTypePanel = new JPanel();
        pizzaTypePanel.setLayout(new GridLayout(4, 2, 10, 10));
        add(addMeatLoversPizza);
        add(addSixCheesePizza);
        add(addDeluxePizza);
        add(addHawaiianPizza);
        add(addPhillyCheeseSteak);
        add(addVeggiePizza);
        add(addPepperoniParmesan);
        add(addBacCheeseBurger);

        //buttons for pizza types (specialty)

        return pizzaTypePanel;
    }

    private JPanel createSizeCrustPanel() {
        JPanel sizeCrustPanel = new JPanel(new FlowLayout());
        sizeCrustPanel.setLayout(new GridLayout(4, 2, 10, 10));
        add(sizeLabel);
        add(smallRadio);
        add(mediumRadio);
        add(largeRadio);
        add(extraLargeRadio);
        add(crustLabel);
        add(thinRadio);
        add(thickRadio);
        add(extraThickRadio);
        add(deepDishRadio);


        //buttons for the pizza sizes

        return sizeCrustPanel;
    }

    private JPanel createToppingsPanel() {
        JPanel toppingsPanel = new JPanel(new FlowLayout());
        toppingsPanel.setLayout(new GridLayout(4, 2, 10, 10));
        add(toppingsLabel);
        add(pepperoniCheckbox);
        add(mushroomsCheckbox);
        add(sausageCheckbox);
        add(baconCheckbox);
        add(bbqChickenCheckbox);
        add(hamCheckbox);
        add(oliveCheckbox);
        add(pineappleCheckbox);
        add(pepperCheckbox);
        add(marinaraCheckbox);
        add(ranchCheckbox);
        add(garlicButterCheckbox);

        //add toppings buttons here

        return toppingsPanel;

    }



}