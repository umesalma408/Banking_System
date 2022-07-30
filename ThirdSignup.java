package com.Bank_ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ThirdSignup extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton submit,cancel;

    String formno;
    public  ThirdSignup(String formno){
        this.formno=formno;
        setLayout(null);
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.black));

        JLabel L1=new JLabel("Page 3: Account Detail");
        L1.setFont(new Font("Railway",Font.BOLD,26));
        L1.setBounds(200,40,400,40);
        add(L1);

        JLabel type=new JLabel("Account Type : ");
        type.setFont(new Font("Railway",Font.BOLD,22));
        type.setBounds(100,130,400,30);
        add(type);

        r1=new JRadioButton("Saving Accouunt ");
        r1.setFont(new Font("Railway",Font.BOLD,18));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,200,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Railway",Font.BOLD,18));
        r2.setBackground(Color.white);
        r2.setBounds(350,180,300,20);
        add(r2);

        r3=new JRadioButton("Current Account ");
        r3.setFont(new Font("Railway",Font.BOLD,18));
        r3.setBackground(Color.white);
        r3.setBounds(100,220,200,20);
        add(r3);

        r4=new JRadioButton("Recurring Deposite Account ");
        r4.setFont(new Font("Railway",Font.BOLD,18));
        r4.setBackground(Color.white);
        r4.setBounds(350,220,300,20);
        add(r4);

        ButtonGroup accounts=new ButtonGroup();
        accounts.add(r1);
        accounts.add(r2);
        accounts.add(r3);
        accounts.add(r4);

        JLabel card=new JLabel("Card Number : ");
        card.setFont(new Font("Railway",Font.BOLD,22));
        card.setBounds(100,280,400,30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-8408 ");
        number.setFont(new Font("Railway",Font.BOLD,22));
        number.setBounds(300,280,400,30);
        add(number);

        JLabel carddetail=new JLabel("This is your 16 digit Card Number : ");
        carddetail.setFont(new Font("Railway",Font.PLAIN,15));
        carddetail.setBounds(100,310,400,30);
        add(carddetail);

        JLabel pin=new JLabel("PIN : ");
        pin.setFont(new Font("Railway",Font.BOLD,22));
        pin.setBounds(100,360,400,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Railway",Font.BOLD,22));
        pnumber.setBounds(300,360,400,30);
        add(pnumber);

        JLabel pindetail=new JLabel("This is your 4 digit PIN Number : ");
        pindetail.setFont(new Font("Railway",Font.PLAIN,15));
        pindetail.setBounds(100,390,400,30);
        add(pindetail);

        JLabel service=new JLabel("Services Required : ");
        service.setFont(new Font("Railway",Font.BOLD,22));
        service.setBounds(100,450,400,30);
        add(service);

        c1=new JCheckBox("ATM Card ");
        c1.setFont(new Font("Railway",Font.BOLD,18));
        c1.setBackground(Color.white);
        c1.setBounds(100,500,200,20);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Railway",Font.BOLD,18));
        c2.setBackground(Color.white);
        c2.setBounds(350,500,200,20);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Railway",Font.BOLD,18));
        c3.setBackground(Color.white);
        c3.setBounds(100,550,200,20);
        add(c3);

        c4=new JCheckBox("Email& SMS Alert");
        c4.setFont(new Font("Railway",Font.BOLD,18));
        c4.setBackground(Color.white);
        c4.setBounds(350,550,200,20);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Railway",Font.BOLD,18));
        c5.setBackground(Color.white);
        c5.setBounds(100,600,200,20);
        add(c5);

        c6=new JCheckBox("E-Statement ");
        c6.setFont(new Font("Railway",Font.BOLD,18));
        c6.setBackground(Color.white);
        c6.setBounds(350,600,200,20);
        add(c6);

        c7=new JCheckBox("Here by declares that the above entered dtails are are correct to the best of my Knowledge ");
        c7.setFont(new Font("Railway",Font.BOLD,15));
        c7.setBackground(Color.white);
        c7.setBounds(100,650,700,20);
        add(c7);

        submit=new JButton(" Submit");
        submit.setFont(new Font("Railway",Font.BOLD,14));
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        submit.setForeground(Color.white);
        submit.setBounds(250,700,100,30);
        add(submit);

        cancel=new JButton(" Cancel");
        cancel.setFont(new Font("Railway",Font.BOLD,14));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setBounds(500,700,100,30);
        add(cancel);


        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setResizable(false);
        setSize(850,800);
        setLocation(350,10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new ThirdSignup(" ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String accounttype=null;
            if(r1.isSelected()){
                accounttype="Saving Account";
            }
            if(r2.isSelected()){
                accounttype="Fixed Deposite Account";
            }
            if(r3.isSelected()){
                accounttype="Current Account";
            }
            if(r4.isSelected()){
                accounttype="Recurring Deposite Account";
            }
            Random random=new Random();
            String cardnumber=""+Math.abs ((random.nextLong()%90000000L)+5040936000000000L);
            String pinnumber=""+Math.abs ((random.nextLong()%9000L)+1000L);

            String facilities="";
            if(c1.isSelected()){
                facilities=facilities+"ATM Card";
            }
            else if(c2.isSelected()){
                facilities=facilities+"Internet Banking";
            }
            else if(c3.isSelected()){
                facilities=facilities+"Mobile Banking";
            }
            else if(c4.isSelected()){
                facilities=facilities+"Email &SMS alert";
            }
            else if(c5.isSelected()){
                facilities=facilities+"Cheque Book";
            }
            else if(c6.isSelected()){
                facilities=facilities+"E-Statement";
            }

            if(c7.isSelected()==false){
                JOptionPane.showMessageDialog(null,"Declaration Required");
            }
            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is Required");
                }
                else{
                    conn C=new conn();
                    String query="Insert into signup3 values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facilities+"')";
                    String query1="Insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

                    JOptionPane.showMessageDialog(null,"Card Number "+cardnumber+"\n PIN "+pinnumber);
                    int m;
                    m = C.s.executeUpdate(query);
                    if(m==1){
                        JOptionPane.showMessageDialog(null,"Account created Sucessfully");
                    }
                    else{
                        System.out.println("Update Failed");
                    }
                    int n=C.s.executeUpdate(query1);
                    setVisible(false);
                    new Deposite(pinnumber).setVisible(true);
                }

            }
            catch (Exception e1){
                System.out.println(e1);
            }

        }
        else if(e.getSource()==cancel){
               setVisible(false);
               new Login().setVisible(true);
        }
    }
}
