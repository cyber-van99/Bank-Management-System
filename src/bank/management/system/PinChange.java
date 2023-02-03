package bank.management.system;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinChange;
    JButton exit,confirm;
    String cardNo;

    PinChange(String cardNo){

        setLayout(null);
        this.cardNo = cardNo;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JLabel text = new JLabel("PIN Change Menu".toUpperCase());
        text.setBounds(180,300,320,25);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setForeground(Color.white);
        image.add(text);

        pinChange = new JPasswordField();
        pinChange.setBounds(170,350,320,30);
        pinChange.setFont(new Font("System",Font.BOLD,22));
        image.add(pinChange);

        confirm = new JButton("CONFIRM");
        confirm.setBounds(355,450,150,30);
        image.add(confirm);
        confirm.addActionListener(this);

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
        if(e.getSource() ==  confirm){
            String newPin = pinChange.getText();
            if(newPin.isBlank()){
                JOptionPane.showMessageDialog(null,"Enter New PIN");
            }else{
                try{
                    Conn c = new Conn();
                    String query = "update login set pin = '"+newPin+"' where cardNumber = '"+cardNo+"'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"The PIN was changed");
                    setVisible(false);
                    new Login();
                }catch (Exception se){
                    System.out.println(se);
                }
            }

        }else {
            setVisible(false);
            new Transactions(cardNo,"");
        }
    }
}
