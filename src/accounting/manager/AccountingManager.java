/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class AccountingManager {

    Connection conn;
    AddNewStock add;
    MainPage mainFrame;
    private  void createConnection() {
        try{
            connector = new MyConnection();
            connector.openConnection();
            conn = connector.getConnection();
            System.out.println(conn.toString());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Server Error", "Error",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    MyConnection connector;
    
    public static void main(String[] args) {
        AccountingManager driverObject = new AccountingManager();
       // driverObject.createConnection();
        driverObject.mainFrame = new MainPage();
        driverObject.mainFrame.setVisible(true);
       
       
    }
    
}
