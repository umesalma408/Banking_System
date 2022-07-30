package com.Bank_ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton Back;
    String pinno;
    public BalanceEnquiry(String pinNo){
        setUndecorated(true);
        this.pinno=pinNo;
        setLayout(null);
//        adding Background image
        ImageIcon atm=new ImageIcon("src/com/Bank_ATM_Management/atm.jpg");
        Image I3 = atm.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon I4=new ImageIcon(I3);
        JLabel image=new JLabel( I4);
        image.setBounds(   0,0,900,900);
        add(image);


        Back=new JButton("Back");
        Back.setBounds(355,520,150,30);
        Back.addActionListener(this);
        Back.setFont(new Font("Railway",Font.BOLD,14));
        Back.setForeground(Color.BLACK);
        Back.setBackground(Color.WHITE);
        image.add(Back);

        long balance=0;
        conn c=new conn();
        try{
            ResultSet rs=c.s.executeQuery("select * from Bank where PIN_No= '"+pinno+"'");

            while (rs.next()) {
                if(rs.getString("Type").equals("Deposite")){
                    balance+=Integer.parseInt(rs.getString("Amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("Amount"));
                }
            }
        }catch(Exception e1){
            System.out.println(e1);
        }

        JLabel text=new JLabel("Your Current Account Balance Is Rs "+ balance);
        text.setBounds(170,300,400,30);
        text.setFont(new Font("Railway",Font.BOLD,30));
        text.setForeground(Color.white);
        image.add(text);

        setVisible(true);
        setResizable(false);
        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }


    }
}
