package adminPanelAndMainFrame;

import static databaseStuffs.DatabaseMethods.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sirat
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            
        }
        initComponents();
        super.setVisible(true);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        shoppingMallLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        logInButton = new javax.swing.JButton();
        iconLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setIconImages(getIconImages());
        setResizable(false);

        jPanel1.setLayout(null);

        shoppingMallLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        shoppingMallLabel.setForeground(new java.awt.Color(204, 255, 51));
        shoppingMallLabel.setText("Shopping Mall Management System");
        jPanel1.add(shoppingMallLabel);
        shoppingMallLabel.setBounds(40, 20, 350, 40);

        userNameLabel.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(255, 204, 51));
        userNameLabel.setText("User Name");
        jPanel1.add(userNameLabel);
        userNameLabel.setBounds(80, 100, 90, 22);
        jPanel1.add(userNameTextField);
        userNameTextField.setBounds(170, 100, 130, 30);

        passwordLabel.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 204, 51));
        passwordLabel.setText("Password");
        jPanel1.add(passwordLabel);
        passwordLabel.setBounds(80, 150, 80, 18);

        passwordField.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jPanel1.add(passwordField);
        passwordField.setBounds(170, 140, 130, 30);

        logInButton.setBackground(new java.awt.Color(153, 255, 0));
        logInButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logInButton.setForeground(new java.awt.Color(255, 51, 0));
        logInButton.setText("Log In");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logInButton);
        logInButton.setBounds(210, 180, 80, 25);

        iconLabel.setIcon(new javax.swing.ImageIcon("D:\\Project 2 Work\\Application\\Shopping Mall Management System\\Image\\FirstFrame.jpg")); // NOI18N
        jPanel1.add(iconLabel);
        iconLabel.setBounds(0, 0, 400, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        String userName = userNameTextField.getText();
        String password = new String(passwordField.getPassword());//char array to String

        try {
            String dbPassword = "";
            connectDB();
            statement = con.createStatement();

            resultSet = statement.executeQuery("select password from admin where username ='" + userName + "'");
            while (resultSet.next()) {
                dbPassword = resultSet.getString(1);
            }
            if (dbPassword.matches(password) && password!=null && !password.isEmpty()) {
                FirstFrame FirstFrameObject = new FirstFrame();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong UserName or Password");
            }

            //  setVisible(false);
            //  setVisible(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Enter Valid UserName And Password");

        }
    }//GEN-LAST:event_logInButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logInButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel shoppingMallLabel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}