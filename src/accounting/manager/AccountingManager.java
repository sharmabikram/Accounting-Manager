/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import staffManagement.staffEntry;

/**
 *
 * @author lenovo
 */
public class AccountingManager extends JWindow{

    //static MainPage mainFrame;
    Connection conn;
    //AddNewStock add;
    MainPage mainFrame;
    staffEntry s;
    
    public AccountingManager(){
        JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.white);

    // Set the window's bounds, centering the window
    int width = 590;
    int height =370;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width+70,height);

    // Build the splash screen
    JLabel label = new JLabel();
    label.setIcon(new ImageIcon(getClass().getResource("/extras/giflogo.gif")));
    
    JLabel copyrt = new JLabel
      ("RKS Accounts", JLabel.CENTER);
    copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
    content.add(label, BorderLayout.CENTER);
    content.add(copyrt, BorderLayout.SOUTH);
    Color oraRed = new Color(156, 20, 20,  255);
    content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

    // Display it
    setVisible(true);
    // Wait a little while, maybe while loading resources
    

    
    }
    
    public static void main(String[] args) {
        AccountingManager driverObject = new AccountingManager();
        
       
        ConnectionObject.myConn.openConnection();
        driverObject.conn = ConnectionObject.myConn.getConnection();
        
        driverObject.init();
        try { Thread.sleep(10000); } catch (Exception e) {}
        driverObject.dispose();
        driverObject.mainFrame = new MainPage();
        driverObject.setVisible(false);
        driverObject.mainFrame.setVisible(true);
        /*try {
            driverObject.checkTrail();
           
        } catch (Exception ex) {
            Logger.getLogger(AccountingManager.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
    }

    private void init() {
        try{
            Statement stmt = conn.createStatement();
            stmt.execute("create database if not exists ramkumartest");
            ConnectionObject.myConn.closeConnection();
            
            ConnectionObject.myConn.changeURL("jdbc:mysql://localhost/ramkumarTest");
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
            
            stmt.execute("create table if not exists cdetail(cname varchar(30) primary key, phone char(11), address varchar(80), photo mediumblob)");
            stmt.execute("create table if not exists cmoneydetail(cname varchar(30), amount float, tarik dateTime)");
            stmt.execute("create TABLE if not EXISTS cprofit (cname varchar(25), invested float, profit float, startDate dateTime, endDate dateTime)");
        }catch(Exception e){
            e.printStackTrace();
        }
     }
/* private void checkTrail() throws Exception{
    stmt.execute("CREATE TABLE IF NOT EXISTS buyme(buy char(1), pkey char(20), expire char(1))");
            rs = stmt.executeQuery("select * from buyme");
            if(!rs.next()){
                stmt.execute("insert into buyme values('f', 'SBIKRAM_ACCOUNT_2017', 'f')");
            }
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
    }  */
   
}
