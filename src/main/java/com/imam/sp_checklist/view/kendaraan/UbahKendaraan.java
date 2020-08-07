/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.kendaraan;

import com.imam.sp_checklist.entity.master.Kendaraan;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.manager.LoginManager;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.service.KendaraanService;
import com.imam.sp_checklist.validator.ValidatorException;
import com.imam.sp_checklist.validator.impl.KendaraanValidator;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Imam-pc
 */
public class UbahKendaraan extends javax.swing.JDialog {

    private Kendaraan kendaraan;
    public UbahKendaraan() {
        setModal(true);
        initComponents();
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
        Locale locale = Locale.forLanguageTag("in-ID");
        
        Calendar now = Calendar.getInstance(locale);
        now.setTime(new Date());
        
        
    }
    
    public Kendaraan ubahKendaraan(Kendaraan param){
        
        kendaraan = param;
        
        txtNopol.setText(kendaraan.getId());
        txtMerk.setText(kendaraan.getMerk());
        comboJenis.setSelectedItem(kendaraan.getJenis());
        
        lblBuatBy.setText(kendaraan.getBuatBy());
        lblWaktuBuat.setText(String.valueOf(kendaraan.getWaktuDibuat()));
        
        setLocationRelativeTo(this);
        setVisible(true);
        
        return kendaraan;
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupPL = new javax.swing.ButtonGroup();
        jGlassPane1 = new com.stripbandunk.jglasspane.JGlassPane();
        messageComponent1 = new com.stripbandunk.jglasspane.component.MessageComponent();
        lblBuatBy = new javax.swing.JLabel();
        lblWaktuBuat = new javax.swing.JLabel();
        panelImageBackground1 = new com.imam.sp_checklist.widget.PanelImageBackground();
        jPanel1 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtNopol = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMerk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboJenis = new javax.swing.JComboBox<>();

        lblBuatBy.setText("jLabel2");

        lblWaktuBuat.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panelImageBackground1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ubah Kendaraan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N

        jPanel1.setOpaque(false);

        btnSimpan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan);

        btnBatal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel1.add(btnBatal);

        txtNopol.setEditable(false);
        txtNopol.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Nopol :");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Merk Kendaraan :");

        txtMerk.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("Jenis Kendaraan :");

        comboJenis.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "SEDAN", "MINIBUS", "CONVERTIBLE", "SPORT CAR" }));

        javax.swing.GroupLayout panelImageBackground1Layout = new javax.swing.GroupLayout(panelImageBackground1);
        panelImageBackground1.setLayout(panelImageBackground1Layout);
        panelImageBackground1Layout.setHorizontalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtNopol, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMerk, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(comboJenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelImageBackground1Layout.setVerticalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImageBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImageBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Pengguna pgn = LoginManager.getInstance().getPengguna();
        
        if(comboJenis.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Jenis Kendaraan belum dipilih");
        }else{
            

            kendaraan = new Kendaraan();
            kendaraan.setBuatBy(lblBuatBy.getText());
            kendaraan.setWaktuDibuat(Timestamp.valueOf(lblWaktuBuat.getText()));
            kendaraan.setWaktuUbah(new java.sql.Timestamp(new java.util.Date().getTime()));
            kendaraan.setUbahBy(pgn.getKaryawan().getNama());
            kendaraan.setId(txtNopol.getText());
            kendaraan.setMerk(txtMerk.getText());
            kendaraan.setJenis(comboJenis.getSelectedItem().toString());

            KendaraanValidator validator = SpringManager.getInstance().getBean(KendaraanValidator.class);
            KendaraanService service = SpringManager.getInstance().getBean(KendaraanService.class);


            try {
                validator.validate(kendaraan);
                service.update(kendaraan);
                dispose();
            } catch (ValidatorException ex) {
                messageComponent1.showWarning(ex.getMessage());
            }catch (DataAccessException ex) {
                messageComponent1.showWarning(ex.getRootCause().getMessage());
            }

            
        }
        
        
        

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:

        int closing;
        closing = JOptionPane.showConfirmDialog(this,
            "Apakah anda yakin...?", "Konfirmasi Batal",JOptionPane.YES_NO_OPTION);
        if (closing==0){
            dispose();

        }else{
            this.show();
        }
    }//GEN-LAST:event_btnBatalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.ButtonGroup btnGroupPL;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> comboJenis;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBuatBy;
    private javax.swing.JLabel lblWaktuBuat;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private com.imam.sp_checklist.widget.PanelImageBackground panelImageBackground1;
    private javax.swing.JTextField txtMerk;
    private javax.swing.JTextField txtNopol;
    // End of variables declaration//GEN-END:variables
}
