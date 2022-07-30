package com.Bank_ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
//    JFrame frame;
    JButton login,signup,clear;
    JTextField cardfiled;
    JPasswordField Pinfiled;
    Login() {
//        frame = new JFrame();

        setLayout(null);
//        adding Background image
        ImageIcon Background=new ImageIcon("src/com/Bank_ATM_Management/Background Image.jpg");
        Image I3 = Background.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon I4=new ImageIcon(I3);
        JLabel backgroundlabel=new JLabel( I4);
        backgroundlabel.setBounds(   0,0,800,600);
        add(backgroundlabel);

//        set bankicon
        ImageIcon BankIcon=new ImageIcon("src/com/Bank_ATM_Management/bank-neon-label-vector-28002942.jpg");
        Image I1;
        I1 = BankIcon.getImage().getScaledInstance(200,100,Image.SCALE_DEFAULT);
        ImageIcon I2=new ImageIcon(I1);
        JLabel label=new JLabel(I2);
        label.setBounds(   30,10,100,100);
        getContentPane().setBackground(Color.blue);
        backgroundlabel.add(label);

//      Set Text
        JLabel text=new JLabel("Welcome to ATM");
        backgroundlabel.add(text);
        text.setFont(new Font("Oswald",Font.BOLD,38));
        Color c=new Color(216,62,6);
        text.setForeground(c);
        text.setBounds(200,40,400,40);

//      Card Number text
        JLabel CardNo=new JLabel("Card Number");
        backgroundlabel.add(CardNo);
        CardNo.setFont(new Font("Railway",Font.BOLD,30));
        CardNo.setForeground(c);
        CardNo.setBounds(120,150,200,40);

         cardfiled=new JTextField();
        cardfiled.setBounds(350,155,250,30);
        cardfiled.setFont(new Font("Arial",Font.PLAIN,19));
        backgroundlabel.add(cardfiled);

//     Pin Number text

        JLabel Pin_No=new JLabel("PIN Number");
        backgroundlabel.add(Pin_No);
        Pin_No.setFont(new Font("Roboto Slab",Font.BOLD,30));
        Pin_No.setForeground(c);
        Pin_No.setBounds(120,220,200,40);

       //textField
         Pinfiled=new JPasswordField();
        Pinfiled.setBounds(350,225,250,30);
        Pinfiled.setFont(new Font("Arial",Font.PLAIN,19));
        backgroundlabel.add(Pinfiled);

//        SignIn button
         login=new JButton("SIGN IN");
        login.setBounds(350,340,100,30);
        login.addActionListener(this);
        Color c5=new Color(38,63,191);
        login.setBackground(c5);
        login.setFont(new Font("Roboto Slab",Font.PLAIN,15));
        login.setForeground(Color.white);
        backgroundlabel.add(login);

         clear=new JButton("CLEAR");
        clear.setBounds(500,340,100,30);
        clear.setBackground(c5);
        clear.addActionListener(this);
        clear.setFont(new Font("Roboto Slab",Font.PLAIN,15));
        clear.setForeground(Color.white);
        backgroundlabel.add(clear);

         signup=new JButton("SignUp");
        signup.setBounds(350,400,250,30);
        signup.setBackground(c5);
        signup.addActionListener(this);
        signup.setFont(new Font("Roboto Slab",Font.BOLD,15));
        signup.setForeground(Color.white);
        backgroundlabel.add(signup);



        setTitle("AUTOMATED TELLER MACHINE");
        setVisible(true);
        setResizable(false);
        setSize(800,600);
        setLocation(350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            cardfiled.setText("");
            Pinfiled.setText("");
        }
        if(e.getSource()==login){
            try {
                conn con = new conn();
                String cardNumber = cardfiled.getText();
                String pinNumber = Pinfiled.getText();
                String query = "select * from login where Card_No='" + cardNumber + "' and Pin_No='" + pinNumber + "'";
                ResultSet m;
                m = con.s.executeQuery(query);
                if (m.next()) {
                    System.out.println("Update sucessfull");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } else {
                   JOptionPane.showMessageDialog(null,"Incorrect Card_Number Or PIN ");
                }
            }
            catch (Exception e1){
                System.out.println(e1);
            }
        }
        if(e.getSource()==signup){
            setVisible(false);
            new FirstSignup().setVisible(true);
        }
    }
}
