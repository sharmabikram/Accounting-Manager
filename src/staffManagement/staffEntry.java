/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffManagement;

import accounting.manager.ConnectionObject;
import accounting.manager.MainPage;
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
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author lenovo
 */
public class staffEntry extends javax.swing.JFrame {

    String name;
    String phone, address;
    float hRate, fRate, amountDue ;
    String hint = "Sperate title with _. Eg Ram_Kumar";
    boolean showingHint = true;
    private Connection conn;
    private PreparedStatement upload, createS;
    Statement stmt;
    
    public staffEntry(StaffMain parent) {
        initComponents();
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    parent.enableMe();
                }
            });
        makeConnectionAndStatement();
        photoFrame.setIcon(new ImageIcon(getClass().getResource("/extras/pass.jpg")));
       
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
        browseFrame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameFrame = new javax.swing.JTextField();
        phoneFrame = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hRateFrame = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fRateFrame = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressFrame = new javax.swing.JTextArea();
        joinButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Staff");

        browseFrame.setText("Browse");
        browseFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseFrameActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel3.setText("Phone");

        jLabel4.setText("Address");

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

        jLabel5.setText("Half Rate");

        jLabel6.setText("Full Rate");

        addressFrame.setColumns(20);
        addressFrame.setRows(5);
        jScrollPane1.setViewportView(addressFrame);

        joinButton.setText("Join");
        joinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hRateFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fRateFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(joinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browseFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(photoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phoneFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hRateFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fRateFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(joinButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(photoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(browseFrame)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFrameActionPerformed

    private void joinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButtonActionPerformed
        try{
            name = nameFrame.getText();
            phone = phoneFrame.getText();
            address = addressFrame.getText();
            hRate = Float.parseFloat(hRateFrame.getText());
            fRate = Float.parseFloat(fRateFrame.getText());
            long ph = Long.parseLong(phone); // to check for correct format
            if(phone.length() != 10 && hRate >= fRate){
                clearAllFeilds();
                JOptionPane.showMessageDialog(this, "Data incorrect.\n"+"Phone no must of length 10\n"+
                        "Half rate must be less than full rate");
                return ;
            }
            
            stmt = conn.createStatement();
            stmt.execute("create table if not exists "+ name + "(tarik dateTime primary key, type char(2)) ");
            
            
            upload.setString(1, name);
            upload.setString(2, phone);
            upload.setFloat(3, hRate);
            upload.setFloat(4, fRate);
            upload.setString(5, address);
            upload.setFloat(6, 0); // amt due is 0;
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
              
            upload.setBinaryStream(7, fin, fin.available());
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
        if(showingHint)
            nameFrame.setText("");
        
    }//GEN-LAST:event_nameFrameFocusGained

    private void nameFrameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFrameFocusLost
        if("".equalsIgnoreCase(nameFrame.getText()))
            nameFrame.setText(hint);
    }//GEN-LAST:event_nameFrameFocusLost

    private void browseFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseFrameActionPerformed
       uploadPic();
    }//GEN-LAST:event_browseFrameActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressFrame;
    private javax.swing.JButton browseFrame;
    private javax.swing.JTextField fRateFrame;
    private javax.swing.JTextField hRateFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton joinButton;
    private javax.swing.JTextField nameFrame;
    private javax.swing.JTextField phoneFrame;
    private javax.swing.JLabel photoFrame;
    // End of variables declaration//GEN-END:variables

    private void makeConnectionAndStatement() {
        try{
            conn = ConnectionObject.myConn.getConnection();
            upload = conn.prepareStatement("insert into staffdetail values(?, ?,?,?,?,?, ?)");
            //createS = conn.prepareStatement("create table if not exists ? (sname varchar(20), tarik dateTime)");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void clearAllFeilds() {
        nameFrame.setText("");
        phoneFrame.setText("");
        addressFrame.setText("");
        hRateFrame.setText("");
        fRateFrame.setText("");
        
       photoFrame.setIcon(new ImageIcon(getClass().getResource("/extras/pass.jpg")));
       
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
     private static final int IMG_WIDTH = 120;
    private static final int IMG_HEIGHT = 120;
}
