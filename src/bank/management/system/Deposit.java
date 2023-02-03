package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton exit,deposit;
    String cardNo,pinNo;
    Deposit(String cardNo,String pinNo){

        setLayout(null);
        this.pinNo = pinNo;
        this.cardNo = cardNo;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JLabel text = new JLabel("Enter Amount to be Deposited:".toUpperCase());
        text.setBounds(180,300,320,25);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170,350,320,30);
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setToolTipText("INR-INDIAN RUPEE");
        image.add(amount);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(355,450,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        exit = new JButton("BACK");
        exit.setBounds(355,485,150,30);
        image.add(exit);
        exit.addActionListener(this);

        setSize(900,900);
        image.setBounds(0,0,900,900);
        setLocation(350,0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            String amt = amount.getText();
            Date date = new Date();
            if(amt.equals(""))JOptionPane.showMessageDialog(null,"Enter Valid Amount!");
            else {
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values('"+cardNo+"','"+amt+"','"+date+"','Deposit')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Amount " +amt+" INR was deposited successfully");
                    setVisible(false);
                    new Transactions(cardNo,pinNo);
                }catch (Exception se){
                    System.out.println(se);
                }
            }
        } else  {
            setVisible(false);
            new Transactions("",pinNo);
        }
    }
}
