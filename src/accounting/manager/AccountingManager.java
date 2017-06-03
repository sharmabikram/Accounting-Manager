/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import staffManagement.staffEntry;

/**
 *
 * @author lenovo
 */
public class AccountingManager {

    //static MainPage mainFrame;
    Connection conn;
    //AddNewStock add;
    MainPage mainFrame;
    staffEntry s;
    
    public static void main(String[] args) {
        AccountingManager driverObject = new AccountingManager();
        
        ConnectionObject.myConn.openConnection();
        driverObject.conn = ConnectionObject.myConn.getConnection();
        
        driverObject.init();
        driverObject.mainFrame = new MainPage();
        driverObject.mainFrame.setVisible(true);
        try {
            driverObject.checkTrail();
           
        } catch (Exception ex) {
            Logger.getLogger(AccountingManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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
            stmt.execute("create table if not exists stock(id int auto_increment primary key, itemName varchar(40), price float, quantity float, photo longblob)");
            stmt.execute("create table if not exists profitTable(itemName varchar(40), profit float, qty_sold float)");
            stmt.execute("create table if not exists profitMonth(itemName varchar(40), profit float, month char(5), year int, qty_sold float)");
            stmt.execute("create table if not exists currMonth(month char(5), curyear int, netSell float)");
            ResultSet rs = stmt.executeQuery("select * from currMonth");
            if(!rs.next()){
                PreparedStatement ps = conn.prepareStatement("insert into currMonth values(?, ?, ?)");
                java.util.Date date= new java.util.Date();
                Calendar cal = new GregorianCalendar();
                cal.setTime(date);
                int year = cal.get(Calendar.YEAR);

                int mnth = cal.get(Calendar.MONTH) ;
                ps.setString(1, Month.month[mnth]);
                ps.setInt(2, year);
                ps.setInt(3, 0);
                ps.execute();
                //stmt.execute("insert into currMonth values('JAN', 2017, 0)");
            }
            
            stmt.execute("create table if not exists admin(userName varchar(5), pass varchar(5))");
            rs = stmt.executeQuery("select * from admin");
            if(!rs.next()){
                stmt.execute("insert into admin values('admin', 'admin')");
            }
            stmt.execute("create table if not exists sell(month char(5), year int, selling float)");
            stmt.execute("CREATE TABLE if not EXISTS staffDetail(sname varchar(20), phone char(11), rateh float, ratef float, address varchar(70), amtDue float, image longblob)");
            stmt.execute("CREATE TABLE if not EXISTS moneydetail (sname varchar(20), amount float, tarik dateTime)");
            stmt.execute("CREATE TABLE IF NOT EXISTS buyme(buy char(1), pkey char(20), expire char(1))");
            rs = stmt.executeQuery("select * from buyme");
            if(!rs.next()){
                stmt.execute("insert into buyme values('f', 'SBIKRAM_ACCOUNT_2017', 'f')");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
     }

    private void checkTrail() throws Exception{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from buyme");
        String buy, expire;
        String key;
        rs.next();
        buy = rs.getString("buy");
        if(buy.equalsIgnoreCase("t"))
            return ;
        
        expire = rs.getString("expire");
        if(expire.equalsIgnoreCase("t")){
            mainFrame.setEnabled(false);
            new MyTools.GiveLic(mainFrame).setVisible(true);
        }
       // System.out.println("here");
        Calendar ex = Calendar.getInstance();
        //Date dt;
        ex.set(2017, 6, 20);
        //LocalDate localDate = LocalDate.now();
        
       // System.out.println(localDate);
        if(Calendar.getInstance().after(ex)){
          //  System.out.println("here");
            stmt.execute("update buyme set expire = \"t\"");
        }
    }  
}
