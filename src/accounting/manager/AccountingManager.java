/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class AccountingManager {

    //static MainPage mainFrame;
    Connection conn;
    //AddNewStock add;
    MainPage mainFrame;
    
    
    public static void main(String[] args) {
        AccountingManager driverObject = new AccountingManager();
        
        ConnectionObject.myConn.openConnection();
        driverObject.conn = ConnectionObject.myConn.getConnection();
        driverObject.init();
       // driverObject.createConnection();
        driverObject.mainFrame = new MainPage();
        driverObject.mainFrame.setVisible(true);
       // mainFrame.setEnabled(false);
       
       
    }

    private void init() {
        try{
            Statement stmt = conn.createStatement();
            stmt.execute("create database if not exists ramkumar");
            ConnectionObject.myConn.closeConnection();
            
            ConnectionObject.myConn.changeURL("jdbc:mysql://localhost/ramkumar");
            ConnectionObject.myConn.openConnection();
            conn = ConnectionObject.myConn.getConnection();
            stmt = conn.createStatement();
            stmt.execute("create table if not exists stock(id int auto_increment primary key, itemName varchar(20), price float, quantity float)");
            stmt.execute("create table if not exists profitTable(itemName varchar(20), profit float, qty_sold float)");
            stmt.execute("create table if not exists profitMonth(itemName varchar(20), profit float, month char(5), year int, qty_sold float)");
            stmt.execute("create table if not exists currMonth(month char(5), year int)");
            stmt.execute("insert into currMonth values('JAN', 2017)");
        }catch(Exception e){
            e.printStackTrace();
        }
     }
   
    
}
