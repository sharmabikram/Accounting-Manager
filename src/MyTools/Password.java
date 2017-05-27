/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTools;

import accounting.manager.ConnectionObject;
import accounting.manager.MainPage;
import accounting.manager.StatementDB;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import staffManagement.StaffMain;


/**
 *
 * @author lenovo
 */
public class Password extends javax.swing.JFrame {

    String userName, password;
    int num;
    PreparedStatement auth;
    Connection conn;
    //StatementDB stObj;
    //StaffMain staff;
    MainPage p;
    
    
    public Password(MainPage parent, int num){
       initComponents();
        setLocationRelativeTo(null);
        p = parent;
        this.num = num;
        addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                   parent.enableMe();
                }
            }); 
        
        try{
           conn = ConnectionObject.myConn.getConnection();
           auth = conn.prepareStatement("select * from admin where userName = ? and pass = ?");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameFrame = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        passFrame = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RKS - Sign In");

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        jButton1.setText("Sign in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        passFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(nameFrame)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(passFrame)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       pressButton();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void passFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFrameActionPerformed
       pressButton();
    }//GEN-LAST:event_passFrameActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nameFrame;
    private javax.swing.JPasswordField passFrame;
    // End of variables declaration//GEN-END:variables

    private void Success() {
        if(num == 1){
            StatementDB stObj = new StatementDB(p); 
            stObj.setVisible(true);
        }
        else{
            StaffMain staff = new StaffMain(p);
            staff.setVisible(true);
            p.setVisible(false);
        }
       dispose();
    }

    private void pressButton() {
         try{
            userName = nameFrame.getText();
            password = new String(passFrame.getPassword());
            auth.setString(1, userName);
            auth.setString(2, password);
            
            ResultSet rs = auth.executeQuery();
            if(rs.next()){
                Success();
                p.setEnabled(false);
            }
            else{
            JOptionPane.showMessageDialog(this, "Invalid Username or password");
            nameFrame.setText("");
            passFrame.setText("");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
