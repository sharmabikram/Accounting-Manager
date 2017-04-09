/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
   private String JDBC_DRIVER;
   private String dbURL;
   private String user;
   private String password;
   private Connection conn;
   
   public MyConnection(){
       JDBC_DRIVER = "com.mysql.jdbc.Driver";
       dbURL = "jdbc:mysql://localhost/rks";
       user = "root";
       password = "bikram";
       conn = null;
   }
   
   public void openConnection(){
       try{
           Class.forName(JDBC_DRIVER).newInstance();
           System.out.println("Connectiong...");
           conn = DriverManager.getConnection(dbURL, user, password); 
           System.out.println("Success");
       }catch(Exception e){
           System.out.println("in openConnection");
           e.printStackTrace();
       }
   }
   
   public void closeConnection(){
       try{
           if(conn != null)
               conn.close();
           System.out.println("closing");
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   public Connection getConnection(){
       return conn;
   }
}
