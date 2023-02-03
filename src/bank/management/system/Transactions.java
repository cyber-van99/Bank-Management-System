package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,cash,fastCash,pin,exit,balance,mini;
    String pinNo,cardNo;

    public Transactions(String cardNo,String pinNo){
        setLayout(null);
        this.pinNo = pinNo;
        this.cardNo = cardNo;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JLabel text = new JLabel("Please Make a Choice".toUpperCase());
        text.setBounds(240,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        cash = new JButton("CASH WITHDRAW");
        cash.setBounds(355,415,150,30);
        cash.addActionListener(this);
        image.add(cash);


        pin = new JButton("PIN CHANGE");
        pin.setBounds(355,450,150,30);
        pin.addActionListener(this);
        image.add(pin);

        balance = new JButton("BALANCE");
        balance.setBounds(170,450,150,30);
        balance.addActionListener(this);
        image.add(balance);

        mini =  new JButton("MINI-STATEMENT");
        mini.setBounds(170,485,150,30);
        mini.addActionListener(this);
        image.add(mini);

        exit = new JButton("EXIT");
        exit.setBounds(355,485,150,30);
        image.add(exit);
        exit.addActionListener(this);


        setSize(900,900);
        image.setBounds(0,0,900,900);
        setLocation(400,10);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Transactions("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }else if (e.getSource() == deposit) {
            setVisible(false);
            new Deposit(cardNo,pinNo);
        } else if (e.getSource()== pin) {
            setVisible(false);
            new PinChange(cardNo);
        } else if (e.getSource() == mini) {
            setVisible(false);
            new MiniStatement(cardNo);
        }
    }
}
