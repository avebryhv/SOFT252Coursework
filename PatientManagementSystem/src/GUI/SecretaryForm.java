/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Controller;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author ahoughton-vowles
 */
public class SecretaryForm extends javax.swing.JFrame {

    Controller controller = new Controller();
    ArrayList<String> notifications;
    
    /**
     * Creates new form SecretaryForm
     */
    public SecretaryForm() {
        initComponents();
        getNotifications();
    }
    
    private void getNotifications()
    {
        notifications = controller.getNotifications(controller.getCurrentUser().getId());
        DefaultListModel model = new DefaultListModel();        
        for (int i = 0; i < notifications.size(); i++) {
            model.addElement(notifications.get(i));
        }
        lst_noti.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lst_Noti = new javax.swing.JScrollPane();
        lst_noti = new javax.swing.JList<>();
        btn_LogOut = new javax.swing.JButton();
        btn_ApproveAccount = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        btn_Appointment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lst_Noti.setViewportView(lst_noti);

        btn_LogOut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_LogOut.setText("Log Out");
        btn_LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogOutActionPerformed(evt);
            }
        });

        btn_ApproveAccount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_ApproveAccount.setText("Approve New Account");
        btn_ApproveAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ApproveAccountActionPerformed(evt);
            }
        });

        btn_Delete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_Delete.setText("Delete Patient Account");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        btn_Appointment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_Appointment.setText("Create Appointment");
        btn_Appointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AppointmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_LogOut)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_ApproveAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Delete))
                    .addComponent(btn_Appointment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lst_Noti, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lst_Noti, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Appointment)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_ApproveAccount)
                            .addComponent(btn_Delete))
                        .addGap(34, 34, 34)
                        .addComponent(btn_LogOut)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Secretary View", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogOutActionPerformed
        // TODO add your handling code here:
        controller.LogOut();
        this.setVisible(false);
    }//GEN-LAST:event_btn_LogOutActionPerformed

    private void btn_ApproveAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ApproveAccountActionPerformed
        // TODO add your handling code here:
        controller.ApproveNewPatient();
    }//GEN-LAST:event_btn_ApproveAccountActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        // TODO add your handling code here:
        controller.DeletePatient();
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_AppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AppointmentActionPerformed
        // TODO add your handling code here:
        CreateAppointment form = new CreateAppointment();
        form.setVisible(true);
    }//GEN-LAST:event_btn_AppointmentActionPerformed

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
            java.util.logging.Logger.getLogger(SecretaryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretaryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretaryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretaryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecretaryForm().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Appointment;
    private javax.swing.JButton btn_ApproveAccount;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_LogOut;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane lst_Noti;
    private javax.swing.JList<String> lst_noti;
    // End of variables declaration//GEN-END:variables
}
