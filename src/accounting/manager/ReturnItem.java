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
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author lenovo
 */
public class ReturnItem extends javax.swing.JFrame {

    private PreparedStatement prev, curr, update, prevProfit, currProfit, updateCurr, updatePrev, getSell, updateSell, updateStk;
    private Connection conn;
    private int mnth, yr;
    private String[] defaultValues = {"select"};
    private float[] qty_sold;
    private String selected;
    
    public ReturnItem(MainPage parent) {
        initComponents();
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                   parent.enableMe();
                }
            });
        getMonthYear();
        try{
            conn = ConnectionObject.myConn.getConnection();
            prev = conn.prepareStatement("select itemName, qty_sold from profitmonth where month = ? and year = ?");
            curr = conn.prepareStatement("select itemName, qty_sold from profittable where qty_sold > 0");
            
            prevProfit = conn.prepareStatement("select profit from profitmonth where itemName = ? and month = ? and year = ?");
            currProfit = conn.prepareStatement("select profit from profittable where itemName = ?");
            getSell = conn.prepareStatement("select selling from sell where month = ? and year = ?");
            
            updateCurr = conn.prepareStatement("update profittable set qty_sold = ? , profit = ? where itemName = ?");
            updatePrev = conn.prepareStatement("update profitmonth set qty_sold = ? , profit = ? where itemName = ? and month = ? and year = ?");
            updateSell = conn.prepareStatement("update sell set selling = ? where month = ? and year = ?");
            
            updateStk = conn.prepareStatement("update stock set quantity = ? where itemName = ?");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cMnth = new javax.swing.JRadioButton();
        pMnth = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        nameFrame = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        qtyFrame = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        priceFrame = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        sQtyFrame = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Select the month for Sale");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Items sold in the current month or the previous month is only taken back by us.");

        buttonGroup1.add(cMnth);
        cMnth.setText("Current Month Sale");

        buttonGroup1.add(pMnth);
        pMnth.setText("Previous Month Sale");

        jButton1.setText("Show ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nameFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFrameActionPerformed(evt);
            }
        });

        jLabel3.setText("Item Name to be returned");

        jLabel4.setText("Qty");

        jLabel5.setText("Price");

        priceFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFrameActionPerformed(evt);
            }
        });

        jButton2.setText("Return");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Sold Qty");

        sQtyFrame.setEditable(false);

        jList1.setModel(createDefaultListModel());
        jList1.setVisibleRowCount(20);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nameFrame, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sQtyFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qtyFrame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceFrame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pMnth)
                                    .addComponent(cMnth))
                                .addGap(48, 48, 48)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(53, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cMnth)
                        .addGap(18, 18, 18)
                        .addComponent(pMnth))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceFrame)
                    .addComponent(nameFrame, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sQtyFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtyFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFrameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(cMnth.isSelected()){
            // no change in the month and year
            getCurrentMonthSale();
        }else{
            // chaneg month year
            if(mnth == 0){
                mnth = 11;
                yr--;
            }else
                mnth--;
            getPrevMonthSale();
        }
        addFilter();
        System.out.println(Month.month[mnth] + "  " + yr);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void priceFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFrameActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        selected = jList1.getSelectedValue().toString();
        nameFrame.setText(selected);
        // 
        setQty(selected);
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       float qty = Float.parseFloat(qtyFrame.getText());
       float price = Float.parseFloat(priceFrame.getText());
       
       if(qty <= 0 || price <= 0){
           JOptionPane.showMessageDialog(this, "Illegal Quantity");
           return;
       }
       adjustAll(qty, price);
       clearAll();
    }//GEN-LAST:event_jButton2ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cMnth;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameFrame;
    private javax.swing.JRadioButton pMnth;
    private javax.swing.JTextField priceFrame;
    private javax.swing.JTextField qtyFrame;
    private javax.swing.JTextField sQtyFrame;
    // End of variables declaration//GEN-END:variables

    private void getCurrentMonthSale() {
        ResultSet rs;
        try{
            rs = curr.executeQuery();
            populateDetails(rs);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void getPrevMonthSale() {
        ResultSet rs;
        try{
            System.out.println("here");
            prev.setString(1, Month.month[mnth]);
            prev.setInt(2, yr);
            rs = prev.executeQuery();
            populateDetails(rs);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    private void getMonthYear() {
        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        mnth = cal.get(Calendar.MONTH);
        yr = cal.get(Calendar.YEAR);
    }

    private void populateDetails(ResultSet rs) throws Exception{
        int len = 0, k = 0;
        if(rs.last()){
            len = rs.getRow();
            rs.beforeFirst();
        }
        qty_sold = new float[len];
        defaultValues = new String[len];
        
        while(rs.next()){
           defaultValues[k] = rs.getString("itemName");
           qty_sold[k++] = rs.getFloat("qty_sold");
           System.out.println(defaultValues[k-1]);
        }
        jList1.setModel(createDefaultListModel());
    }
    
    
    private void addFilter(){
        nameFrame.getDocument().addDocumentListener(new DocumentListener(){
            @Override public void insertUpdate(DocumentEvent e) { filter(); }
            @Override public void removeUpdate(DocumentEvent e) { filter(); }
            @Override public void changedUpdate(DocumentEvent e) {}
            private void filter() {
                String filter = nameFrame.getText();
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

    private void setQty(String selected) {
        float qty =0;
        for(int i = 0; i<defaultValues.length; ++i){
            if(selected.equalsIgnoreCase(defaultValues[i])){
                qty = qty_sold[i];
                break;
            }
        }
        sQtyFrame.setText(Float.toString(qty));
    }

    private void adjustAll(float qty, float price) {
        ResultSet rs;
        float cp = 0, newQty = 0, sell = 0;
        float profit = 0, deduct = 0;
        newQty = Float.parseFloat(sQtyFrame.getText());
        
        cp = getSellingPrice();
        System.out.println(stk);
        try{
            if(cMnth.isSelected()){  // adjust profitmonth and netsell
                currProfit.setString(1, selected);
                rs = currProfit.executeQuery();
                if(rs.next()){
                   profit = rs.getFloat(1);
                }
                deduct = price - qty*cp;
                profit = profit - deduct;
                newQty = newQty - qty;
                // update table
                updateCurr.setFloat(1, newQty);
                updateCurr.setFloat(2, profit);
                updateCurr.setString(3, selected);
                updateCurr.executeUpdate();
                
            }else{  // adjust profittable
                prevProfit.setString(1, selected);
                prevProfit.setString(2, Month.month[mnth]);
                prevProfit.setInt(2, yr);
                
                rs = prevProfit.executeQuery();
                if(rs.next()){
                   profit = rs.getFloat(1);
                }
                deduct = price - qty*cp;
                profit = profit - deduct;
                newQty = newQty - qty;
                
                getSell.setString(1, Month.month[mnth]);
                getSell.setInt(2, yr);
                rs = getSell.executeQuery();
                if(rs.next()){
                    sell = rs.getFloat("selling");
                }
                sell = sell - price;
                // update table
                updatePrev.setFloat(1, newQty);
                updatePrev.setFloat(2, profit);
                updatePrev.setString(3, selected);
                updatePrev.setString(4, Month.month[mnth]);
                updatePrev.setInt(5, yr);
                updatePrev.executeUpdate();
                
                updateSell.setFloat(1, sell);
                updateSell.setString(2, Month.month[mnth]);
                updateSell.setInt(3, yr);
                updateSell.executeUpdate();
            }
            
            updateStock(qty );
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private float getSellingPrice() {
        float cp = 0;
        for(int i = 0; i< MainPage.items.length; ++i){
            if(MainPage.items[i].itemName.equalsIgnoreCase(selected)){
                cp = MainPage.items[i].costPrice;
                stk = MainPage.items[i].quantity;
                break;
            }
        }
        return cp;
    }
    
    private void updateStock(float qty) throws Exception{
        float newQty = qty + stk;
        updateStk.setFloat(1, newQty);
        updateStk.setString(2, selected);
        updateStk.executeUpdate();
    }
    
    float stk = 0;

    private void clearAll() {
        nameFrame.setText("");
        qtyFrame.setText("");
        sQtyFrame.setText("");
        priceFrame.setText("");
        JOptionPane.showMessageDialog(this, "Item returned");
    }

}
