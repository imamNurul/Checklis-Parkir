/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.zona;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.entity.master.Zona;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.manager.LoginManager;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.service.BasementService;
import com.imam.sp_checklist.service.ZonaService;
import com.imam.sp_checklist.validator.ValidatorException;
import com.imam.sp_checklist.validator.impl.ZonaValidator;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Imam-pc
 */
public class TambahZona extends javax.swing.JDialog {

    private Zona zona;
    public TambahZona() {
        setModal(true);
        initComponents();
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
        Locale locale = Locale.forLanguageTag("in-ID");
        
        Calendar now = Calendar.getInstance(locale);
        now.setTime(new Date());
        
        
    }
    
    public void tambahZona(){
        
        LoadBasementCombo();
        
        setLocationRelativeTo(this);
        setVisible(true);
        
    }
    
    public void LoadBasementCombo(){
        BasementService jb = SpringManager.getInstance().getBean(BasementService.class);
     
        List<Basement> list =  jb.findAll();
        
        for(Basement bs : list){
           comboBasement.addItem(bs);
        }
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
        panelImageBackground1 = new com.imam.sp_checklist.widget.PanelImageBackground();
        jPanel1 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtKode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboBasement = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panelImageBackground1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tambah Zona", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N

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

        txtKode.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Kode Zona :");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Nama Zona :");

        txtNama.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("Basement :");

        comboBasement.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboBasement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));

        javax.swing.GroupLayout panelImageBackground1Layout = new javax.swing.GroupLayout(panelImageBackground1);
        panelImageBackground1.setLayout(panelImageBackground1Layout);
        panelImageBackground1Layout.setHorizontalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBasement, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelImageBackground1Layout.setVerticalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBasement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
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

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
        Pengguna pgn = LoginManager.getInstance().getPengguna();
        
        ZonaService ks = SpringManager.getInstance().getBean(ZonaService.class);
        Zona kd = ks.find(txtKode.getText());
        
        if(kd != null){
            messageComponent1.showWarning("Kode Zona sudah ada");
        }else if(comboBasement.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Basement belum dipilih");
        }else{
            
            zona = new Zona();
            zona.setBuatBy(pgn.getKaryawan().getNama());
            zona.setWaktuDibuat(new java.sql.Timestamp(new java.util.Date().getTime()));
            zona.setWaktuUbah(new java.sql.Timestamp(new java.util.Date().getTime()));
            zona.setUbahBy(pgn.getKaryawan().getNama());
            zona.setId(txtKode.getText());
            zona.setNama(txtNama.getText());
            zona.setBasement((Basement) comboBasement.getSelectedItem());

            ZonaValidator validator = SpringManager.getInstance().getBean(ZonaValidator.class);
            ZonaService service = SpringManager.getInstance().getBean(ZonaService.class);


            try {
                validator.validate(zona);
                service.save(zona);
                dispose();
            } catch (ValidatorException ex) {
                messageComponent1.showWarning(ex.getMessage());
            }catch (DataAccessException ex) {
                messageComponent1.showWarning(ex.getRootCause().getMessage());
            }

            
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.ButtonGroup btnGroupPL;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox comboBasement;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private com.imam.sp_checklist.widget.PanelImageBackground panelImageBackground1;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
