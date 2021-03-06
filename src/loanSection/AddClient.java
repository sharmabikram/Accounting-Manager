/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanSection;

import accounting.manager.ConnectionObject;
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
public class AddClient extends javax.swing.JFrame {

    private String name, phone, address;
    private PreparedStatement upload;
    private Connection conn;
    
    public AddClient(LoanManager p) {
        initComponents();
        setLocationRelativeTo(null);
        
        try{
            conn = ConnectionObject.myConn.getConnection();
            upload = conn.prepareStatement("insert into cdetail values(?, ?,?,?)");
        }catch(Exception e){
            
        }
        addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    p.enableMe();
                }
            });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photoFrame = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressFrame = new javax.swing.JTextArea();
        browseFrame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        joinButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameFrame = new javax.swing.JTextField();
        phoneFrame = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        photoFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        addressFrame.setColumns(20);
        addressFrame.setRows(5);
        addressFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane1.setViewportView(addressFrame);

        browseFrame.setText("Browse");
        browseFrame.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black));
        browseFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseFrameActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        joinButton.setText("Join");
        joinButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black));
        joinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Phone");

        jLabel4.setText("Address");

        nameFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nameFrame.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFrameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFrameFocusLost(evt);
            }
        });
        nameFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFrameActionPerformed(evt);
            }
        });

        phoneFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(joinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browseFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(photoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(phoneFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addComponent(joinButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(photoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(browseFrame)))
                .addGap(0, 107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseFrameActionPerformed
        uploadPic();
    }//GEN-LAST:event_browseFrameActionPerformed

    private void joinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButtonActionPerformed
        try{
            name = nameFrame.getText();
            phone = phoneFrame.getText();
            address = addressFrame.getText();
            
            long ph = Long.parseLong(phone); // to check for correct format
            if(phone.length() != 10){
                clearAllFeilds();
                JOptionPane.showMessageDialog(this, "Data incorrect.\n"+"Phone no must of length 10\n"+
                    "Half rate must be less than full rate");
                return ;
            }

            
            upload.setString(1, name);
            upload.setString(2, phone);
            upload.setString(3, address);
            
            //byte[] extractBytes = data.getData();
            //upload.setBytes(7, extractBytes);
            //upload.setBinaryStream(7, image, image.);
            FileInputStream fin;
            if(image == null){
                image = new File("C:\\Program Files\\RKS_ACC\\pass.jpg");
                fin=new FileInputStream("C:\\Program Files\\RKS_ACC\\pass.jpg");
            }
            else
            fin=new FileInputStream(image.getAbsolutePath());

            upload.setBinaryStream(4, fin, fin.available());
            upload.executeUpdate();

            //createS.setString(1, name);
            //createS.execute();
            clearAllFeilds();
            JOptionPane.showMessageDialog(this, "Welcome Mr. "+name+ " to RKS");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Some Error occured.\nTry again");
        }
    }//GEN-LAST:event_joinButtonActionPerformed

    private void nameFrameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFrameFocusGained
      
    }//GEN-LAST:event_nameFrameFocusGained

    private void nameFrameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFrameFocusLost
       
    }//GEN-LAST:event_nameFrameFocusLost

    private void nameFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFrameActionPerformed

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
     private static final int IMG_WIDTH = 120;
    private static final int IMG_HEIGHT = 120;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressFrame;
    private javax.swing.JButton browseFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton joinButton;
    private javax.swing.JTextField nameFrame;
    private javax.swing.JTextField phoneFrame;
    private javax.swing.JLabel photoFrame;
    // End of variables declaration//GEN-END:variables

    private void clearAllFeilds() {
        nameFrame.setText("");
        phoneFrame.setText("");
        addressFrame.setText("");
        photoFrame.setIcon(new ImageIcon(getClass().getResource("/extras/pass.jpg")));
    }
}
