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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author lenovo
 */
public class StatementDB extends javax.swing.JFrame {

    Statement stmt;
    int itemCount = 0;
    Connection conn;
    ResultSet rs;
    JFrame parent;
    Statement curMnthStmt;
    float netSell = 0;
    private TableRowSorter<TableModel> rowSorter;
    
    public StatementDB(MainPage f) {
        
        parent =f;
        initComponents();
         updateLabelCurrMonth();
        setLocationRelativeTo(null);
        
         addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    f.enableMe();
                }
            });
        
        DefaultTableModel model = new DefaultTableModel(){
                public boolean isCellEditable(int row, int c){
                    return false;
                }
        };
        model.addColumn("S/N");
        model.addColumn("Name");
        model.addColumn("Qty Sold");
        model.addColumn("Profit");
       
        //model.addColumn("Price");
        profitTable.setModel(model);
        profitTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        profitTable.getColumnModel().getColumn(1).setMinWidth(180);
        profitTable.getColumnModel().getColumn(2).setMinWidth(50);
        profitTable.getColumnModel().getColumn(2).setMinWidth(50);
        
        rowSorter = new TableRowSorter<>(profitTable.getModel());
        profitTable.setRowSorter(rowSorter);
        
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        updateTable();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        profitTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        pushProfit = new javax.swing.JButton();
        currMonthLabel = new javax.swing.JLabel();
        monthBox = new javax.swing.JComboBox();
        profitMonthWise = new javax.swing.JButton();
        showing = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        netProfit = new javax.swing.JLabel();
        labelYear = new javax.swing.JLabel();
        yearBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        sellFrame = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfFilter = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTS");
        setResizable(false);

        profitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(profitTable);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/extras/refresh.jpeg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pushProfit.setText("Push");
        pushProfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pushProfitActionPerformed(evt);
            }
        });

        currMonthLabel.setText("jLabel1");

        monthBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JAN", "FEB", "MARCH", "APR", "MAY", "JUN", "JULY", "AUG", "SEPT", "OCT", "NOV", "DEC", " " }));
        monthBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthBoxActionPerformed(evt);
            }
        });

        profitMonthWise.setText("go");
        profitMonthWise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profitMonthWiseActionPerformed(evt);
            }
        });

        showing.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Net Profit");

        netProfit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        netProfit.setText("jLabel2");

        labelYear.setText("jLabel2");

        yearBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Net Sell");

        sellFrame.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sellFrame.setText("jLabel3");

        jLabel3.setText("Enter word to match");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sellFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(netProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfFilter))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(showing, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(currMonthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelYear)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pushProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(profitMonthWise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(monthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(currMonthLabel)
                    .addComponent(labelYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showing, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(profitMonthWise)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pushProfit))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sellFrame)
                    .addComponent(netProfit))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pushProfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pushProfitActionPerformed
        String currMonth = currMonthLabel.getText();
        String currYear = labelYear.getText();
        int year = Integer.parseInt(currYear);
        String name;
        float profit, qty_sold;
        PreparedStatement  upload;
        Statement fetch;
        ResultSet rs;
       
        try{
            conn = ConnectionObject.myConn.getConnection();
            fetch = conn.createStatement();
            upload = conn.prepareStatement("insert into profitMonth VALUES(?, ?, ?, ?, ?)");
            
            rs = fetch.executeQuery("Select * from  profitTable");
            while(rs.next()){
              name = rs.getString("ItemName");
              profit = rs.getFloat("profit");
              qty_sold = rs.getFloat("qty_sold");
              
              if(profit > 0){
              upload.setString(1, name);
              upload.setFloat(2, profit);
              upload.setString(3, currMonth);
              upload.setInt(4, year);
              upload.setFloat(5, qty_sold);
              upload.execute();
              }
            }
            upload = null;
            upload = conn.prepareStatement("update profitTable set profit = ? , qty_sold = ?");
            upload.setFloat(1, 0);
            upload.setFloat(2, 0);
            upload.executeUpdate();
          
          
          
          
          upload = null;
          upload = conn.prepareStatement("insert into  sell values(?, ?, ?)");
          upload.setString(1, currMonth);
          upload.setInt(2, year);
          upload.setFloat(3, netSell);
          upload.executeUpdate();
          
          updateMonth(currMonth);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn = null;
            updateLabelCurrMonth();
            updateTable();
        }
        
    }//GEN-LAST:event_pushProfitActionPerformed

    private void profitMonthWiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profitMonthWiseActionPerformed
        String reqMonth = monthBox.getSelectedItem().toString();
        String yr = yearBox.getSelectedItem().toString();
        int year = 2000+Integer.parseInt(yr);
        System.out.println(year);
        float netPro = 0;
        float netSell = 0;
        PreparedStatement st, total;
        try {
            showing.setText("Showing the result for "+reqMonth);
            showing.setVisible(true);
            String item;
            float profit, qty_sold;
            conn = ConnectionObject.myConn.getConnection();
            st = conn.prepareStatement("Select itemName, profit, qty_sold from profitMonth where month =?  and year = ? order by profit desc");
            total = conn.prepareStatement("Select sum(profit) from profitMonth where month = ? and year = ?");
            total.setString(1, reqMonth);
            total.setInt(2, year);
            rs = total.executeQuery();
            if(rs.next()){
               netPro = rs.getFloat(1);
               System.out.println(netPro);
            }
            netProfit.setText(Float.toString(netPro));
            
            st.setString(1, reqMonth);
            st.setInt(2, year);
            DefaultTableModel addRow =  (DefaultTableModel)profitTable.getModel();
            addRow.setRowCount(itemCount);
            rs = st.executeQuery();
            Object row[] = new Object[4];
            while(rs.next()){
                item = rs.getString("itemName");
                profit = rs.getFloat("profit");
                qty_sold = rs.getFloat("qty_sold");
                row[0] = itemCount+1;
                row[1] = item;
                row[2] = qty_sold;
                row[3] = profit;
                addRow.addRow(row);
                itemCount++;
            }
            
             PreparedStatement fetch = conn.prepareStatement("select selling from sell where month = ? and year = ?");
             fetch.setString(1, reqMonth);
             fetch.setInt(2, year);
            rs = fetch.executeQuery();
          if(rs.next()){
              netSell = rs.getFloat("selling");
          }
          sellFrame.setText(Float.toString(netSell));
        } catch (SQLException ex) {
            System.out.println("month wise");
            ex.printStackTrace();
            Logger.getLogger(StatementDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            itemCount = 0;
            conn = null;
        }
        
    }//GEN-LAST:event_profitMonthWiseActionPerformed

    private void monthBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currMonthLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfFilter;
    private javax.swing.JLabel labelYear;
    private javax.swing.JComboBox monthBox;
    private javax.swing.JLabel netProfit;
    private javax.swing.JButton profitMonthWise;
    private javax.swing.JTable profitTable;
    private javax.swing.JButton pushProfit;
    private javax.swing.JLabel sellFrame;
    private javax.swing.JLabel showing;
    private javax.swing.JComboBox yearBox;
    // End of variables declaration//GEN-END:variables

    private void updateTable() {
        try {
            
            showing.setVisible(false);
            String item;
            float profit, qty_sold, netPro = 0;
            conn = ConnectionObject.myConn.getConnection();
            stmt = conn.createStatement();
            
           // Statement total = conn.createStatement();
            
           /* rs = total.executeQuery("Select sum(profit) from profitTable");
            if(rs.next()){
               netPro = rs.getFloat(1);
            }*/
            
            
            DefaultTableModel addRow =  (DefaultTableModel)profitTable.getModel();
            addRow.setRowCount(itemCount);
            rs = stmt.executeQuery("Select * from profitTable where profit !=0 order by profit desc ");
            while(rs.next()){
                item = rs.getString("itemName");
                profit = rs.getFloat("profit");
                qty_sold = rs.getFloat("qty_sold");
                addRow.addRow(new Object[] {itemCount+1, item, qty_sold,profit});
                itemCount++;
                netPro += profit;
            }
            Statement fetch = conn.createStatement();
            rs = fetch.executeQuery("Select netSell from currMonth");
          if(rs.next()){
              netSell = rs.getFloat("netSell");
          }
          sellFrame.setText(Float.toString(netSell));
          netProfit.setText(Float.toString(netPro));
        } catch (SQLException ex) {
            System.out.println("refresh profit");
            ex.printStackTrace();
            Logger.getLogger(StatementDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            itemCount = 0;
            conn = null;
        }
    }

    private void updateLabelCurrMonth() {
        String label = "OOps Error";
        int year = 0;
        try{
            conn = ConnectionObject.myConn.getConnection();
            curMnthStmt = conn.createStatement();
            ResultSet rs = curMnthStmt.executeQuery("select * from currMonth");
            if(rs.next()){
                label = rs.getString(1);
                year = rs.getInt(2);
            }
            currMonthLabel.setText(label);
            labelYear.setText(Integer.toString(year));
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            conn = null;
        }
    }

    private void updateMonth(String currMonth) throws SQLException {
        PreparedStatement update = conn.prepareStatement("update currMonth set month = ? , curYear = ?, netSell = ?");
        String nowMonth = "JAN";
        int nowYear = Integer.parseInt(labelYear.getText());
        for(int i =0; i<Month.month.length; ++i){
            if(currMonth.equalsIgnoreCase(Month.month[i])){
                if( i == 11)// for dec
                    nowYear++;
                nowMonth = Month.month[(i+1)%12];
                break;
            }
        }
        update.setString(1, nowMonth);
        update.setInt(2, nowYear);
        update.setFloat(3, 0);
        update.execute();
    }
    
}
