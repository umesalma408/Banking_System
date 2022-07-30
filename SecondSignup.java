package com.Bank_ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SecondSignup extends JFrame implements ActionListener {

    JTextField panTextfied,aadharTextfied;

    JRadioButton Syes,Sno,eyes,eno;
    JComboBox religion1,category1,education1,income1,occupation1;

    String formno1;
    SecondSignup(String formno){
        this.formno1=formno;
        setLayout(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.black));
        setTitle(" New Account Application Form ");

        JLabel additionaldetail=new JLabel("Page 2: Additional Detail");
        additionaldetail.setFont(new Font("railway",Font.BOLD,22));
        additionaldetail.setBounds(290,60,400,30);
        add(additionaldetail);

        JLabel religion=new JLabel("Religion : ");
        religion.setFont(new Font("railway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);

        String[] valreligion={"Hindu","Muslim","Shikh","Christian","Other"};
         religion1=new JComboBox<>(valreligion);
        religion1.setFont(new Font("railway",Font.PLAIN,14));
        religion1.setBounds(300,140,400,30);
        religion1.setBackground(Color.white);
        add(religion1);


        JLabel category=new JLabel("Category : ");
        category.setFont(new Font("railway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        String[] valcategory={"General","OBC","SC","ST","Other"};
         category1=new JComboBox<>(valcategory);
        category1.setFont(new Font("railway",Font.PLAIN,14));
        category1.setBounds(300,190,400,30);
        category1.setBackground(Color.white);
        add(category1);


        JLabel income=new JLabel("Income: ");
        income.setFont(new Font("railway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);

        String[] incomecategory={"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
         income1=new JComboBox<>(incomecategory);
        income1.setFont(new Font("railway",Font.PLAIN,14));
        income1.setBounds(300,240,400,30);
        income1.setBackground(Color.white);
        add(income1);


        JLabel education=new JLabel("Educational : ");
        education.setFont(new Font("railway",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        JLabel qualification=new JLabel("Qualification : ");
        qualification.setFont(new Font("railway",Font.BOLD,20));
        qualification.setBounds(100,325,200,30);
        add(qualification);

        String[] educationcategory={"None Graduate","Graduate","Post Graduate","Doctorate","Other"};
         education1=new JComboBox<>(educationcategory);
        education1.setFont(new Font("railway",Font.PLAIN,14));
        education1.setBounds(300,300,400,30);
        education1.setBackground(Color.white);
        add(education1);


        JLabel occupation=new JLabel("Occupation: ");
        occupation.setFont(new Font("railway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);

        String[] occupationcategory={"Salaried ","Business"," Student","Retired","Other"};
         occupation1=new JComboBox<>(occupationcategory);
        occupation1.setFont(new Font("railway",Font.PLAIN,14));
        occupation1.setBounds(300,390,400,30);
        occupation1.setBackground(Color.white);
        add(occupation1);


        JLabel pan=new JLabel("PAN Number : ");
        pan.setFont(new Font("railway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);

        panTextfied=new JTextField();
        panTextfied.setFont(new Font("railway",Font.PLAIN,14));
        panTextfied.setBounds(300,440,400,30);
        add(panTextfied);

        JLabel aadhar=new JLabel("Aadhar Number : ");
        aadhar.setFont(new Font("railway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);

        aadharTextfied=new JTextField();
        aadharTextfied.setFont(new Font("railway",Font.PLAIN,14));
        aadharTextfied.setBounds(300,490,400,30);
        add(aadharTextfied);

        JLabel citizen=new JLabel("Senior Citizen: ");
        citizen.setFont(new Font("railway",Font.BOLD,20));
        citizen.setBounds(100,540,200,30);
        add(citizen);

        Syes=new JRadioButton("Yes");
        Syes.setFont(new Font("railway",Font.PLAIN,20));
        Syes.setBounds(300,540,60,30);
        add(Syes);

        Sno=new JRadioButton("No");
        Sno.setFont(new Font("railway",Font.PLAIN,20));
        Sno.setBounds(440,540,60,30);
        add(Sno);

        ButtonGroup citizen1=new ButtonGroup();
        citizen1.add(Syes);
        citizen1.add(Sno);


        JLabel existing=new JLabel("Existing Account: ");
        existing.setFont(new Font("railway",Font.BOLD,20));
        existing.setBounds(100,590,200,30);
        add(existing);

        eyes=new JRadioButton("Yes");
        eyes.setFont(new Font("railway",Font.PLAIN,20));
        eyes.setBounds(300,590,60,30);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setFont(new Font("railway",Font.PLAIN,20));
        eno.setBounds(440,590,60,30);
        add(eno);

        ButtonGroup existing1=new ButtonGroup();
        existing1.add(eyes);
        existing1.add(eno);


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
        new SecondSignup("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=formno1;
        String religion=(String) religion1.getSelectedItem();
        String category=(String) category1.getSelectedItem();
        String Income=(String) income1.getSelectedItem();
        String education=(String) education1.getSelectedItem();
        String occupation=(String) occupation1.getSelectedItem();

        String senior=null;
        if(Syes.isSelected()){
            senior="Yes";
        }
        else if(Sno.isSelected()){
            senior="No";
        }

        String existing=null;
        if(eyes.isSelected()){
            existing="Yes";
        }
        else if(eno.isSelected()){
            existing="Unmarried";
        }

        String pan=panTextfied.getText();
        String aadhar=aadharTextfied.getText();

        try{
                conn C=new conn();
                String query="Insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+Income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+existing+"','"+senior+"')";
                int m;
                m = C.s.executeUpdate(query);
                if(m==1){
                    System.out.println("Update sucessfull");
                    setVisible(false);
                    new ThirdSignup(formno);

                }
                else{
                    System.out.println("Update Failed");
                }

        } catch(Exception e1){
            System.out.println("error");
        }
    }
}

