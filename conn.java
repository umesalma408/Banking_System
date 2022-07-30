package com.Bank_ATM_Management;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            c= DriverManager.getConnection("jdbc:mysql:///BankManagementSystem","root","codeforinterview");
            s=c.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
