/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist;

import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.manager.LoginManager;
import com.imam.sp_checklist.manager.SpringManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Imam-pc
 */
public class Login extends javax.swing.JDialog {

    public Login() {
        setModal(true);
      //  SpringManager.getInstance();
        initComponents();
        
        
        setGlassPane(jGlassPane2);
        getGlassPane().setVisible(true);
        
        jGlassPane2.addGlassPaneComponent(messageComponent2);
        
    }
    
    
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jGlassPane2 = new com.stripbandunk.jglasspane.JGlassPane();
        messageComponent2 = new com.stripbandunk.jglasspane.component.MessageComponent();
        jPanel1 = new javax.swing.JPanel();
        buttonImageReflection1 = new usu.widget.glass.ButtonImageReflection();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnMasuk = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        jGlassPane2.setLayout(new java.awt.FlowLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        buttonImageReflection1.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imam/sp_checklist/image/SECURE.jpg"))); // NOI18N
        buttonImageReflection1.setText("Login");
        buttonImageReflection1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("USERNAME");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText(":");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("PASSWORD");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText(":");

        txtPass.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        txtUsername.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        btnMasuk.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnMasuk.setText("MASUK");
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });
        jPanel3.add(btnMasuk);

        btnBatal.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel3.add(btnBatal);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(buttonImageReflection1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(buttonImageReflection1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        // TODO add your handling code here:
        
        
       boolean login = LoginManager.getInstance().login(txtUsername.getText(), 
                                                        new String(txtPass.getPassword()));
        if (login) {
            Pengguna pengguna = LoginManager.getInstance().getPengguna();
            JOptionPane.showMessageDialog(null,"Selamat Datang "+pengguna.getKaryawan().getNama()+"\n"+pengguna.getKaryawan().getJabatan().getNama());
            Menu_Utama utama = new Menu_Utama();
            utama.getUser(pengguna);
            
//            final SwingWorker<Menu_Utama, String> worker = new SwingWorker<Menu_Utama, String>(){
//            
//            @Override
//            protected Menu_Utama doInBackground() throws Exception {
//                Menu_Utama utama = new Menu_Utama();
//                utama.renderHakAkses();
//                return utama;
//            }
//            
//        };
//        Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
//        ProgressbarLoading loding = new ProgressbarLoading();
//        
//        
//            worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
//                if (evt1.getPropertyName().equals("state")) {
//                    if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
//                        loding.dispose();
//                    }
//                }
//            });
//        worker.execute();
//        loding.pack();
//        loding.setLocationRelativeTo(win);
//        loding.setVisible(true);

            dispose();
        } else {
            messageComponent2.showWarning("Pengguna tidak ditemukan");
        }
        
    }//GEN-LAST:event_btnMasukActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        
         int closing;
            closing = JOptionPane.showConfirmDialog(this,
        "Apakah anda yakin, ingin keluar dari Aplikasi ini...?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (closing==0){
            System.exit(0);
            
        }else{
            this.show();
        }
    }//GEN-LAST:event_btnBatalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnMasuk;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection1;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent2;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
