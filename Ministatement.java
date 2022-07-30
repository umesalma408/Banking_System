package com.Bank_ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class Ministatement extends JFrame {
 ;
    String pinno;
    public Ministatement(String pinNo){

        this.pinno=pinNo;
        setLayout(null);




        JLabel text=new JLabel();
        text.setBounds(20,140,400,200);
        add(text);

        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,200,20);
        bank.setFont(new Font("Railway",Font.BOLD,20));
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,400,20);
        add(card);


        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from login where Pin_No= '"+pinno+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("Card_No").substring(0,4)+"XXXXXXXX"+rs.getString("Card_No").substring(12));
            }

        }catch(Exception e1){
            System.out.println(e1);
        }
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from Bank where PIN_No= '"+pinno+"'");
            while(rs.next()){
                text.setText(text.getText()+"<html>"+rs.getString("Date")+"&nbsp; &nbsp; &nbsp; &nbsp;"+rs.getString("Type")+"&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;"+rs.getString("Amount")+"<br><br></html>");
            }

        }catch(Exception e2){
            System.out.println(e2);
        }



        setResizable(false);
        setSize(400,600);
        setLocation(20,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        new Ministatement("");
    }
}


