/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import staffManagement.StaffMain;
import staffManagement.staffEntry;

/**
 *
 * @author lenovo
 */
public class MainPage extends javax.swing.JFrame {

    private String[] defaultValues ;
    float totalPayment;
    float costPrice = 0;
    private Connection conn;
    private Statement stmt,  currSale;
    private PreparedStatement updateStatement, profitUpdate, currProfit, currSaleUp;
    private float profit = 0;
    ResultSet result;
    int counter = 0;
    int itemCount = 0;
    
    //objects
   
    
    public static Item items[];
    /**
     * Creates new form MainPage
     */
    public MainPage() {  
       
        try{
            
            conn = ConnectionObject.myConn.getConnection();
            stmt = conn.createStatement();
            updateStatement = conn.prepareStatement("update stock set quantity = ? where itemName = ?");
            profitUpdate = conn.prepareStatement("update profitTable set profit = ? , qty_sold = ? where itemName = ?");
            currProfit = conn.prepareStatement("select profit, qty_sold from profittable where itemName = ?");
            currSale = conn.createStatement();
            currSaleUp = conn.prepareStatement("update currMonth set netSell = ?");
            getDetails();
            
            
            //stmt = conn.Statement("insert into stock (itemName, price, quantity) values(?, ?, ?)");
        }catch(Exception e){
            System.out.println("bug in add stock");
            e.printStackTrace();
        }
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("/extras/log.jpg"))));
        initComponents();
        
       // setLayout(new FlowLayout());
    
        setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
       // setModalityExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        //setModalityExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setLocationRelativeTo(null);
        if(itemCount != 0)
            addFilter();
        
        
       // sellingTable.
        
        DefaultTableModel model = new DefaultTableModel(){
                public boolean isCellEditable(int row, int c){
                    return false;
                }
        };
        
        model.addColumn("S/N");
        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Price");
        //model.addColumn("Price");
        sellingTable.setModel(model);
        sellingTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        sellingTable.getColumnModel().getColumn(1).setMinWidth(200);
        sellingTable.getColumnModel().getColumn(2).setMinWidth(70);
        sellingTable.getColumnModel().getColumn(3).setMinWidth(100);
        
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        nameFrame = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radioP = new javax.swing.JRadioButton();
        radioL = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        stockFrame = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        priceFrame = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        sellingTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        qtyFrame = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        StatementDB = new javax.swing.JMenuItem();
        checkStock = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MAIN PAGE");
        setBackground(new java.awt.Color(0, 51, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.cyan);
        setResizable(false);

        nameFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFrameActionPerformed(evt);
            }
        });

        jLabel2.setText("Item Name");

        jLabel3.setText("Stock Left");

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

        jLabel4.setText("Quantity");

        stockFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockFrameActionPerformed(evt);
            }
        });

        jLabel5.setText("Price");

        priceFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFrameActionPerformed(evt);
            }
        });

        jList1.setModel(createDefaultListModel());
        jList1.setVisibleRowCount(4);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        sellingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        sellingTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(sellingTable);

        jScrollPane2.setViewportView(jScrollPane3);

        jButton3.setText("Prnt Invoice");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Qty type");

        qtyFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyFrameActionPerformed(evt);
            }
        });

        jLabel7.setText("Sold Items");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/extras/refresh.jpeg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        StatementDB.setText("Statement");
        StatementDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatementDBActionPerformed(evt);
            }
        });
        jMenu1.add(StatementDB);

        checkStock.setText("Stock");
        checkStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkStockActionPerformed(evt);
            }
        });
        jMenu1.add(checkStock);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Staff Management");

        jMenuItem3.setText("Staff Management");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioL)
                                    .addComponent(radioP))
                                .addGap(44, 44, 44)
                                .addComponent(stockFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qtyFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceFrame)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(294, 294, 294))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(radioL)
                                    .addGap(0, 0, 0)
                                    .addComponent(radioP))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(nameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(stockFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(qtyFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        AddNewStock add = new AddNewStock(this);
        //this.setAlwaysOnTop(false);
        add.setVisible(true);
        setEnabled(false);
        //this.setEnabled(true);
        
        //this.setFocusable(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        UpdateStock update = new UpdateStock(this);
        update.setVisible(true);
        setEnabled(false);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void nameFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFrameActionPerformed

    private void radioPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPActionPerformed

    private void radioLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioLActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String name;
        float qty, price;
        float stock;
        //Vector row = new Vector();
        DefaultTableModel model = (DefaultTableModel)sellingTable.getModel();
        try{
           name = nameFrame.getText();
           qty = Float.parseFloat(qtyFrame.getText());
           price = Float.parseFloat(priceFrame.getText());
           stock = Float.parseFloat(stockFrame.getText());
           if(stock < qty){
               JOptionPane.showMessageDialog(this,"Stock is less");
               return ;
           }
           else if(qty <=0){
               JOptionPane.showMessageDialog(this,"Illegal quantity");
               return ;
           }
           counter++;
           totalPayment += price;
           model.addRow(new Object[]{counter, name, qty, price});
           adjustStock();
           clearAll();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(counter == 0)
            return;
        DefaultTableModel model = (DefaultTableModel) sellingTable.getModel();
        generateInvoice(model, totalPayment);
        //JOptionPane.showMessageDialog(this,"Receive Payment .. Rs "+totalPayment );
        counter = 0;
        totalPayment = 0;
        
        //model.setRowCount(counter);
        clearAll();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void priceFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFrameActionPerformed

    private void stockFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockFrameActionPerformed

    private void qtyFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyFrameActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
       String selected = jList1.getSelectedValue().toString();
       nameFrame.setText(selected);
       
       for(int i = 0; i<items.length; ++i){
           if(selected.equalsIgnoreCase(items[i].itemName)){
               stockFrame.setText(Float.toString(items[i].quantity));
               costPrice = items[i].costPrice;
               break;
           }
       }
        
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getDetails();
        jList1.setModel(createDefaultListModel());
        addFilter();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void StatementDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatementDBActionPerformed
        StatementDB stDB = new StatementDB(this);
        stDB.setVisible(true);
        setEnabled(false); 
    }//GEN-LAST:event_StatementDBActionPerformed

    private void checkStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkStockActionPerformed
        Stock stk = new Stock(this);
        stk.setVisible(true);
        setEnabled(false);
    }//GEN-LAST:event_checkStockActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       StaffMain s = new StaffMain(this);
       s.setVisible(true);
       setVisible(false);
       setEnabled(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem StatementDB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem checkStock;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nameFrame;
    private javax.swing.JTextField priceFrame;
    private javax.swing.JTextField qtyFrame;
    private javax.swing.JRadioButton radioL;
    private javax.swing.JRadioButton radioP;
    private javax.swing.JTable sellingTable;
    private javax.swing.JTextField stockFrame;
    // End of variables declaration//GEN-END:variables

    private void getDetails() {
        
        try{
            result = stmt.executeQuery("Select * from stock order by itemName");
            defaultValues = new String[0];
            if(result.last()){
                itemCount = result.getRow();
                result.beforeFirst();
                items = new Item[itemCount];
                defaultValues = new String[itemCount];
            }
            int i = 0;
            while(result.next()){
                items[i] = new Item();
                items[i].itemID = result.getInt("id");
                items[i].itemName = result.getString("itemName");
                defaultValues[i] = items[i].itemName;
                items[i].costPrice = result.getFloat("price");
                items[i].quantity = result.getInt("quantity");
                i++;
            }
        }catch(Exception e){
            System.out.println("getDetails");
            e.printStackTrace();
        }
        
        
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

    private void clearAll() {
        nameFrame.setText("");
        stockFrame.setText("");
        priceFrame.setText("");
        qtyFrame.setText("");
        radioL.setSelected(false);
        radioP.setSelected(false);
    }
    
    private void closeConnection(){
        try {
                ConnectionObject.myConn.closeConnection();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void adjustStock() {
        try {
            float newQty;
            String selected = nameFrame.getText();
            float qty = Float.parseFloat(qtyFrame.getText());
            float sp = Float.parseFloat(priceFrame.getText());
            for(int i = 0; i<items.length; ++ i){
                if(selected.equalsIgnoreCase(items[i].itemName)){
                    costPrice = items[i].costPrice;
                    items[i].quantity  -= qty;
                    newQty = items[i].quantity;
                    updateStatement.setFloat(1, newQty);
                    updateStatement.setString(2, selected);
                    updateStatement.executeUpdate();
                    break;
                }
            }
            
            float prevProfit = 0;
            float prevQty = 0;
            currProfit.setString(1, selected);
            
            ResultSet rs = currProfit.executeQuery();
            if(rs.next()){
                prevProfit = rs.getFloat(1);
                prevQty = rs.getFloat(2);
            }
            float profit = sp - costPrice*qty;
            profitUpdate.setString(3, selected);
            profitUpdate.setFloat(1, profit + prevProfit);
            profitUpdate.setFloat(2, prevQty+qty);
            profitUpdate.executeUpdate();
            
            
            // sale
            float prevSale=0;
            rs = currSale.executeQuery("select netSell from currMonth");
            if(rs.next()){
                prevSale = rs.getFloat("netSell");
            }
            currSaleUp.setFloat(1, prevSale+sp);
            currSaleUp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enableMe(){
        setEnabled(true);
        setVisible(true);
    }

    private void generateInvoice(DefaultTableModel model, float totalPayment) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        System.out.println(dtf.format(localDate)); //2016/11/16
        
        Invoice invoice = new Invoice(this);
        invoice.setInvoiceData(model, dtf.format(localDate), Float.toString(totalPayment));
        invoice.setVisible(true);
        setEnabled(false);
        new MyTools.PrintInvoice(invoice);
        
    }
}
