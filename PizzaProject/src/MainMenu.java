import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class MainMenu {
    public void MainMenu() {
    }
    public void createUIComponents() {
        try {
            File customerStorageFile=new File("customerStorage.txt");
            Scanner myScanner= new Scanner(customerStorageFile);
            FileWriter myWriter = new FileWriter("customerStorage.txt",true);
            final int[] numberOfCustomersInStorage = {0};



            //Main frame for the home page
            JFrame frame = new JFrame("MOM AND POP PIZZA");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JPanel mainPanel = new JPanel(new BorderLayout());

            //2x4 Grid of pizza, right customer panel
            JPanel pizzaPanel = new JPanel(new GridLayout(2, 4, 10, 10));
            for (int i = 1; i <= 8; i++) {
                JButton pizzaButton = new JButton("PIZZA " + i);
                pizzaPanel.add(pizzaButton);
            }
            JPanel rightPanel = new JPanel(new BorderLayout());

            JPanel returnCustPanel = new JPanel(new BorderLayout());
            returnCustPanel.setBorder((BorderFactory.createTitledBorder("Returning Customers:")));
            //JLabel usernameLabel= new JLabel("Username: ");
            JTextField usernameField = new JTextField(20);
            //JLabel passwordLabel= new JLabel("Password: ");
            JPasswordField passwordField = new JPasswordField(20);
            JButton loginButton = new JButton("LOGIN");


            // returnCustPanel.add(usernameLabel,BorderLayout.NORTH); //havnt gotten these to be where i want them to
            returnCustPanel.add(usernameField, BorderLayout.NORTH);
            //returnCustPanel.add(passwordLabel,BorderLayout.EAST);
            returnCustPanel.add(passwordField, BorderLayout.CENTER);
            returnCustPanel.add(loginButton, BorderLayout.SOUTH);

            JPanel newCustPanel = new JPanel(new BorderLayout());
            //GridBagConstraints c = new GridBagConstraints();
            newCustPanel.setBorder(BorderFactory.createTitledBorder("New Customers:"));


            JTextField nameField = new JTextField(20);
            JTextField emailField = new JTextField(20);
            JTextField phoneField = new JTextField(20);
            JTextField addressField = new JTextField(20);
            JButton registerButton = new JButton("Register");

            newCustPanel.add(new JLabel("Name: "));
            newCustPanel.add(nameField, BorderLayout.NORTH);
            newCustPanel.add(new JLabel("Email: "));
            newCustPanel.add(emailField);
            newCustPanel.add(new JLabel("Phone: "));
            newCustPanel.add(phoneField);
            newCustPanel.add(new JLabel("Address: "));
            newCustPanel.add(addressField);
            newCustPanel.add(registerButton, BorderLayout.SOUTH);
            rightPanel.add(returnCustPanel, BorderLayout.NORTH);
            rightPanel.add(newCustPanel, BorderLayout.CENTER);
            mainPanel.add(pizzaPanel, BorderLayout.WEST);
            mainPanel.add(rightPanel, BorderLayout.CENTER);

            frame.add(mainPanel);
            frame.setVisible(true);

            //Add login and register button logic here
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());
                    passwordField.setText("");
                    boolean nameInSystem=false;
                    boolean passwordWithName=false;
                    String userEmail="";
                    String userAddress="";
                    try{//reads the customer's storage file for checking if the user is in the data base to login
                        while(myScanner.hasNextLine()){
                            String data= myScanner.nextLine();
                            String[] splitData= data.split(" ");
                            if(splitData[5].compareTo("Name:")==(0)){
                                if(splitData[6].compareTo(username)==(0)){
                                    nameInSystem=true;
                                }
                            }//this whole try/catch block checks for the name/phone of the logging in user since phone = password

                            if(nameInSystem==true&&splitData[13].compareTo("Phone:")==(0)){
                                if(splitData[14].compareTo(password)==(0)){
                                    passwordWithName=true;
                                }
                            }
                            if(passwordWithName==true){
                                userEmail=splitData[10];
                                userAddress=splitData[18];
                                break;
                            }
                        }
                    }
                    catch(Exception q){
                        JOptionPane.showMessageDialog(null, q, "Order Details", JOptionPane.INFORMATION_MESSAGE);//shows error to user

                    }


                    if(nameInSystem==true&&passwordWithName==true){//sends user to the pizza ordering menu and closes main menu
                        Customer returningCustomer = new Customer(username,userEmail,password,userAddress);//actually moving to next window only happens when the user logs in correctly
                        PizzaOrderingGUI pizza1 = new PizzaOrderingGUI(returningCustomer);
                        pizza1.setVisible(true);
                        frame.setVisible(false);

                    }
                    else
                        JOptionPane.showMessageDialog(null, "Invalid login", "login error", JOptionPane.INFORMATION_MESSAGE);//shows error to user


                }
            });

            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try{//reads the customer's storage file to count how many customers in data base
                        while(myScanner.hasNextLine()){
                            String data= myScanner.nextLine();
                            String[] splitData= data.split(" ");
                            if(splitData[1].compareTo("ID: ")==(-1)){
                                numberOfCustomersInStorage[0]++;
                            }
                        }
                    }
                    catch(Exception q){
                        JOptionPane.showMessageDialog(null, q, "Order Details", JOptionPane.INFORMATION_MESSAGE);//shows error to user

                    }
                    Customer.customerIDincrementer= numberOfCustomersInStorage[0];//sets static number of customers in storage from file for adding additional customers

                    String name = nameField.getText();
                    String email = emailField.getText();
                    String phone = phoneField.getText();
                    String address = addressField.getText();


                    Customer newCustomer = new Customer(name, phone, email, address);
                    try {

                        myWriter.write("Customer ID: "+newCustomer.customerID+" , Customer Name: "+newCustomer.getName()+" , Customer Email: "+newCustomer.getEmail()+
                                " , Customer Phone: "+newCustomer.getPhone()+" , Customer Address: "+newCustomer.getAddressLine1()+"\n");
                        myWriter.close();


                    }
                    catch(IOException f){

                        System.out.println(" Error ");
                    }
                    PizzaOrderingGUI pizza1 = new PizzaOrderingGUI(newCustomer);
                    pizza1.setVisible(true);

                }
            });

        }
        catch(IOException e){
            System.out.println("Error");
        }
    }
}

