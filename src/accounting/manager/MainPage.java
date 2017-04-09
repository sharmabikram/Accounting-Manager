/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class MainPage extends javax.swing.JFrame {

    
    private Connection conn;
    private Statement stmt;
    ResultSet result;
    public static Item items[];
    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();
        setLocationRelativeTo(null);
        try{
            ConnectionObject.myConn.openConnection();
            conn = ConnectionObject.myConn.getConnection();
            stmt = conn.createStatement();
            getDetails();
            //stmt = conn.Statement("insert into stock (itemName, price, quantity) values(?, ?, ?)");
        }catch(Exception e){
            System.out.println("bug in add stock");
            e.printStackTrace();
        }finally{
            try {
                ConnectionObject.myConn.closeConnection();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/extras/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jMenu1.setText("Menu");

        jMenuItem1.setText("Add New Item");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Update Stock");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(711, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(414, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AddNewStock add = new AddNewStock();
        add.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        UpdateStock update = new UpdateStock();
        update.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables

    private void getDetails() {
        try{
            result = stmt.executeQuery("Select * from stock order by id");
            int itemCount;
            if(result.last()){
                itemCount = result.getRow();
                result.beforeFirst();
                items = new Item[itemCount];
            }
            int i = 0;
            while(result.next()){
                items[i] = new Item();
                items[i].itemID = result.getInt("id");
                items[i].itemName = result.getString("itemName");
                items[i].costPrice = result.getFloat("price");
                items[i].quantity = result.getInt("quantity");
                i++;
            }
        }catch(Exception e){
            System.out.println("getDetails");
            e.printStackTrace();
        }
    }
}
