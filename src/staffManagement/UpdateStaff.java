/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffManagement;

import accounting.manager.ConnectionObject;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
        photoFrame = new javax.swing.JLabel();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(photoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(welcomeFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(photoFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
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
    private javax.swing.JLabel photoFrame;
    private java.awt.Label welcomeFrame;
    // End of variables declaration//GEN-END:variables

    private void showDetails() throws Exception{
        get.setString(1, name);
        rs = get.executeQuery();
        Blob b;
        ImageIcon photo;
        if(rs.next()){
            address = rs.getString("address");
            phone = rs.getString("phone");
            hRate = rs.getFloat("rateh");
            fRate = rs.getFloat("ratef");
            //b = rs.getBytes("image");
            //System.out.println(b);
            addressFrame.setText(address);
            phoneFrame.setText(phone);
            hRateFrame.setText(Float.toString(fRate));
            fRateFrame.setText(Float.toString(hRate));
            
            
            //BufferedImage im = ImageIO.read(in);
          //  byte img[] = new byte[(int)b.length()];
            
            //img = b.getBytes(1, (int) b.length());
            FileOutputStream fout=new FileOutputStream("staff.jpg");  
            fout.write(rs.getBlob("image").getBytes(1, (int)rs.getBlob("image").length()));
            fout.close();
            File f = new File("staff.jpg");
            BufferedImage originalImage = ImageIO.read(f);
            
           
            int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
             BufferedImage resizeImageJpg = resizeImage(originalImage, type);
                photo = new ImageIcon(toImage(resizeImageJpg));
            photoFrame.setIcon(photo);  
        }
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
    
    private static final int IMG_WIDTH = 120;
    private static final int IMG_HEIGHT = 120;
}
