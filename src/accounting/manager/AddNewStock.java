/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class AddNewStock extends javax.swing.JFrame {

    /**
     * Creates new form AddNewStock
     */
    MainPage parent;
    public AddNewStock(MainPage parent) {
        this.parent = parent;
        initComponents();
        //setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try{
            //ConnectionObject.myConn.openConnection();
            conn = ConnectionObject.myConn.getConnection();
            stmt = conn.prepareStatement("insert into stock (itemName, price, quantity) values(?, ?, ?)");
            profitStmt = conn.prepareStatement("insert into profitTable values(?, ?)");
        }catch(Exception e){
            System.out.println("bug in add stock er");
            e.printStackTrace();
        }
        
        
        addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    parent.enableMe();
                }
            });
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        radioP = new javax.swing.JRadioButton();
        radioL = new javax.swing.JRadioButton();
        amt = new javax.swing.JTextField();
        done = new javax.swing.JButton();
        addMore = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        costPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Item Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Qty type");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Quantity");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioP);
        radioP.setText("pieces");
        radioP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioL);
        radioL.setText("length");
        radioL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLActionPerformed(evt);
            }
        });

        amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtActionPerformed(evt);
            }
        });

        done.setText("Done Adding");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });

        addMore.setText("Add More");
        addMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMoreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Price");

        costPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(radioL)
                    .addComponent(radioP))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(done, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioL))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(costPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addMore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(done)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void radioPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPActionPerformed

    private void radioLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioLActionPerformed

    private void amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtActionPerformed

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
        try{
           itemName = name.getText();
           qty = Float.parseFloat(amt.getText());
           price = Float.parseFloat(costPrice.getText());
           addItem(itemName, price, qty);
           //ConnectionObject.myConn.closeConnection();
           conn = null;//.close();
           this.dispose();
        }
        catch(Exception e){
            // went wrong
            e.printStackTrace();
        }
    }//GEN-LAST:event_doneActionPerformed

    private void addMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMoreActionPerformed

        try{
           itemName = name.getText();
           qty = Float.parseFloat(amt.getText());
           price = Float.parseFloat(costPrice.getText());
           addItem(itemName, price, qty);
        }
        catch(Exception e){
            // went wrong
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_addMoreActionPerformed

    private void costPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costPriceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMore;
    private javax.swing.JTextField amt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField costPrice;
    private javax.swing.JButton done;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField name;
    private javax.swing.JRadioButton radioL;
    private javax.swing.JRadioButton radioP;
    // End of variables declaration//GEN-END:variables

    String itemName;
    float qty;
    float price;
    private Connection conn;
    private PreparedStatement stmt, profitStmt;

    private void addItem(String itemName, float price, float qty) {
       try{
           if(qty <=0){
               JOptionPane.showMessageDialog(this,"Illegal quantity");
               return ;
           }
           stmt.setString(1, itemName);
           stmt.setFloat(2, price);
           stmt.setFloat(3, qty);
           stmt.executeUpdate();
           
           profitStmt.setString(1, itemName);
           profitStmt.setFloat(2, 0);
           profitStmt.executeUpdate();
           clearAllFeild();
       }catch(Exception e){
           System.out.println("bug 2");
       }
    }

    private void clearAllFeild() {
        name.setText("");
        amt.setText("");
        costPrice.setText("");
        radioL.setSelected(false);
        radioP.setSelected(false);
        JOptionPane.showMessageDialog(this,"Item Sucessfully added" );
    }
    
   
}
