/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Controller;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author ahoughton-vowles
 */
public class PatientForm extends javax.swing.JFrame {

    Controller controller = new Controller();
    ArrayList<String> notifications;
    
    /**
     * Creates new form PatientForm
     */
    public PatientForm() {
        initComponents();
        getNotifications();
        GetDoctors();
    }

    private void GetDoctors()
    {
        ArrayList<String> names = controller.GetDoctorNames();
        DefaultComboBoxModel model = new DefaultComboBoxModel();        
        for (int i = 0; i < names.size(); i++) {
            model.addElement(names.get(i));
        }
        cmb_Doctor.setModel(model);
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
        btn_Delete = new javax.swing.JButton();
        btn_Reviews = new javax.swing.JButton();
        btn_RequestAppointment = new javax.swing.JButton();
        cmb_Doctor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txt_Time = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lst_Noti.setViewportView(lst_noti);

        btn_LogOut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_LogOut.setText("Log Out");
        btn_LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogOutActionPerformed(evt);
            }
        });

        btn_Delete.setBackground(new java.awt.Color(255, 51, 51));
        btn_Delete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_Delete.setText("Request Account Deletion");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        btn_Reviews.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_Reviews.setText("Doctor Reviews");
        btn_Reviews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReviewsActionPerformed(evt);
            }
        });

        btn_RequestAppointment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_RequestAppointment.setText("RequestAppointment");
        btn_RequestAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RequestAppointmentActionPerformed(evt);
            }
        });

        jLabel1.setText("Doctor");

        jLabel2.setText("Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Reviews)
                    .addComponent(btn_LogOut)
                    .addComponent(btn_Delete)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_RequestAppointment)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_Doctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_Time)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel2)))
                                .addGap(0, 58, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lst_Noti, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lst_Noti, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_Doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(txt_Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_RequestAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Reviews)
                        .addGap(18, 18, 18)
                        .addComponent(btn_LogOut)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Delete)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Patient View", jPanel1);

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

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        // TODO add your handling code here:
        controller.RequestTermination();
        getNotifications();
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_ReviewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReviewsActionPerformed
        // TODO add your handling code here:
        DoctorRatings form = new DoctorRatings();
        form.setVisible(true);
    }//GEN-LAST:event_btn_ReviewsActionPerformed

    private void btn_RequestAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RequestAppointmentActionPerformed
        // TODO add your handling code here:
        controller.RequestAppointment(cmb_Doctor.getModel().getSelectedItem().toString(), txt_Time.getText());
    }//GEN-LAST:event_btn_RequestAppointmentActionPerformed

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
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_LogOut;
    private javax.swing.JButton btn_RequestAppointment;
    private javax.swing.JButton btn_Reviews;
    private javax.swing.JComboBox<String> cmb_Doctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane lst_Noti;
    private javax.swing.JList<String> lst_noti;
    private javax.swing.JTextField txt_Time;
    // End of variables declaration//GEN-END:variables
}
