package com.Bank_ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton widrawl,back;
    String pinno;
    public withdrawl(String pinno){
        this.pinno=pinno;
        setLayout(null);

        setUndecorated(true);
        ImageIcon atm=new ImageIcon("src/com/Bank_ATM_Management/atm.jpg");
        Image I3 = atm.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon I4=new ImageIcon(I3);
        JLabel image=new JLabel( I4);
        image.setBounds(   0,0,900,900);
        add(image);

        JLabel text=new JLabel( "Enter Amount you want to Withdraw ");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.white);
        text.setFont(new Font("Railway",Font.BOLD,20));
        image.add(text);

        amount=new JTextField();
        amount.setForeground(Color.BLACK);
        amount.setFont(new Font("Railway",Font.PLAIN,20));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        widrawl=new JButton("Withdraw");
        widrawl.setForeground(Color.BLACK);
        widrawl.setBackground(Color.white);
        widrawl.addActionListener(this);
        widrawl.setFont(new Font("Railway",Font.BOLD,15));
        widrawl.setBounds(355,485,150,30);
        image.add(widrawl);


        back=new JButton("< Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.white);
        back.addActionListener(this);
        back.setFont(new Font("Railway",Font.BOLD,15));
        back.setBounds(355,450,150,30);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        new withdrawl("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==widrawl){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the amount You want to WithDrawl ");
            }else {
                try {
                    conn con = new conn();
                    String query = "Insert into bank values('" + pinno + "','" + date + "','withdrow','" + number + "')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" withdrow Sucessfully..");
                    setVisible(false);
                    new Transaction(pinno).setVisible(true);
                }catch (Exception e1){
                    System.out.println(e1);
                }
            }
        }
        else if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }
    }
}

