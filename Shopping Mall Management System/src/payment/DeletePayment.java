/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import tenant.*;
import shop.*;
import referencePeople.*;
import adminPanelAndMainFrame.FirstFrame;
import static databaseStuffs.DatabaseMethods.con;
import static databaseStuffs.DatabaseMethods.connectDB;
import static databaseStuffs.DatabaseMethods.resultSet;
import static databaseStuffs.DatabaseMethods.statement;
import deleteInformation.DeleteInformation;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sirat
 */
public class DeletePayment extends javax.swing.JFrame {

    public String id;

    public DeletePayment() {
        initComponents();

        this.setLocationRelativeTo(null);
        warningLabel.setVisible(false);
        yesButton.setVisible(false);
        noButton.setVisible(false);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goButton = new javax.swing.JButton();
        enterIdLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        warningLabel = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        backMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(415, 171));
        getContentPane().setLayout(null);

        goButton.setText("Go");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });
        getContentPane().add(goButton);
        goButton.setBounds(317, 20, 59, 30);

        enterIdLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        enterIdLabel.setText("Enter Payment ID :");
        getContentPane().add(enterIdLabel);
        enterIdLabel.setBounds(10, 20, 160, 22);
        getContentPane().add(idField);
        idField.setBounds(180, 20, 130, 30);

        warningLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(255, 0, 0));
        warningLabel.setText("Are You Sure To Delete This Tenant?");
        getContentPane().add(warningLabel);
        warningLabel.setBounds(50, 20, 291, 17);

        yesButton.setBackground(new java.awt.Color(255, 204, 51));
        yesButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yesButton.setForeground(new java.awt.Color(255, 0, 0));
        yesButton.setText("Yes");
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(yesButton);
        yesButton.setBounds(90, 70, 80, 25);

        noButton.setBackground(new java.awt.Color(0, 255, 51));
        noButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noButton.setText("No");
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });
        getContentPane().add(noButton);
        noButton.setBounds(230, 70, 90, 25);

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
        jMenuBar1.add(backMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_backMenuMenuSelected
        new FirstFrame();
        this.dispose();
    }//GEN-LAST:event_backMenuMenuSelected

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        id = idField.getText();
        goButton.setVisible(false);
        enterIdLabel.setVisible(false);
        idField.setVisible(false);
        warningLabel.setVisible(true);
        yesButton.setVisible(true);
        noButton.setVisible(true);

    }//GEN-LAST:event_goButtonActionPerformed

   
    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        
        new DeleteInformation().deletePayement(id);
        JOptionPane.showMessageDialog(this, "payment ID : "+id+"  Deleted!");
        new FirstFrame();
            this.dispose();
    }//GEN-LAST:event_yesButtonActionPerformed

    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed
        new FirstFrame();
        this.dispose();
    }//GEN-LAST:event_noButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteTenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteTenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteTenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteTenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeletePayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu backMenu;
    private javax.swing.JLabel enterIdLabel;
    private javax.swing.JButton goButton;
    private javax.swing.JTextField idField;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton noButton;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables
}
