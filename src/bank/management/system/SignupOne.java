package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    int formNo;
    JTextField nameField,fatherNameField,emailField,addressField,cityField,stateField,pinField;
    JButton next;
    JRadioButton male,female,single,married;
    JDateChooser dateChooser;


    SignupOne(){
        setLayout(null);

        Random ran =  new Random();
        formNo = Math.abs(ran.nextInt() % 8000);

        JLabel formno = new JLabel("APPLICATION FORM NO:" + formNo);
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        formno.setBounds(150,20,600,40);
        add(formno);

        JLabel formDetail = new JLabel("Page no: 1, Personal Details");
        formDetail.setFont(new Font("Raleway",Font.BOLD,20));
        formDetail.setBounds(150,60,600,40);
        add(formDetail);

        JLabel name = new JLabel("Name:" );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(150,120,200,40);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Raleway", Font.BOLD,14));
        nameField.setBounds(300,120,400,30);
        add(nameField);

        JLabel fatherName = new JLabel("Father's Name:" );
        fatherName.setFont(new Font("Raleway",Font.BOLD,20));
        fatherName.setBounds(150,160,200,40);
        add(fatherName);

        fatherNameField = new JTextField();
        fatherNameField.setFont(new Font("Raleway", Font.BOLD,14));
        fatherNameField.setBounds(300,160,400,30);
        add(fatherNameField);

        JLabel dob = new JLabel("Date of Birth:" );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(150,200,200,40);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,200,400,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:" );
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(150,240,200,40);
        add(gender);

        male =  new JRadioButton("Male");
        male.setBounds(300,240,100,40);
        male.setBackground(Color.white);
        add(male);

        female =  new JRadioButton("Female");
        female.setBounds(420,240,100,40);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(female);
        genderGroup.add(male);

        JLabel email = new JLabel("Email ID:" );
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(150,280,200,40);
        add(email);

        emailField = new JTextField();
        emailField.setFont(new Font("Raleway", Font.BOLD,14));
        emailField.setBounds(300,280,400,30);
        add(emailField);

        JLabel marital = new JLabel("Marital Status:" );
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(150,320,200,40);
        add(marital);

        single =  new JRadioButton("Single");
        single.setBounds(300,320,100,40);
        single.setBackground(Color.white);
        add(single);

        married =  new JRadioButton("Married");
        married.setBounds(420,320,100,40);
        married.setBackground(Color.white);
        add(married);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(single);
        maritalGroup.add(married);

        JLabel address = new JLabel("Address:" );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(150,360,200,40);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("Raleway", Font.BOLD,14));
        addressField.setBounds(300,360,400,30);
        add(addressField);

        JLabel city = new JLabel("City:" );
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(150,400,200,40);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Raleway", Font.BOLD,14));
        cityField.setBounds(300,400,400,30);
        add(cityField);

        JLabel state = new JLabel("State:" );
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(150,440,200,40);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("Raleway", Font.BOLD,14));
        stateField.setBounds(300,440,400,30);
        add(stateField);

        JLabel pincode = new JLabel("Pincode:" );
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(150,480,200,40);
        add(pincode);

        pinField = new JTextField();
        pinField.setFont(new Font("Raleway", Font.BOLD,14));
        pinField.setBounds(300,480,400,30);
        add(pinField);

        next = new JButton("NEXT");
        next.setBounds(600,600,100,40);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+(formNo);
        String name = nameField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String fatherName = fatherNameField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String state = stateField.getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }

        String email = emailField.getText();
        String maritalStatus = null;
        if(single.isSelected()){
            maritalStatus = "Single";
        }else if(married.isSelected()){
            maritalStatus = "Married";
        }
        String pincode = pinField.getText();

        try{
                Conn c = new Conn();
                String query =  "insert into signup values('"+formno+"','"+name+"','"+fatherName+"','"+maritalStatus+"','"+dob+"','"+gender+"','"+email+"','"+address+"'" +
                        ",'"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno);

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
