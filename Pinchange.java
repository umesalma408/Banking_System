package com.Bank_ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame implements ActionListener {
    JPasswordField NewPinTextField,RNewPinTextField;
    JButton change,Back;
    String pinno;
   public Pinchange(String pinno){
       setUndecorated(true);
       this.pinno=pinno;
       setLayout(null);
       ImageIcon atm=new ImageIcon("src/com/Bank_ATM_Management/atm.jpg");
       Image I3 = atm.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon I4=new ImageIcon(I3);
       JLabel image=new JLabel( I4);
       image.setBounds(   0,0,900,900);
       add(image);

       setSize(900,900);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLocation(300,0);
       setResizable(false);
       setVisible(true);

       JLabel text=new JLabel( "Change your PIN ");
       text.setBounds(250,300,400,25);
       text.setForeground(Color.white);
       text.setFont(new Font("Railway",Font.BOLD,20));
       image.add(text);

       JLabel newPintext=new JLabel( "New PIN : ");
       newPintext.setBounds(165,350,200,20);
       newPintext.setForeground(Color.white);
       newPintext.setFont(new Font("Railway",Font.BOLD,18));
       image.add(newPintext);

       NewPinTextField=new JPasswordField();
       NewPinTextField.setFont(new Font("railway",Font.PLAIN,14));
       NewPinTextField.setBounds(300,350,200,25);
       image.add(NewPinTextField);


       JLabel RnewPintext=new JLabel( "Re_Enter PIN : ");
       RnewPintext.setBounds(165,390,200,20);
       RnewPintext.setForeground(Color.white);
       RnewPintext.setFont(new Font("Railway",Font.BOLD,18));
       image.add(RnewPintext);

       RNewPinTextField=new JPasswordField();
       RNewPinTextField.setFont(new Font("railway",Font.PLAIN,14));
       RNewPinTextField.setBounds(300,390,200,25);
       image.add(RNewPinTextField);

       change=new JButton("Change");
       change.setForeground(Color.BLACK);
       change.setBackground(Color.white);
       change.addActionListener(this);
       change.setFont(new Font("Railway",Font.BOLD,15));
       change.setBounds(355,485,150,30);
       image.add(change);

       Back=new JButton("<Back");
       Back.setForeground(Color.BLACK);
       Back.setBackground(Color.white);
       Back.addActionListener(this);
       Back.setFont(new Font("Railway",Font.BOLD,15));
       Back.setBounds(355,450,150,30);
       image.add(Back);


   }
   public static void main(String[] args){
       new Pinchange("").setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==change){
            try{
                String newpin=NewPinTextField.getText();
                String re_entered=RNewPinTextField.getText();
                if(!(re_entered.equals(newpin))){
                    JOptionPane.showMessageDialog(null," Pasword does not Match ReEnter ! ");
                    return;
                }
                if(newpin.equals("")){
                    JOptionPane.showMessageDialog(null," Please Enter New PIN ");
                    return;
                }
                if(re_entered.equals("")){
                    JOptionPane.showMessageDialog(null," Please Enter ReEnter PIN ");
                    return;
                }
                conn c=new conn();
                String query1="Update Bank set PIN_No='"+re_entered+"'where PIN_No='"+pinno+"'";
                String query2="Update login set Pin_No='"+re_entered+"'where Pin_No='"+pinno+"'";
                String query3="Update signup3 set Pin_No='"+re_entered+"'where Pin_No='"+pinno+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null," PIN Number Changed Sucessfully..");

                setVisible(false);
                new Transaction(pinno).setVisible(true);
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        }
        else if(e.getSource()==Back){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }
    }
}
