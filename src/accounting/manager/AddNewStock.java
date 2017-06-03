/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.manager;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        //getContentPane().setBackground(java.awt.Color.MAGENTA);
        
        initComponents();
        //setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try{
            //ConnectionObject.myConn.openConnection();
            conn = ConnectionObject.myConn.getConnection();
            stmt = conn.prepareStatement("insert into stock (itemName, price, quantity, photo) values(?, ?, ?, ?)");
            profitStmt = conn.prepareStatement("insert into profitTable values(?, ?, ?)");
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
        photoFrame.setIcon(new ImageIcon(getClass().getResource("/extras/item.jpg")));
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
        addMore = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        costPrice = new javax.swing.JTextField();
        photoFrame = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADD AN ITEM");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 204, 204));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Item Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Qty type");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Quantity");

        name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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

        jLabel5.setText("Item Image");

        jButton1.setText("Browse");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(photoFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(radioL)
                            .addComponent(radioP))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(costPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(addMore, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
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
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(addMore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(photoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)))
                .addGap(32, 32, 32))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        uploadPic();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMore;
    private javax.swing.JTextField amt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField costPrice;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name;
    private javax.swing.JLabel photoFrame;
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
           
           FileInputStream fin;
            if(image == null){
                image = new File("C:\\Program Files\\RKS_ACC\\item.jpg");
                fin=new FileInputStream("C:\\Program Files\\RKS_ACC\\item.jpg");
            }
           else
            fin=new FileInputStream(image.getAbsolutePath());
            stmt.setBinaryStream(4, fin, fin.available());
            stmt.executeUpdate();
            
           profitStmt.setString(1, itemName);
           profitStmt.setFloat(2, 0);
           profitStmt.setFloat(3, 0);
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
        photoFrame.setIcon(new ImageIcon(getClass().getResource("/extras/pass.jpg")));
        JOptionPane.showMessageDialog(this,"Item Sucessfully added" );
    }
    
    private void uploadPic() {
        JFileChooser chooser;
        FileNameExtensionFilter filter;
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(image);
        filter = new FileNameExtensionFilter("jpeg, gif and png files", "jpg", "gif", "png");
        chooser.addChoosableFileFilter(filter);
 
        int i = chooser.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            image = chooser.getSelectedFile();
            
            //jLabel2.setText(image.getAbsolutePath());
            try {
                BufferedImage originalImage = ImageIO.read(image);
                int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
 
                BufferedImage resizeImageJpg = resizeImage(originalImage, type);
                photo = new ImageIcon(toImage(resizeImageJpg));
 
                //converting buffered image to byte array
                raster = resizeImageJpg.getRaster();
                data = (DataBufferByte) raster.getDataBuffer();
 
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }
        photoFrame.setIcon(photo);
    }
    
    public Image toImage(BufferedImage bufferedImage) {
        return Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
    }
    
    private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
 
        return resizedImage;
    }
    ImageIcon photo;
    WritableRaster raster;
    DataBufferByte data;
    File image;
     private static final int IMG_WIDTH = 100;
    private static final int IMG_HEIGHT = 100;
   
}
