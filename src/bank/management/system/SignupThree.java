package bank.management.system;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton fd,sv,rd,ca;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    Conn c = new Conn();

    SignupThree(String formno){
        setLayout(null);

        this.formno = formno;

        JLabel formDetails = new JLabel("Page 3: Account Details");
        formDetails.setFont(new Font("Raleway",Font.BOLD,30));
        formDetails.setBounds(250,10,600,40);
        add(formDetails);

        JLabel accType = new JLabel("Account Type:");
        accType.setBounds(150,40,200,50);
        accType.setFont(new Font("Raleway",Font.BOLD,20));
        add(accType);

        fd = new JRadioButton("Fixed Deposit");
        fd.setBounds(350,50,150,50);
        add(fd);

        sv = new JRadioButton("Savings Account");
        sv.setBounds(500,50,150,50);
        add(sv);

        ca = new JRadioButton("Current Account");
        ca.setBounds(350,90,150,50);
        add(ca);

        rd = new JRadioButton("Recurring Deposit");
        rd.setBounds(500,90,150,50);
        add(rd);

        ButtonGroup account = new ButtonGroup();
        account.add(rd);
        account.add(ca);
        account.add(fd);
        account.add(sv);

        JLabel cardNo = new JLabel("Card Number: XXXX-XXXX-XXXX-4124");
        cardNo.setBounds(150,150,600,50);
        cardNo.setFont(new Font("Roboto",Font.BOLD,20));
        add(cardNo);

        JLabel pinNo = new JLabel("PIN Number: XXXX");
        pinNo.setBounds(150,190,600,50);
        pinNo.setFont(new Font("Roboto",Font.BOLD,20));
        add(pinNo);

        JLabel services = new JLabel("Services");
        services.setBounds(150,250,200,50);
        services.setFont(new Font("Roboto",Font.BOLD,20));
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(200,300,300,50);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(500,300,250,50);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(200,340,250,50);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBounds(500,340,250,50);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(200,380,250,50);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(500,380,250,50);
        add(c6);

        c7 = new JCheckBox("I hereby declare that all the mentioned information is correct");
        c7.setFont(new Font("Raleway",Font.PLAIN,15));
        c7.setBounds(150,500,600,50);
        add(c7);


        submit = new JButton("SUBMIT");
        submit.setBounds(250,580,100,50);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(400,580,100,50);
        cancel.addActionListener(this);
        add(cancel);


        setSize(800,800);
        setLocation(350,20);
        setVisible(true);
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = this.formno;
        Random ran = new Random();
        String cardNumber =""+ Math.abs(ran.nextLong()%70000000+11);
        String pin = "0000";
        if(e.getSource() == submit){
            String accountType = null;
            if(fd.isSelected()){
                accountType = "Fixed Deposit";
            }else if(ca.isSelected()){
                accountType = "Current Account";
            }else if(sv.isSelected()){
                accountType = "Savings Account";
            } else if (rd.isSelected()) {
                accountType = "Reccurring Deposit";
            }else{
                JOptionPane.showMessageDialog(null,"Account Type is required!");
                return;
            }

            String services = "";
            if(c1.isSelected()){
                services = services + "ATM Card,";
            }
            if(c2.isSelected()){
                services = services + " Internet Banking,";
            }
            if(c3.isSelected()){
                services = services + " Mobile Banking,";
            }
            if(c4.isSelected()){
                services = services + " Email & SMS Alerts,";
            }
            if(c5.isSelected()){
                services = services + " Cheque Book,";
            }
            if(c6.isSelected()){
                services = services + " E-Statement";
            }

            if(!c7.isSelected()){
                JOptionPane.showMessageDialog(null,"Kindly accept the declaration");
            }else{
                try {

                    String query = "insert into signupthree values('"+formno+"','"+accountType+"','"+services+"','"+cardNumber+"','"+pin+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pin+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    String message = "Registration Successful!\nCard Number: "+cardNumber+ "\nRedirecting to Login Page...";
                    JOptionPane.showMessageDialog(null,message);
                    setVisible(false);
                    new Login();
                }catch (Exception ee){
                    System.out.println(ee);
                }
            }


        } else if(e.getSource() == cancel) {
                setVisible(false);
                new Login();
        }
    }
}
