package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login,cancel,signup;
    JTextField cardField;
    JPasswordField pinField;
    Login(){
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,20,100,100);
        add(label);
        JLabel text = new JLabel("Welcome to Bank");
        text.setFont(new Font("Poppins",Font.BOLD,40));
        text.setBounds(260,40,500,50);
        add(text);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,30));
        card.setBounds(50,150,300,50);
        add(card);

        cardField = new JTextField();
        cardField.setBounds(260,150,325,40);
        cardField.setFont(new Font("Arial",Font.BOLD,20));
        add(cardField);

        JLabel pin = new JLabel("PIN Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,30));
        pin.setBounds(50,220,500,50);
        add(pin);

        pinField = new JPasswordField();
        pinField.setBounds(260,220,325,40);
        pinField.setFont(new Font("Arial",Font.BOLD,20));
        add(pinField);

        login =  new JButton("LOGIN");
        login.setBounds(260,270,150,30);
        login.addActionListener(this);
        add(login);

        cancel =  new JButton("CLEAR");
        cancel.setBounds(430,270,155,30);
        cancel.addActionListener(this);
        add(cancel);

        signup =  new JButton("SIGN UP");
        signup.setBounds(260,320,325,30);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,400);
        setLocation(350,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String cardNo = cardField.getText();
            String pin = pinField.getText();
            try{
             Conn c = new Conn();
             String query = "select * from login where cardNumber='"+cardNo+"'and pin= '"+pin+"'";
                ResultSet res = c.s.executeQuery(query);
                if(res.next()){
                    setVisible(false);
                    new Transactions(cardNo,pin);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Credentials!");
                }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            cardField.setText("");
            pinField.setText("");
        }else{
            //sign up
            setVisible(false);
            new SignupOne();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
