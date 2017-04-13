/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author lenovo
 */
public class UpdateStock extends javax.swing.JFrame {

    private String[] defaultValues ;
    private Connection conn;
    private PreparedStatement stmt;
    //JFrame parent;
    public UpdateStock(MainPage f) {
        //parent = f;
        addValues();
        initComponents();
        setLocationRelativeTo(null);
         addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                   f.enableMe();
                }
            });
        //setLocationRelativeTo(null);
        addFilter();
        
        try{
           // ConnectionObject.myConn.openConnection();
            conn = ConnectionObject.myConn.getConnection();
            stmt = conn.prepareStatement("update Stock set price = ? , quantity = ? where itemName = ?");
        }catch(Exception e){
            System.out.println("bug in add stock");
            e.printStackTrace();
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        priceFrame = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Item ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Qty type");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Quantity");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        radioP.setText("pieces");
        radioP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPActionPerformed(evt);
            }
        });

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

        done.setText("Done");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });

        addMore.setText("Update More");
        addMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMoreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("price");

        priceFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFrameActionPerformed(evt);
            }
        });

        jScrollPane1.setAlignmentY(0.0F);

        jList1.setModel(createDefaultListModel());
        jList1.setVisibleRowCount(4);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(radioP)
                    .addComponent(radioL))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addMore)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(done))
                        .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioL))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addMore)
                            .addComponent(done)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
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
           String itemName = name.getText();
           float qty = Float.parseFloat(amt.getText());
           float price = Float.parseFloat(priceFrame.getText());
           updateItem(itemName, price, qty);
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
           String itemName = name.getText();
           float qty = Float.parseFloat(amt.getText());
           float price = Float.parseFloat(priceFrame.getText());
           updateItem(itemName, price, qty);
        }
        catch(Exception e){
            // went wrong
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_addMoreActionPerformed

    private void priceFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFrameActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jList1ValueChanged

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        name.setText(jList1.getSelectedValue().toString());
    }//GEN-LAST:event_jList1MouseClicked

    private void addFilter(){
        name.getDocument().addDocumentListener( new DocumentListener(){
            @Override public void insertUpdate(DocumentEvent e) { filter(); }
            @Override public void removeUpdate(DocumentEvent e) { filter(); }
            @Override public void changedUpdate(DocumentEvent e) {}
            private void filter() {
                String filter = name.getText();
                filterModel((DefaultListModel<String>)jList1.getModel(), filter);
            }
        });
 }
                
    private ListModel<String> createDefaultListModel() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : defaultValues) {
            model.addElement(s);
        }
        return model;
    }

    public void filterModel(DefaultListModel<String> model, String filter) {
        for (String s : defaultValues) {
            if (!s.startsWith(filter)) {
                if (model.contains(s)) {
                    model.removeElement(s);
                }
            } else {
                if (!model.contains(s)) {
                    model.addElement(s);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMore;
    private javax.swing.JTextField amt;
    private javax.swing.JButton done;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField priceFrame;
    private javax.swing.JRadioButton radioL;
    private javax.swing.JRadioButton radioP;
    // End of variables declaration//GEN-END:variables

    private void addValues() {
        defaultValues = new String[MainPage.items.length];
        for(int i = 0; i<MainPage.items.length; ++i){
            //defaultValues[i] = new String();
            defaultValues[i] = MainPage.items[i].itemName;
        }
    }

    private void updateItem(String itemName, float price, float qty) {
        if(qty <=0){
               JOptionPane.showMessageDialog(this,"Illegal quantity");
               return ;
           }
        float oldQty = getQtyIndex(itemName);
        try{
           stmt.setFloat(1, price);
           stmt.setFloat(2, qty+oldQty);
           stmt.setString(3, itemName);
           
           stmt.executeUpdate();
           clearAllFeild();
       }catch(Exception e){
           System.out.println("bug 2");
       }
    }
    
    private void clearAllFeild() {
        name.setText("");
        priceFrame.setText("");
        amt.setText("");
        radioL.setSelected(false);
        radioP.setSelected(false);
        JOptionPane.showMessageDialog(this,"Item Sucessfully updated" );
    }

    private float getQtyIndex(String itemName) {
        for(int i=0; i<defaultValues.length; ++i){
           if(itemName.equalsIgnoreCase(defaultValues[i])) 
               return MainPage.items[i].quantity;
        }
        return 0;
    }
    
    
}
