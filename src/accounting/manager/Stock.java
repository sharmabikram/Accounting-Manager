/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class Stock extends javax.swing.JFrame {

    /**
     * Creates new form Stock
     */
    //JFrame parent;
    public Stock(MainPage parent) {
        //this.parent = parent;
        initComponents();
        setLocationRelativeTo(null);
         addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    parent.enableMe();
                }
            });
        
        DefaultTableModel model = new DefaultTableModel(){
                public boolean isCellEditable(int row, int c){
                    return false;
                }
        };
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Cost Price");
        model.addColumn("Stock left");
       
        //model.addColumn("Price");
        stockTable.setModel(model);
        stockTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        stockTable.getColumnModel().getColumn(1).setMinWidth(200);
        stockTable.getColumnModel().getColumn(2).setMinWidth(70);
        stockTable.getColumnModel().getColumn(3).setMinWidth(70);
        
        updateTableContent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pane = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
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
        pane.setViewportView(stockTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane pane;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables

    private void updateTableContent() {
        DefaultTableModel model = (DefaultTableModel)stockTable.getModel();
        int id;
        String name;
        float cost;
        float qty;
        for(int i = 1; i<=MainPage.items.length; ++i){
            id = MainPage.items[i-1].itemID;
            name = MainPage.items[i-1].itemName;
            cost = MainPage.items[i-1].costPrice;
            qty = MainPage.items[i-1].quantity;
            
            model.addRow(new Object[] {id, name, cost, qty});
        }
    }
    
    
}
