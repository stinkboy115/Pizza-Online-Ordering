import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class carryoutdelivierypage extends JFrame{
    private JRadioButton carryOutButton= new JRadioButton("Carry Out");

    private JRadioButton deliveryButton= new JRadioButton("Delivery");
    private JButton returnHome=new JButton("Return Home");
    private JButton checkOutButton=new JButton("Check Out");
    private JButton defaultAddressButton=new JButton("Default Address");
    private JLabel nameLabel=new JLabel("Name: ");
    private JTextArea nameField= new JTextArea(1,20);
    private JLabel phoneLabel=new JLabel("Phone #: ");
    private JTextArea phoneField= new JTextArea(1,20);
    private JLabel address1Label=new JLabel("Address one: ");
    private JTextArea addressOneField= new JTextArea(1,20);
    private JLabel address2label=new JLabel("Address two: ");
    private JTextArea addressTwoField= new JTextArea(1,20);
    private JLabel stateLabel=new JLabel("State: ");
    private JTextArea stateField = new JTextArea(1,20);
    private JLabel cityLabel=new JLabel("city: ");
    private JTextArea cityField = new JTextArea(1,20);
    private JLabel zipCodeLabel=new JLabel("Zip-Code: ");
    private JTextArea zipCodeField= new JTextArea(1,20);
    private JPanel jpanel1;
    public carryoutdelivierypage(Cart customersCart,Customer currentUser){

        setTitle("Carry out or Delivery Page");
        setSize(255, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        final String[] deliveryOption = {""};

        ButtonGroup orderOptions=new ButtonGroup();
        orderOptions.add(carryOutButton);
        orderOptions.add(deliveryButton);


        returnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PizzaOrderingGUI pizza1 = new PizzaOrderingGUI(currentUser);
                pizza1.setVisible(true);

            }
        });
        defaultAddressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//pulls from customer object sent to page to fill in fields by default
                nameField.setText(currentUser.getName());
                phoneField.setText(currentUser.getPhone());
                addressOneField.setText(currentUser.getAddressLine1());
                stateField.setText(currentUser.getState());
                cityField.setText(currentUser.getCity());
                zipCodeField.setText(Integer.toString(currentUser.getZipcode()));

            }
        });
        checkOutButton.addActionListener(new ActionListener() {//opens up payment screen and sends the customer's cart to it
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deliveryButton.isSelected()){
                    deliveryOption[0] ="Delivery";
                    if(addressOneField.getText().compareTo(" ")==(-1)){
                        JOptionPane.showMessageDialog(null, "Please Enter a address to deliver", "Delivery Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        setVisible(false);
                        paymentMethod paymentMethodScreen=new paymentMethod(customersCart, deliveryOption[0],currentUser);
                        paymentMethodScreen.setVisible(true);
                    }
                }
                else if(carryOutButton.isSelected()){
                    deliveryOption[0]="Carry Out";
                    setVisible(false);

                    paymentMethod paymentMethodScreen=new paymentMethod(customersCart, deliveryOption[0],currentUser);
                    paymentMethodScreen.setVisible(true);
                }

            }
        });

        add(nameLabel);
        add(nameField);
        add(phoneLabel);
        add(phoneField);
        add(address1Label);
        add(addressOneField);
        add(address2label);
        add(addressTwoField);
        add(stateLabel);
        add(stateField);
        add(cityLabel);
        add(cityField);
        add(zipCodeLabel);
        add(zipCodeField);
        add(returnHome);
        add(checkOutButton);
        add(defaultAddressButton);
        add(carryOutButton);
        add(deliveryButton);
    }

}
