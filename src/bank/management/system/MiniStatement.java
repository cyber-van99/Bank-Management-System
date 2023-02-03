package bank.management.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    String cardNo;
    JButton exit;

    MiniStatement(String cardNo){
        setLayout(null);
        this.cardNo = cardNo;
        JLabel text = new JLabel("Mini Statement".toUpperCase());
        text.setBounds(100,20,200,25);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setForeground(Color.BLACK);
        add(text);

        JLabel card = new JLabel("");
        card.setBounds(60,80,500,400);
        add(card);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where cardNo= '"+cardNo+"' order by cardNo desc limit 5");
            while(rs.next()){

                card.setText(card.getText()+"<html> Card Number: "+rs.getString("cardNo")+"|Amount: "+rs.getString("amount")+"|Date: "+rs.getString("date")+"" +
                        "|Type: "+rs.getString("type")+"<hr><br><html>");
            }
        }catch (Exception se){
            System.out.println(se);
        }

        exit = new JButton("EXIT");
        exit.setBounds(100,400,150,30);
        add(exit);
        exit.addActionListener(this);

        setSize(600,500);
        setLocation(300,20);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == exit){
        setVisible(false);
        new Transactions("","");
    }
    }
}
