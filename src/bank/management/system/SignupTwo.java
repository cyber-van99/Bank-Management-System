package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField incomeField,eduField,panField,aadharField;
    JButton next;
    JRadioButton yes,no,yes2,no2;
    JComboBox religionField,occField,categoryField;
    String formno;


    SignupTwo(String formNo){
        setLayout(null);

        this.formno = formNo;

        JLabel addDetails = new JLabel("ADDITIONAL DETAILS:");
        addDetails.setFont(new Font("Raleway",Font.BOLD,30));
        addDetails.setBounds(150,20,600,40);
        add(addDetails);

        JLabel formDetail = new JLabel("Page no: 2, Other details");
        formDetail.setFont(new Font("Raleway",Font.BOLD,20));
        formDetail.setBounds(150,60,600,40);
        add(formDetail);

        JLabel religion = new JLabel("Religion:" );
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(150,120,200,40);
        add(religion);

        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionField = new JComboBox(valReligion);
        religionField.setFont(new Font("Raleway", Font.BOLD,14));
        religionField.setBounds(320,120,400,30);
        add(religionField);

        JLabel category = new JLabel("Category" );
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(150,160,200,40);
        add(category);

        String categoryArr[] ={"Open","OBC","SC/ST","VJ-NT","Tribal","Other"};
        categoryField = new JComboBox(categoryArr);
        categoryField.setFont(new Font("Raleway", Font.BOLD,14));
        categoryField.setBounds(320,160,400,30);
        add(categoryField);

        JLabel income = new JLabel("Income" );
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(150,200,200,40);
        add(income);

        incomeField = new JTextField();
        incomeField.setFont(new Font("Raleway", Font.BOLD,14));
        incomeField.setBounds(320,200,400,30);
        add(incomeField);

        JLabel education = new JLabel("Education:" );
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(150,240,200,40);
        add(education);

        eduField = new JTextField();
        eduField.setFont(new Font("Raleway", Font.BOLD,14));
        eduField.setBounds(320,240,400,30);
        add(eduField);

        JLabel occupation = new JLabel("Occupation:" );
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(150,280,200,40);
        add(occupation);

        String occArr[] = {"Government Employee","Salaried Non-Government","Business","Not Working","Other"};
        occField = new JComboBox(occArr);
        occField.setFont(new Font("Raleway", Font.BOLD,14));
        occField.setBounds(320,280,400,30);
        add(occField);

        JLabel pan = new JLabel("PAN number:" );
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(150,320,200,40);
        add(pan);

        panField = new JTextField();
        panField.setFont(new Font("Raleway", Font.BOLD,14));
        panField.setBounds(320,320,400,30);
        add(panField);

        JLabel aadhar = new JLabel("Aadhaar Number:" );
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(150,360,200,40);
        add(aadhar);

        aadharField = new JTextField();
        aadharField.setFont(new Font("Raleway", Font.BOLD,14));
        aadharField.setBounds(320,360,400,30);
        add(aadharField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(150,400,200,40);
        add(senior);

        yes =  new JRadioButton("Yes");
        yes.setBounds(320,400,100,40);
        yes.setBackground(Color.white);
        add(yes);

        no =  new JRadioButton("No");
        no.setBounds(420,400,100,40);
        no.setBackground(Color.white);
        add(no);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(yes);
        seniorGroup.add(no);


        JLabel existing = new JLabel("Existing Number:" );
        existing.setFont(new Font("Raleway",Font.BOLD,20));
        existing.setBounds(150,440,200,40);
        add(existing);

        yes2 =  new JRadioButton("Yes");
        yes2.setBounds(320,440,100,40);
        yes2.setBackground(Color.white);
        add(yes2);

        no2 =  new JRadioButton("No");
        no2.setBounds(420,440,100,40);
        no2.setBackground(Color.white);
        add(no2);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(yes2);
        existingGroup.add(no2);

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
        String religion = (String)religionField.getSelectedItem();
        String category = (String)categoryField.getSelectedItem();
        String income = incomeField.getText();
        String education = eduField.getText();
        String occupation = (String)occField.getSelectedItem();
        String pan = panField.getText();
        String aadhar = aadharField.getText();
        String senior = null;
        if(yes.isSelected()){
            senior = "yes";
        }else if(no.isSelected()){
            senior = "no";
        }

        String existing = null;
        if(yes2.isSelected()){
            existing = "yes";
        }else if(no2.isSelected()){
            existing = "no";
        }
        try{
            Conn c = new Conn();
            String query =  "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior+"'" +
                    ",'"+existing+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno);

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
