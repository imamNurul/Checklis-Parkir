/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.karyawan;

import com.imam.sp_checklist.entity.master.Jabatan;
import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.manager.LoginManager;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.service.JabatanService;
import com.imam.sp_checklist.service.KaryawanService;
import com.imam.sp_checklist.validator.ValidatorException;
import com.imam.sp_checklist.validator.impl.KaryawanValidator;
import com.toedter.calendar.JCalendar;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.springframework.dao.DataAccessException;
import usu.widget.FileBrowserImage;

/**
 *
 * @author Imam-pc
 */
public class UbahKaryawan extends javax.swing.JDialog {

    private ImageIcon varImage;
    private File file;
    private Karyawan karyawan;
    public UbahKaryawan() {
        setModal(true);
        initComponents();
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
        Locale locale = Locale.forLanguageTag("in-ID");
        
        Calendar now = Calendar.getInstance(locale);
        now.setTime(new Date());
        
        JCalendar jc = new JCalendar();
        jc.setCalendar(now);
        
        dateTglLahir.setCalendar(jc.getCalendar());
        dateTglLahir.setLocale(locale);
        
        
    }
    
    public void LoadJabtanCombo(){
        JabatanService jb = SpringManager.getInstance().getBean(JabatanService.class);
     
        List<Jabatan> list =  jb.findAll();
        
        for(Jabatan jabatan : list){
           comboJabatan.addItem(jabatan);
        }
    }
    
    public Karyawan ubahKaryawan(Karyawan param, ImageIcon img){
        
        LoadJabtanCombo();
        
         karyawan = param;
        
        try {
            if(img == null){
                URL imgPath = getClass().getResource("/com/imam/sp_checklist/image/user-kosong.png");
                labelPhoto.setIcon(new ImageIcon(imgPath));
                messageComponent1.showWarning("Photo kosong");
            }else{
                String imgPath = karyawan.getPhoto();
                BufferedImage myImg =ImageIO.read(new File(imgPath));
                Image rImg = myImg.getScaledInstance(labelPhoto.getWidth(), labelPhoto.getHeight(), Image.SCALE_SMOOTH);
                labelPhoto.setIcon(new ImageIcon(rImg));
            }
        } catch (IOException ex) {
            Logger.getLogger(UbahKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtAlamat.setText(karyawan.getAlamat());
        txtAlamatPhoto.setText(karyawan.getPhoto());
        txtHP.setText(karyawan.getTelepon());
        txtNIP.setText(karyawan.getId());
        txtNama.setText(karyawan.getNama());
        txtTmptLahir.setText(karyawan.getTmpt_lahir());
        comboJabatan.setSelectedItem(karyawan.getJabatan());
        dateTglLahir.setDate(karyawan.getTanggalLahir());
        
        if(karyawan.getJekel().equals("L")){
            rbLaki.setSelected(true);
        }else{
            rbPr.setSelected(true);
        }
        
        cekBoxAktif.setSelected(karyawan.getFlag());
        
        if(karyawan.getFlag()== true){
            cekBoxAktif.setText("Aktif");
        }else{
            cekBoxAktif.setText("Tidak Aktif");
        }
        
        lblBuatBy.setText(karyawan.getBuatBy());
        lblWktuBuat.setText(String.valueOf(karyawan.getWaktuDibuat()));
        
        setLocationRelativeTo(this);
        setVisible(true);
        
        return karyawan;
        
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
        lblWktuBuat = new javax.swing.JLabel();
        panelImageBackground1 = new com.imam.sp_checklist.widget.PanelImageBackground();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTmptLahir = new javax.swing.JTextField();
        panel_Gambar1 = new com.imam.sp_checklist.widget.Panel_Gambar();
        labelPhoto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNIP = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamatPhoto = new javax.swing.JTextArea();
        cekBoxAktif = new javax.swing.JCheckBox();
        rbLaki = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        txtHP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rbPr = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnCariPhoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateTglLahir = new com.toedter.calendar.JDateChooser();
        comboJabatan = new javax.swing.JComboBox();

        lblBuatBy.setText("BuatBy");

        lblWktuBuat.setText("WaktuBuat");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panelImageBackground1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ubah Karyawan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18)))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText(":");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("Tmpt Lahir");

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

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setText("No. HP");

        txtTmptLahir.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        panel_Gambar1.setOpaque(false);

        labelPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imam/sp_checklist/image/user-kosong.png"))); // NOI18N

        javax.swing.GroupLayout panel_Gambar1Layout = new javax.swing.GroupLayout(panel_Gambar1);
        panel_Gambar1.setLayout(panel_Gambar1Layout);
        panel_Gambar1Layout.setHorizontalGroup(
            panel_Gambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Gambar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPhoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_Gambar1Layout.setVerticalGroup(
            panel_Gambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Gambar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPhoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText("Alamat");

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText(":");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText(":");

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel19.setText(":");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText(":");

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText(":");

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel18.setText("Photo");

        txtNIP.setEditable(false);
        txtNIP.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        txtAlamatPhoto.setEditable(false);
        txtAlamatPhoto.setColumns(20);
        txtAlamatPhoto.setRows(5);
        jScrollPane2.setViewportView(txtAlamatPhoto);

        cekBoxAktif.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        cekBoxAktif.setSelected(true);
        cekBoxAktif.setText("Aktif");
        cekBoxAktif.setOpaque(false);
        cekBoxAktif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBoxAktifActionPerformed(evt);
            }
        });

        btnGroupPL.add(rbLaki);
        rbLaki.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rbLaki.setSelected(true);
        rbLaki.setText("Laki - laki");
        rbLaki.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText(":");

        txtHP.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("Nama");

        btnGroupPL.add(rbPr);
        rbPr.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rbPr.setText("Perempuan");
        rbPr.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Jenis Kelamin");

        txtNama.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel15.setText("Tgl Lahir");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText(":");

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel16.setText(":");

        btnCariPhoto.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCariPhoto.setText("Cari Photo");
        btnCariPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPhotoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("NIP");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("Jabatan");

        dateTglLahir.setDate(new java.util.Date());
        dateTglLahir.setDateFormatString("dd MMM yyyy");
        dateTglLahir.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        comboJabatan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));

        javax.swing.GroupLayout panelImageBackground1Layout = new javax.swing.GroupLayout(panelImageBackground1);
        panelImageBackground1.setLayout(panelImageBackground1Layout);
        panelImageBackground1Layout.setHorizontalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCariPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHP)
                            .addComponent(jScrollPane1)
                            .addComponent(txtNama)
                            .addComponent(txtNIP)
                            .addComponent(comboJabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(rbLaki)
                                .addGap(18, 18, 18)
                                .addComponent(rbPr))
                            .addComponent(txtTmptLahir)
                            .addComponent(jScrollPane2)
                            .addComponent(dateTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cekBoxAktif)
                            .addComponent(panel_Gambar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelImageBackground1Layout.setVerticalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekBoxAktif))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addComponent(rbLaki)
                            .addComponent(rbPr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14)
                            .addComponent(txtTmptLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16))
                            .addComponent(dateTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(comboJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12)
                            .addComponent(txtHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariPhoto))
                    .addComponent(panel_Gambar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        getContentPane().add(panelImageBackground1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Pengguna pengguna = LoginManager.getInstance().getPengguna();
        
        if(comboJabatan.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Jabatan belum dipilih");
        }else{
            karyawan = new Karyawan();
            karyawan.setAlamat(txtAlamat.getText());

            karyawan.setFlag(cekBoxAktif.isSelected());

            karyawan.setTanggalLahir(dateTglLahir.getDate()); 
            karyawan.setTmpt_lahir(txtTmptLahir.getText());
            if(rbLaki.isSelected()==true){
                karyawan.setJekel("L");
            }else{
                karyawan.setJekel("P");
            }
            karyawan.setJabatan((Jabatan) comboJabatan.getSelectedItem());
            karyawan.setNama(txtNama.getText());
            karyawan.setId(txtNIP.getText());
            karyawan.setTelepon(txtHP.getText());
            karyawan.setWaktuUbah(new java.sql.Timestamp(new java.util.Date().getTime()));
            karyawan.setUbahBy(pengguna.getKaryawan().getNama());
            karyawan.setBuatBy(lblBuatBy.getText());
            karyawan.setWaktuDibuat(Timestamp.valueOf(lblWktuBuat.getText()));
            karyawan.setPhoto(txtAlamatPhoto.getText());

            KaryawanValidator validator = SpringManager.getInstance().getBean(KaryawanValidator.class);
            KaryawanService service = SpringManager.getInstance().getBean(KaryawanService.class);

            try {
                validator.validate(karyawan);
                service.update(karyawan);
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

    private void cekBoxAktifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBoxAktifActionPerformed
        // TODO add your handling code here:
        if(cekBoxAktif.isSelected() == false){
            cekBoxAktif.setText("Tidak Aktif");
        }else{
            cekBoxAktif.setText("Aktif");
        }
    }//GEN-LAST:event_cekBoxAktifActionPerformed

    private void btnCariPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPhotoActionPerformed
        // TODO add your handling code here:

        FileBrowserImage chooser = new FileBrowserImage();
        chooser.setFileSelectionMode(FileBrowserImage.FILES_ONLY);
        //chooser.setFileFilter(new FileNameExtensionFilter("jpg|png|bmp", "jpg","png","bmp"));

        if(chooser.showOpenDialog(this)==FileBrowserImage.APPROVE_OPTION){
            file=chooser.getSelectedFile();
            try {
                Image img = ImageIO.read(new FileInputStream(file));

                Image rImg = img.getScaledInstance(labelPhoto.getWidth(), labelPhoto.getHeight(), Image.SCALE_SMOOTH);

                varImage = new ImageIcon(rImg);
                labelPhoto.setIcon(varImage);
                txtAlamatPhoto.setText(file.getAbsolutePath());
            } catch (IOException ex) {
                System.out.println("error mengabil foto "+ex.getMessage());
                Logger.getLogger(TambahKaryawan.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnCariPhotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCariPhoto;
    private javax.swing.ButtonGroup btnGroupPL;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JCheckBox cekBoxAktif;
    private javax.swing.JComboBox comboJabatan;
    private com.toedter.calendar.JDateChooser dateTglLahir;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelPhoto;
    private javax.swing.JLabel lblBuatBy;
    private javax.swing.JLabel lblWktuBuat;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private com.imam.sp_checklist.widget.PanelImageBackground panelImageBackground1;
    private com.imam.sp_checklist.widget.Panel_Gambar panel_Gambar1;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPr;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextArea txtAlamatPhoto;
    private javax.swing.JTextField txtHP;
    private javax.swing.JTextField txtNIP;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTmptLahir;
    // End of variables declaration//GEN-END:variables
}
