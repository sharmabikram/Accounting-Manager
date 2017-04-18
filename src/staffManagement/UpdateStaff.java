/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffManagement;

import accounting.manager.ConnectionObject;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class UpdateStaff extends javax.swing.JFrame {

    
    String name, phone, address;
    float hRate, fRate;
    Connection conn;
    PreparedStatement get, stmt;
    ResultSet rs;
    public UpdateStaff(StaffMain parent, String name) {
        this.name = name;
        
        initComponents();
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                   parent.enableMe();
                }
            });
        welcomeFrame.setText("Welcome  Mr. "+ name);
        
        
       
        try {
            conn = ConnectionObject.myConn.getConnection();
            get = conn.prepareStatement("select * from staffdetail where sname = ?");
            stmt = conn.prepareStatement("update staffdetail set phone = ?, address = ?, rateh = ?, ratef= ? where sname = ?");
            
            showDetails();
            
        } catch (Exception ex) {
            Logger.getLogger(UpdateStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeFrame = new java.awt.Label();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        fRateFrame = new javax.swing.JTextField();
        phoneFrame = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        hRateFrame = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressFrame = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        welcomeFrame.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        welcomeFrame.setText("Welcome");

        label1.setText("Phone");

        label2.setText("Full Rate");

        label3.setText("Half Rate");

        label4.setText("Address");

        addressFrame.setColumns(20);
        addressFrame.setRows(5);
        jScrollPane1.setViewportView(addressFrame);

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fRateFrame))
                    .addComponent(welcomeFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(hRateFrame)
                            .addComponent(phoneFrame))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(welcomeFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fRateFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hRateFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            phone = phoneFrame.getText();
            address = addressFrame.getText();
            fRate = Float.parseFloat(fRateFrame.getText());
            hRate = Float.parseFloat(hRateFrame.getText());
            
            stmt.setString(1, phone);
            stmt.setString(2, address);
            stmt.setFloat(3, hRate);
            stmt.setFloat(4, fRate);
            stmt.setString(5, name);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Modified succefully");
            return ;
        }catch(Exception e){
            System.out.println("bug in add stock");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressFrame;
    private javax.swing.JTextField fRateFrame;
    private javax.swing.JTextField hRateFrame;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JTextField phoneFrame;
    private java.awt.Label welcomeFrame;
    // End of variables declaration//GEN-END:variables

    private void showDetails() throws Exception{
        get.setString(1, name);
        rs = get.executeQuery();
        if(rs.next()){
            address = rs.getString("address");
            phone = rs.getString("phone");
            hRate = rs.getFloat("rateh");
            fRate = rs.getFloat("ratef");
            
            addressFrame.setText(address);
            phoneFrame.setText(phone);
            hRateFrame.setText(Float.toString(fRate));
            fRateFrame.setText(Float.toString(hRate));
            
        }
    }
}
