/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import adminPanelAndMainFrame.FirstFrame;
import static databaseStuffs.DatabaseMethods.con;
import static databaseStuffs.DatabaseMethods.connectDB;
import static databaseStuffs.DatabaseMethods.resultSet;
import static databaseStuffs.DatabaseMethods.statement;
import referencePeople.*;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import screenshot.GetScreenShot;

/**
 *
 * @author Sirat
 */
public class EditShop extends javax.swing.JFrame {

    private File selectedFile;
    //  String imageURL = "";
    String id;
    String imgageUrlFromDb;

    /**
     * Creates new form AddReference
     */
    public EditShop(String id) {
        initComponents();
        this.id = id;
        setVisible(true);
        setLocationRelativeTo(null);
        setInfo();
    }

    void setInfo() {
        try {
            connectDB();
            String roomNo = "";
            String securityFee = "";
            String area = "";
            String ac = "";
            String rent = "";

            statement = con.createStatement();
            resultSet = statement.executeQuery("select room_no,security_fee,area,ac_enable,rent,image_url from shop Where shop_id=" + id);
            while (resultSet.next()) {
                roomNo = resultSet.getString(1);
                securityFee = resultSet.getString(2);
                area = resultSet.getString(3);
                ac = resultSet.getString(4);
                rent = resultSet.getString(5);
                imgageUrlFromDb = resultSet.getString(6);
            }
            setUpImageIcon(imgageUrlFromDb);
            idTextField.setText(id);
            roomNumberTextField.setText(roomNo);
            securityFeeTextField.setText(securityFee);
            areaTextField.setText(area);
            acTextField.setText(ac);
            rentTextField.setText(rent);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    void setUpImageIcon(String iURL) {
        try {
            File f = new File(iURL);
            Image img = ImageIO.read(f);
            ImageIcon ic = new ImageIcon(img);
            photoIconLabel.setIcon(ic);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Photo Load Failed");

        }
    }

    void setUpImage() {//edit the photo with new photo
        try {
            Image img = ImageIO.read(selectedFile);
            selectedFile = new File(imgageUrlFromDb);
            ImageIO.write((RenderedImage) img, "jpg", selectedFile);
            //

        } catch (Exception ex) {
            System.out.println("Wrong");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        roomNumberLabel = new javax.swing.JLabel();
        photoLabel = new javax.swing.JLabel();
        securityFeeLabel = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        acLabel = new javax.swing.JLabel();
        rentLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        idTextField = new javax.swing.JTextField();
        roomNumberTextField = new javax.swing.JTextField();
        securityFeeTextField = new javax.swing.JTextField();
        areaTextField = new javax.swing.JTextField();
        acTextField = new javax.swing.JTextField();
        rentTextField = new javax.swing.JTextField();
        uploadButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        photoIconLabel = new javax.swing.JLabel();
        acEgLabel = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        homeMenu = new javax.swing.JMenu();
        backMenu = new javax.swing.JMenu();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 515));
        getContentPane().setLayout(null);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 51, 255));
        titleLabel.setText("Please Change the Items :");
        getContentPane().add(titleLabel);
        titleLabel.setBounds(70, 0, 350, 29);

        idLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        idLabel.setText("Shop ID: ");
        getContentPane().add(idLabel);
        idLabel.setBounds(30, 65, 100, 15);

        roomNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roomNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        roomNumberLabel.setText("Room No.");
        getContentPane().add(roomNumberLabel);
        roomNumberLabel.setBounds(30, 119, 80, 15);

        photoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        photoLabel.setForeground(new java.awt.Color(255, 255, 255));
        photoLabel.setText("Image :");
        getContentPane().add(photoLabel);
        photoLabel.setBounds(30, 173, 100, 15);

        securityFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        securityFeeLabel.setForeground(new java.awt.Color(255, 255, 255));
        securityFeeLabel.setText("Security Fee :");
        getContentPane().add(securityFeeLabel);
        securityFeeLabel.setBounds(30, 227, 110, 15);

        areaLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        areaLabel.setForeground(new java.awt.Color(255, 255, 255));
        areaLabel.setText("Area :");
        getContentPane().add(areaLabel);
        areaLabel.setBounds(30, 281, 100, 15);

        acLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        acLabel.setForeground(new java.awt.Color(255, 255, 255));
        acLabel.setText("Air Condition: ");
        getContentPane().add(acLabel);
        acLabel.setBounds(30, 335, 90, 15);

        rentLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rentLabel.setForeground(new java.awt.Color(255, 255, 255));
        rentLabel.setText("Monthly Rent");
        getContentPane().add(rentLabel);
        rentLabel.setBounds(30, 389, 120, 15);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 94, 410, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 148, 410, 10);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(0, 202, 410, 10);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(0, 256, 410, 10);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(0, 310, 410, 10);
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(0, 364, 410, 10);

        idTextField.setEditable(false);
        idTextField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        idTextField.setMaximumSize(new java.awt.Dimension(20, 10));
        idTextField.setName(""); // NOI18N
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(idTextField);
        idTextField.setBounds(170, 50, 180, 30);

        roomNumberTextField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        roomNumberTextField.setPreferredSize(new java.awt.Dimension(20, 10));
        getContentPane().add(roomNumberTextField);
        roomNumberTextField.setBounds(166, 105, 230, 30);

        securityFeeTextField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        securityFeeTextField.setPreferredSize(new java.awt.Dimension(20, 10));
        getContentPane().add(securityFeeTextField);
        securityFeeTextField.setBounds(160, 214, 240, 30);

        areaTextField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        areaTextField.setPreferredSize(new java.awt.Dimension(20, 10));
        getContentPane().add(areaTextField);
        areaTextField.setBounds(162, 268, 240, 30);

        acTextField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        acTextField.setPreferredSize(new java.awt.Dimension(20, 10));
        getContentPane().add(acTextField);
        acTextField.setBounds(160, 320, 130, 30);

        rentTextField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rentTextField.setPreferredSize(new java.awt.Dimension(20, 10));
        getContentPane().add(rentTextField);
        rentTextField.setBounds(160, 380, 220, 30);

        uploadButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        uploadButton.setText("Upload Image");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });
        getContentPane().add(uploadButton);
        uploadButton.setBounds(166, 160, 130, 30);

        saveButton.setBackground(new java.awt.Color(255, 255, 51));
        saveButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saveButton.setText("Save Change");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton);
        saveButton.setBounds(460, 380, 200, 50);

        photoIconLabel.setIcon(new javax.swing.ImageIcon("D:\\Project 2 Work\\Application\\Shopping Mall Management System\\Image\\1.jpg")); // NOI18N
        getContentPane().add(photoIconLabel);
        photoIconLabel.setBounds(420, 20, 270, 350);

        acEgLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        acEgLabel.setForeground(new java.awt.Color(255, 255, 255));
        acEgLabel.setText("Only ( 0 / 1)");
        getContentPane().add(acEgLabel);
        acEgLabel.setBounds(310, 320, 80, 30);

        iconLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iconLabel.setForeground(new java.awt.Color(255, 255, 255));
        iconLabel.setIcon(new javax.swing.ImageIcon("D:\\Project 2 Work\\Application\\Shopping Mall Management System\\Image\\background2.jpg")); // NOI18N
        getContentPane().add(iconLabel);
        iconLabel.setBounds(-10, -20, 750, 600);

        homeMenu.setText("Home");
        homeMenu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                homeMenuMenuSelected(evt);
            }
        });
        jMenuBar1.add(homeMenu);

        backMenu.setText("Back");
        backMenu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                backMenuMenuSelected(evt);
            }
        });
        backMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backMenuActionPerformed(evt);
            }
        });
        jMenuBar1.add(backMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        JFileChooser file = new JFileChooser();
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = file.getSelectedFile();
            System.out.println("File Selected");
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Select");
        }
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void backMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backMenuActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String guiId = idTextField.getText();
        String guiRoomNo = roomNumberTextField.getText();
        setUpImage();
        String guiPhotoUrl = imgageUrlFromDb;
        String guiSecurityFee = securityFeeTextField.getText();
        String guiArea = areaTextField.getText();
        String guiAirCondition = acTextField.getText();
        String guiRent = rentTextField.getText();

        try {
            String sql = "UPDATE `shopping_mall_database`.`shop` SET `security_fee` = " + guiSecurityFee + ", `rent` = " + guiRent + ", `area` = " + guiArea
                    + ", `room_no` = '" + guiRoomNo + "', `image_url` = '" + guiPhotoUrl + "', `ac_enable` = " + guiAirCondition
                    + " WHERE `shop`.`shop_id` =" + guiId;
            System.out.println(sql);
            statement.executeUpdate(sql);
            new GetScreenShot(this,"shop_ID_"+guiId);
            FirstFrame ob = new FirstFrame();
            this.dispose();
        } catch (SQLException dbe) {
            JOptionPane.showMessageDialog(this, "Fill Up All Field and select an Image");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void homeMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_homeMenuMenuSelected
        new FirstFrame();
        this.dispose();
    }//GEN-LAST:event_homeMenuMenuSelected

    private void backMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_backMenuMenuSelected
        new PreEditShop();
        this.dispose();
    }//GEN-LAST:event_backMenuMenuSelected

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditReference.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditReference.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditReference.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditReference.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        new EditShop("2");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acEgLabel;
    private javax.swing.JLabel acLabel;
    private javax.swing.JTextField acTextField;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JTextField areaTextField;
    private javax.swing.JMenu backMenu;
    private javax.swing.JMenu homeMenu;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel photoIconLabel;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JLabel rentLabel;
    private javax.swing.JTextField rentTextField;
    private javax.swing.JLabel roomNumberLabel;
    private javax.swing.JTextField roomNumberTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel securityFeeLabel;
    private javax.swing.JTextField securityFeeTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
