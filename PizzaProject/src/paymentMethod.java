import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paymentMethod  extends  JFrame{
    private JButton returnHome=new JButton("Return Home");
    private JRadioButton creditDebitCardButton=new JRadioButton("Credit/Debit card");
    private JRadioButton cashCheckButton=new JRadioButton("Cash/Check");
    private JButton paymentButton= new JButton("Pay");
    private JPanel panel1;
    private JLabel cartPrice;

    public paymentMethod(Cart customersCart,String deliveryOption,Customer currentUser){
        returnHome.addActionListener(new ActionListener(){//returns user to the pizza ordering ui to create a different order
                                         public void actionPerformed(ActionEvent e) {
                                             setVisible(false);
                                             PizzaOrderingGUI pizza1 = new PizzaOrderingGUI(currentUser);
                                             pizza1.setVisible(true);

                                         }
                                     });
        setTitle("Payment Page");
        setSize(386, 113);
        cartPrice=new JLabel("Total Price: $"+Double.toString(customersCart.totalPrice()));//label with total price on it
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        ButtonGroup paymentChoice= new ButtonGroup();//radio buttons for choosing payment type
        paymentChoice.add(creditDebitCardButton);
        paymentChoice.add(cashCheckButton);
        final String[] typeofPayment = {"none"};


        paymentButton.addActionListener(new ActionListener() {//button to proceed to display receipt generation
            @Override
            public void actionPerformed(ActionEvent e) {
                if (creditDebitCardButton.isSelected()){
                    typeofPayment[0] ="credit/debit";
                    JOptionPane.showMessageDialog(null, "You payed with: "+typeofPayment[0]+"\nItems in cart: \n"+customersCart.returnReceipt()
                            +"\nTotal Price: "+customersCart.totalPrice(), "Order Details\n\n thank you for ordering!", JOptionPane.INFORMATION_MESSAGE);

                }
                else if(cashCheckButton.isSelected()){
                    typeofPayment[0] ="cash/check";
                    JOptionPane.showMessageDialog(null, "You payed with: "+typeofPayment[0]+"\nItems in cart: \n"+customersCart.returnReceipt()
                            +"\nTotal Price: "+customersCart.totalPrice(), "Order Details", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });

        add(creditDebitCardButton);
        add(cashCheckButton);
        add(cartPrice);
        add(returnHome);
        add(paymentButton);
    }
}
