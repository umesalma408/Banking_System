package com.Bank_ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    JButton deposite,whithdrawl,fastcash,Ministatement,pinchange,balanceenquiry,exit;
    String pinno;
    public Fastcash(String pinNo){
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

        JLabel text=new JLabel("Select Withdrawl Amount ");
        text.setBounds(220,300,700,35);
        text.setFont(new Font("Railway",Font.BOLD,20));
        text.setForeground(Color.white);
        image.add(text);

        deposite=new JButton("RS 100");
        deposite.setBounds(170,415,150,30);
        deposite.setFont(new Font("Railway",Font.BOLD,14));
        deposite.addActionListener(this);
        deposite.setForeground(Color.BLACK);
        deposite.setBackground(Color.WHITE);
        image.add(deposite);

        whithdrawl=new JButton("Rs 500");
        whithdrawl.setBounds(355,415,150,30);
        whithdrawl.setFont(new Font("Railway",Font.BOLD,14));
        whithdrawl.addActionListener(this);
        whithdrawl.setForeground(Color.BLACK);
        whithdrawl.setBackground(Color.WHITE);
        image.add(whithdrawl);

        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        fastcash.setFont(new Font("Railway",Font.BOLD,14));
        fastcash.setForeground(Color.BLACK);
        fastcash.setBackground(Color.WHITE);
        image.add(fastcash);

        Ministatement=new JButton("Rs 2000");
        Ministatement.setBounds(355,450,150,30);
        Ministatement.setFont(new Font("Railway",Font.BOLD,14));
        Ministatement.addActionListener(this);
        Ministatement.setForeground(Color.BLACK);
        Ministatement.setBackground(Color.WHITE);
        image.add(Ministatement);

        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        pinchange.setFont(new Font("Railway",Font.BOLD,14));
        pinchange.setForeground(Color.BLACK);
        pinchange.setBackground(Color.WHITE);
        image.add(pinchange);

        balanceenquiry=new JButton("Rs 10000");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        balanceenquiry.setFont(new Font("Railway",Font.BOLD,14));
        balanceenquiry.setForeground(Color.BLACK);
        balanceenquiry.setBackground(Color.WHITE);
        image.add(balanceenquiry);

        exit=new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        exit.setFont(new Font("Railway",Font.BOLD,14));
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.WHITE);
        image.add(exit);

        setVisible(true);
        setResizable(false);
        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new Fastcash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
            new  Transaction(pinno).setVisible(true);
        }
        else {
            String amount=((JButton)e.getSource()).getText().substring(3);
            conn c=new conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from Bank where PIN_No= '"+pinno+"'");
                long balance=0;
                while (rs.next()) {
                    if(rs.getString("Type").equals("Deposite")){
                        balance+=Integer.parseInt(rs.getString("Amount"));
                    }
                    else{
                        balance-=Integer.parseInt(rs.getString("Amount"));
                    }
                }
                if(e.getSource()!=exit && balance<Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null," Insufficient Balance..");
                    return;
                }
                Date date=new Date();
                String query="Insert into Bank values('"+pinno+"','"+date+"','withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Sucessfully..");
                setVisible(false);
                new Transaction(pinno).setVisible(true);
            }catch(Exception e1){
                System.out.println(e1);
            }
        }
    }
}
