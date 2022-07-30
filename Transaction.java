package com.Bank_ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposite,whithdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinno;
    public Transaction(String pinNo){
        this.pinno=pinNo;
        setLayout(null);
//        adding Background image
        ImageIcon atm=new ImageIcon("src/com/Bank_ATM_Management/atm.jpg");
        Image I3 = atm.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon I4=new ImageIcon(I3);
        JLabel image=new JLabel( I4);
        image.setBounds(   0,0,900,900);
        add(image);

        JLabel text=new JLabel("Selecte Your Transaction");
        text.setBounds(220,300,700,35);
        text.setFont(new Font("Railway",Font.BOLD,20));
        text.setForeground(Color.white);
        image.add(text);

        deposite=new JButton("Deposite");
        deposite.setBounds(170,415,150,30);
        deposite.setFont(new Font("Railway",Font.BOLD,14));
        deposite.addActionListener(this);
        deposite.setForeground(Color.BLACK);
        deposite.setBackground(Color.WHITE);
        image.add(deposite);

        whithdrawl=new JButton("Withdrawl");
        whithdrawl.setBounds(355,415,150,30);
        whithdrawl.setFont(new Font("Railway",Font.BOLD,14));
        whithdrawl.addActionListener(this);
        whithdrawl.setForeground(Color.BLACK);
        whithdrawl.setBackground(Color.WHITE);
        image.add(whithdrawl);

        fastcash=new JButton("Fastcash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        fastcash.setFont(new Font("Railway",Font.BOLD,14));
        fastcash.setForeground(Color.BLACK);
        fastcash.setBackground(Color.WHITE);
        image.add(fastcash);

        ministatement=new JButton("Ministatement");
        ministatement.setBounds(355,450,150,30);
        ministatement.setFont(new Font("Railway",Font.BOLD,14));
        ministatement.addActionListener(this);
        ministatement.setForeground(Color.BLACK);
        ministatement.setBackground(Color.WHITE);
        image.add(ministatement);

        pinchange=new JButton("PIN change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        pinchange.setFont(new Font("Railway",Font.BOLD,14));
        pinchange.setForeground(Color.BLACK);
        pinchange.setBackground(Color.WHITE);
        image.add(pinchange);

        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        balanceenquiry.setFont(new Font("Railway",Font.BOLD,14));
        balanceenquiry.setForeground(Color.BLACK);
        balanceenquiry.setBackground(Color.WHITE);
        image.add(balanceenquiry);

        exit=new JButton("Exit");
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
        new Transaction("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }
        else if(e.getSource()==deposite){
            setVisible(false);
            new Deposite(pinno).setVisible(true);
        }
        else if(e.getSource()==whithdrawl){
            setVisible(false);
            new withdrawl(pinno).setVisible(true);
        }
        else if(e.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pinno).setVisible(true);
        }
        else if(e.getSource()==pinchange){
            setVisible(false);
            new Pinchange(pinno).setVisible(true);
        }
        else if(e.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinno).setVisible(true);
        }
        else if(e.getSource()==ministatement){
            setVisible(false);
            new Ministatement(pinno).setVisible(true);
        }
    }
}
