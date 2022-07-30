package com.Bank_ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class FirstSignup extends JFrame implements ActionListener {
    long ran;
    JTextField nameTextfied,fnameTextfied,emailTextfied,addressTextfied,cityTextfied,stateTextfied,pincodeTextfied;

    JRadioButton male,female,other,married,unmarried,other2;
    JDateChooser dateChooser;
    FirstSignup(){
        setLayout(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.black));

        Random random=new Random();
         ran=Math.abs((random.nextLong()%9000L)+1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO  "+ran);
        formno.setFont(new Font("railway",Font.BOLD,33));
        formno.setBounds(170,20,600,40);
        add(formno);

        JLabel personaldetail=new JLabel("Page 1: Personal Detail");
        personaldetail.setFont(new Font("railway",Font.BOLD,22));
        personaldetail.setBounds(290,80,400,30);
        add(personaldetail);

        JLabel name=new JLabel("Name : ");
        name.setFont(new Font("railway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

         nameTextfied=new JTextField();
        nameTextfied.setFont(new Font("railway",Font.PLAIN,15));
        nameTextfied.setBounds(300,140,400,30);
        add(nameTextfied);


        JLabel fathersname=new JLabel("Father's Name : ");
        fathersname.setFont(new Font("railway",Font.BOLD,20));
        fathersname.setBounds(100,190,200,30);
        add(fathersname);

         fnameTextfied=new JTextField();
        fnameTextfied.setFont(new Font("railway",Font.PLAIN,15));
        fnameTextfied.setBounds(300,190,400,30);
        add(fnameTextfied);


        JLabel dateofbirth=new JLabel("Date of Birth : ");
        dateofbirth.setFont(new Font("railway",Font.BOLD,20));
        dateofbirth.setBounds(100,240,200,30);
        add(dateofbirth);

         dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);

        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("railway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

         male=new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        male.setFont(new Font("Railway",Font.BOLD,18));
        male.setBackground(Color.white);
        add(male);

         female=new JRadioButton("Female");
        female.setBounds(460,290,100,30);
        female.setFont(new Font("Railway",Font.BOLD,18));
        female.setBackground(Color.white);
        add(female);


         other=new JRadioButton("Other ");
        other.setBounds(600,290,100,30);
        other.setFont(new Font("Railway",Font.BOLD,18));
        other.setBackground(Color.white);
        add(other);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
        buttonGroup.add(other);


        JLabel email=new JLabel("Email ID : ");
        email.setFont(new Font("railway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

         emailTextfied=new JTextField();
        emailTextfied.setFont(new Font("railway",Font.PLAIN,15));
        emailTextfied.setBounds(300,340,400,30);
        add(emailTextfied);

        JLabel Marital_status=new JLabel("Marital Status: ");
        Marital_status.setFont(new Font("railway",Font.BOLD,20));
        Marital_status.setBounds(100,390,200,30);
        add(Marital_status);

         married=new JRadioButton("Married ");
        married.setBounds(300,390,100,30);
        married.setFont(new Font("Railway",Font.BOLD,18));
        married.setBackground(Color.white);
        add(married);

         unmarried=new JRadioButton("UnMarried ");
        unmarried.setBounds(460,390,130,30);
        unmarried.setFont(new Font("Railway",Font.BOLD,18));
        unmarried.setBackground(Color.white);
        add(unmarried);

         other2=new JRadioButton("Other ");
        other2.setBounds(600,390,100,30);
        other2.setFont(new Font("Railway",Font.BOLD,18));
        other2.setBackground(Color.white);
        add(other2);

        ButtonGroup MeritalGroup=new ButtonGroup();
        MeritalGroup.add(married);
        MeritalGroup.add(unmarried);
        MeritalGroup.add(other2);

        JLabel address=new JLabel("Address : ");
        address.setFont(new Font("railway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

         addressTextfied=new JTextField();
        addressTextfied.setFont(new Font("railway",Font.PLAIN,15));
        addressTextfied.setBounds(300,440,400,30);
        add(addressTextfied);

        JLabel city=new JLabel("City : ");
        city.setFont(new Font("railway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

         cityTextfied=new JTextField();
        cityTextfied.setFont(new Font("railway",Font.PLAIN,15));
        cityTextfied.setBounds(300,490,400,30);
        add(cityTextfied);

        JLabel state=new JLabel("State: ");
        state.setFont(new Font("railway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

         stateTextfied=new JTextField();
        stateTextfied.setFont(new Font("railway",Font.PLAIN,15));
        stateTextfied.setBounds(300,540,400,30);
        add(stateTextfied);

        JLabel pincode=new JLabel("PIN Code: ");
        pincode.setFont(new Font("railway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

         pincodeTextfied=new JTextField();
        pincodeTextfied.setFont(new Font("railway",Font.PLAIN,15));
        pincodeTextfied.setBounds(300,590,400,30);
        add(pincodeTextfied);

        JButton next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Railway",Font.BOLD,15));
        next.setBounds(700,650,100,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setResizable(false);
        setSize(850,800);
        setLocation(350,10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new FirstSignup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=""+ran;
        String name=nameTextfied.getText();
        String fname=fnameTextfied.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        else{
            gender="Other";
        }
        String email=emailTextfied.getText();
        String marital;
        if(married.isSelected()){
            marital="Married";
        }
        else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        else{
            marital="Other";
        }
        String address=addressTextfied.getText();
        String city=cityTextfied.getText();
        String state=stateTextfied.getText();
        String pincode=pincodeTextfied.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else{
                conn C=new conn();
                String query="Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+marital+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                int m;
                m = C.s.executeUpdate(query);
                if(m==1){
                    System.out.println("Update sucessfull");
                    setVisible(false);
                    new SecondSignup(formno);
                }
                else{
                    System.out.println("Update Failed");
                }

            }

        } catch(Exception e1){
        System.out.println("error");
      }
    }
}
