/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.laporan;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.entity.master.Jabatan;
import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.entity.master.Lot;
import com.imam.sp_checklist.entity.master.Shift;
import com.imam.sp_checklist.entity.master.Zona;
import com.imam.sp_checklist.manager.ManageDataBasement;
import com.imam.sp_checklist.manager.ManageDataJabatan;
import com.imam.sp_checklist.manager.ManageDataKaryawan;
import com.imam.sp_checklist.manager.ManageDataLot;
import com.imam.sp_checklist.manager.ManageDataShift;
import com.imam.sp_checklist.manager.ManageDataZona;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.widget.ProgressbarLoading;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.jdbc.Work;

/**
 *
 * @author Imam-pc
 */
public class LaporanMaster extends javax.swing.JPanel {

    private String pathLapKaryawan = "/com/imam/sp_checklist/report/LapMasterDataKaryawan.jasper";
    private String pathLapJabatan = "/com/imam/sp_checklist/report/LapMasterDataJabatan.jasper";
    private String pathLapKendaraan = "/com/imam/sp_checklist/report/LapMasterDataKendaraan.jasper";
    private String pathLapBasement = "/com/imam/sp_checklist/report/LapMasterDataBasement.jasper";
    private String pathLapZona = "/com/imam/sp_checklist/report/LapMasterDataZona.jasper";
    private String pathLapLot = "/com/imam/sp_checklist/report/LapMasterDataLot.jasper";
    private String pathLapShift = "/com/imam/sp_checklist/report/LapMasterDataShift.jasper";
    private String pathLapArea = "/com/imam/sp_checklist/report/LapMasterDataAreaPlot.jasper";
    
    public LaporanMaster() {
        initComponents();
        
    }
    
    public void LoadJabatanCombo(){
        List<Jabatan> list = ManageDataJabatan.getInstance().getJabatanAll();
        comboJabatanJabatan.removeAllItems();
        comboJabatanKarywan.removeAllItems();
        comboJabatanJabatan.addItem("All");
        comboJabatanKarywan.addItem("All");
        list.stream().map((jabatan) -> {
            comboJabatanJabatan.addItem(jabatan);
            return jabatan;
        }).forEachOrdered((jabatan) -> {
            comboJabatanKarywan.addItem(jabatan);
        });
    }
    
    public void LoadKaryawanKaryawanCombo(Jabatan jabatan){
        
        List<Karyawan> list =  ManageDataKaryawan.getInstance().getKaryawanByJabatan(jabatan);
        comboKaryawan.removeAllItems();
        comboKaryawan.addItem("All");
        list.forEach((kr) -> {
            comboKaryawan.addItem(kr);
        });
    }
    public void LoadKaryawanKaryawanComboAll(){
        
        List<Karyawan> list =  ManageDataKaryawan.getInstance().getKaryawanAll();
        comboKaryawan.removeAllItems();
        comboKaryawan.addItem("All");
        list.forEach((kr) -> {
            comboKaryawan.addItem(kr);
        });
    }
    
    public void LoadBasement(){
        
        List<Basement> list =  ManageDataBasement.getInstance().getBasementAll();
        comboBasement.removeAllItems();
        comboBasementArea.removeAllItems();
        comboBasement.addItem("All");
        comboBasementArea.addItem("All");
        list.stream().map((kr) -> {
            comboBasement.addItem(kr);
            return kr;
        }).forEachOrdered((kr) -> {
            comboBasementArea.addItem(kr);
        });
    }
    public void LoadShift(){
        
        List<Shift> list =  ManageDataShift.getInstance().getShiftAll();
        comboShift.removeAllItems();
        comboShift.addItem("All");
        list.forEach((kr) -> {
            comboShift.addItem(kr);
        });
    }
    
    public void LoadZona(){
        
        List<Zona> list =  ManageDataZona.getInstance().getZonaAll();
        comboZona.removeAllItems();
        comboZonaArea.removeAllItems();
        comboZonaArea.addItem("All");
        comboZona.addItem("All");
        list.stream().map((kr) -> {
            comboZona.addItem(kr);
            return kr;
        }).forEachOrdered((kr) -> {
            comboZonaArea.addItem(kr);
        });
    }
    
    
    public void LoadZonaAreaBybasement(Basement basement){
        
        List<Zona> list =  ManageDataZona.getInstance().getZonaByBasement(basement);
        comboZonaArea.removeAllItems();
        comboZonaArea.addItem("All");
        list.forEach((kr) -> {
            comboZonaArea.addItem(kr);
        });
    }
    
    public void LoadLot(){
        
        List<Lot> list =  ManageDataLot.getInstance().getLotAll();
        comboLot.removeAllItems();
        comboLotArea.removeAllItems();
        comboLotArea.addItem("All");
        comboLot.addItem("All");
        list.stream().map((kr) -> {
            comboLot.addItem(kr);
            return kr;
        }).forEachOrdered((kr) -> {
            comboLotArea.addItem(kr);
        });
    }
    
    public void LoadLotByZona(Zona zona){
        
        List<Lot> list =  ManageDataLot.getInstance().getLotByZona(zona);
        comboLotArea.removeAllItems();
        comboLotArea.addItem("All");
        list.forEach((kr) -> {
            comboLotArea.addItem(kr);
        });
    }
    
    public JasperPrint displayReport(Map<String,Object>param,String varParam, Connection koneksi){
        JasperPrint jasperPrint = null;
        try {
            
            
                InputStream inputStream = getClass().getResourceAsStream(varParam);
                jasperPrint = JasperFillManager.fillReport(inputStream, param, koneksi);
                JasperViewer.viewReport(jasperPrint,false);
            
            
        } catch (JRException ex) {
            Logger.getLogger(LaporanMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jasperPrint;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMerk = new javax.swing.JTextField();
        comboJenis = new javax.swing.JComboBox<>();
        btnLapKendaraan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnLapJabatan = new javax.swing.JButton();
        comboSebagai = new javax.swing.JComboBox<>();
        comboJabatanJabatan = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnLapKaryawan = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboAktif = new javax.swing.JComboBox<>();
        comboJabatanKarywan = new javax.swing.JComboBox();
        comboKaryawan = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        btnLapZona = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        comboZona = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        btnLapBasement = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        comboBasement = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        btnLapLot = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        comboLot = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        btnLapArea = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        comboBasementArea = new javax.swing.JComboBox();
        comboZonaArea = new javax.swing.JComboBox();
        comboLotArea = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        btnLapShift = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        comboShift = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Master", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N
        setOpaque(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Kendaraan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Merk");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("Jenis");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText(":");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText(":");

        txtMerk.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        comboJenis.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "SEDAN", "MINIBUS", "CONVERTIBLE", "SPORT CAR" }));

        btnLapKendaraan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapKendaraan.setText("Tampilkan Laporan");
        btnLapKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapKendaraanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLapKendaraan)
                    .addComponent(txtMerk)
                    .addComponent(comboJenis, 0, 177, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLapKendaraan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Jabatan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setText("Jabatan");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText("Sebagai");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText(":");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText(":");

        btnLapJabatan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapJabatan.setText("Tampilkan Laporan");
        btnLapJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapJabatanActionPerformed(evt);
            }
        });

        comboSebagai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSebagai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Pengawas", "Petugas" }));

        comboJabatanJabatan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboJabatanJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboJabatanJabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLapJabatan)
                        .addGap(0, 95, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSebagai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(comboJabatanJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(comboSebagai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLapJabatan)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Karyawan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("Karyawan");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText(":");

        btnLapKaryawan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapKaryawan.setText("Tampilkan Laporan");
        btnLapKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapKaryawanActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText("Jabatan");

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText(":");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel15.setText("Aktif");

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel16.setText(":");

        comboAktif.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboAktif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Aktif", "Tidak Aktif" }));

        comboJabatanKarywan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboJabatanKarywan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboJabatanKarywan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboJabatanKarywanActionPerformed(evt);
            }
        });

        comboKaryawan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKaryawan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAktif, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboJabatanKarywan, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboKaryawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnLapKaryawan)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(comboJabatanKarywan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(comboKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(comboAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLapKaryawan)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Zona", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);

        btnLapZona.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapZona.setText("Tampilkan Laporan");
        btnLapZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapZonaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel18.setText("Zona");

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel19.setText(":");

        comboZona.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboZona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnLapZona)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLapZona)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Basement", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel5.setOpaque(false);

        btnLapBasement.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapBasement.setText("Tampilkan Laporan");
        btnLapBasement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapBasementActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel22.setText("Basement");

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel23.setText(":");

        comboBasement.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboBasement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBasement, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnLapBasement)))
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(comboBasement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLapBasement)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Lot", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel6.setOpaque(false);

        btnLapLot.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapLot.setText("Tampilkan Laporan");
        btnLapLot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapLotActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel20.setText("Lot");

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel21.setText(":");

        comboLot.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboLot.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboLot, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnLapLot)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(comboLot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLapLot)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Area Parkir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel7.setOpaque(false);

        btnLapArea.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapArea.setText("Tampilkan Laporan");
        btnLapArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapAreaActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel24.setText("Basement");

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel25.setText(":");

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel28.setText("Zona");

        jLabel29.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel29.setText(":");

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel30.setText("Lot");

        jLabel31.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel31.setText(":");

        comboBasementArea.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboBasementArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboBasementArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBasementAreaActionPerformed(evt);
            }
        });

        comboZonaArea.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboZonaArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboZonaArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboZonaAreaActionPerformed(evt);
            }
        });

        comboLotArea.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboLotArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboZonaArea, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBasementArea, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboLotArea, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(btnLapArea)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(comboBasementArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboLotArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(comboZonaArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnLapArea)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Shift", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel8.setOpaque(false);

        btnLapShift.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapShift.setText("Tampilkan Laporan");
        btnLapShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapShiftActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel26.setText("Shift");

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel27.setText(":");

        comboShift.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboShift.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboShift, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnLapShift)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(comboShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLapShift)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboJabatanKarywanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJabatanKarywanActionPerformed
        // TODO add your handling code here:
        
        if(comboJabatanKarywan.getSelectedIndex() == 0){
            LoadKaryawanKaryawanComboAll();
            //JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
        }else{
            LoadKaryawanKaryawanCombo((Jabatan) comboJabatanKarywan.getSelectedItem());
        }
        
    }//GEN-LAST:event_comboJabatanKarywanActionPerformed

    private void comboBasementAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBasementAreaActionPerformed
        // TODO add your handling code here:
        
        switch (comboBasementArea.getSelectedIndex()) {
        //LoadZona();
        //JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
            case -1:
                break;
            case 0:
                LoadZona();
                //JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
                break;
            default:
                LoadZonaAreaBybasement((Basement) comboBasementArea.getSelectedItem());
                break;
        }
        
    }//GEN-LAST:event_comboBasementAreaActionPerformed

    private void comboZonaAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboZonaAreaActionPerformed
        // TODO add your handling code here:
        
        switch (comboZonaArea.getSelectedIndex()) {
        // LoadZona();
        //JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
            case -1:
                break;
            case 0:
                LoadLot();
                //JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
                break;
            default:
                LoadLotByZona((Zona) comboZonaArea.getSelectedItem());
                break;
        }
        
    }//GEN-LAST:event_comboZonaAreaActionPerformed

    private void btnLapKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapKaryawanActionPerformed
        // TODO add your handling code here:
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork(new Work() {

                @Override
                public void execute(Connection connection) throws SQLException {
                    try {
                        String varJbtn = comboJabatanKarywan.getSelectedItem().toString();
                        String varKrywn = comboKaryawan.getSelectedItem().toString();
                        String[] splitJbtn;
                        String[] splitKrywn;
                        String varSplitJbtn;
                        String varSplitKrywn;
                        if(varJbtn.equals("All")){
                            varSplitJbtn = "";
                        }else{
                            splitJbtn = varJbtn.split(" - ");
                            System.out.println("Split Jabatan: "+Arrays.toString(splitJbtn));
                            varSplitJbtn = splitJbtn[0];
                            System.out.println("Split Jabatan string: "+varSplitJbtn);
                        }
                        if(varKrywn.equals("All")){
                            varSplitKrywn = "";
                        }else{
                            splitKrywn = varKrywn.split("-");
                            System.out.println("Split karywan: "+Arrays.toString(splitKrywn));
                            varSplitKrywn = splitKrywn[0];
                            System.out.println("Split karywan string: "+varSplitKrywn);
                        }
                        String flag;
                        switch (comboAktif.getSelectedIndex()) {
                            case 0:
                                flag = "true,false";
                                break;
                            case 1:
                                flag = "true";
                                break;
                            default:
                                flag = "false";
                                break;
                        }
                        
                        
                        InputStream logo = getClass().getResourceAsStream("/com/imam/sp_checklist/report/secure-logo.png");
                        
                        
                        
                        
                        Map<String, Object> map = new HashMap<>();
                        map.put("jabatan", varSplitJbtn);
                        map.put("karyawan", varSplitKrywn);
                        map.put("flag", flag);
                        map.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
                        
                        map.put(JRParameter.REPORT_CONNECTION, connection);
                        map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                        
                        final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                            
                            @Override
                            protected JasperPrint doInBackground() throws Exception {
                                JasperPrint print;
                                print = displayReport(map, pathLapKaryawan, connection);
                                
                                return print;
                            }
                            
                        };
                        Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
                        ProgressbarLoading loding = new ProgressbarLoading();
                        worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                            if (evt1.getPropertyName().equals("state")) {
                                if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                                    loding.dispose();
                                }
                            }
                        });
                        worker.execute();
                        loding.pack();
                        loding.setLocationRelativeTo(win);
                        loding.setVisible(true);
                    } catch (IOException | JRException ex) {
                        Logger.getLogger(LaporanMaster.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            session.close();
        
    }//GEN-LAST:event_btnLapKaryawanActionPerformed

    private void btnLapJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapJabatanActionPerformed
        // TODO add your handling code here:
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork((Connection connection) -> {
            try {
                String varJbtn = comboJabatanJabatan.getSelectedItem().toString();
                String varSebgai = comboSebagai.getSelectedItem().toString();
                String[] splitJbtn;
                String varSplitJbtn;
                String varSplitKrywn;
                if(varJbtn.equals("All")){
                    varSplitJbtn = "";
                }else{
                    splitJbtn = varJbtn.split(" - ");
                    System.out.println("Split Jabatan: "+Arrays.toString(splitJbtn));
                    varSplitJbtn = splitJbtn[0];
                    System.out.println("Split Jabatan string: "+varSplitJbtn);
                }
                switch (varSebgai) {
                    case "All":
                        varSplitKrywn = "true,false";
                        break;
                    case "Pengawas":
                        varSplitKrywn = "true";
                        break;
                    default:
                        varSplitKrywn = "false";
                        break;
                }
                InputStream logo = getClass().getResourceAsStream("/com/imam/sp_checklist/report/secure-logo.png");
                
                Map<String, Object> map = new HashMap<>();
                map.put("jabatan", varSplitJbtn);
                map.put("sebagai", varSplitKrywn);
                map.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
                
                map.put(JRParameter.REPORT_CONNECTION, connection);
                map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                
                final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                    
                    @Override
                    protected JasperPrint doInBackground() throws Exception {
                        JasperPrint print;
                        print = displayReport(map, pathLapJabatan, connection);
                        
                        return print;
                    }
                    
                };
                Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
                ProgressbarLoading loding = new ProgressbarLoading();
                worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                    if (evt1.getPropertyName().equals("state")) {
                        if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                            loding.dispose();
                        }
                    }
                });
                worker.execute();
                loding.pack();
                loding.setLocationRelativeTo(win);
                loding.setVisible(true);
            } catch (JRException | IOException ex) {
                Logger.getLogger(LaporanMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            session.close();
        
    }//GEN-LAST:event_btnLapJabatanActionPerformed

    private void btnLapKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapKendaraanActionPerformed
        // TODO add your handling code here:
        
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork((Connection connection) -> {
            try {
                String varMerk = txtMerk.getText();
                String varJenis = comboJenis.getSelectedItem().toString();
                String[] arrayJenis;
                if(varJenis.equals("All")){
                    arrayJenis = new String[]{};
                }else{
                    arrayJenis = new String[] {varJenis};
                }
                InputStream logo = getClass().getResourceAsStream("/com/imam/sp_checklist/report/secure-logo.png");
                
                
                Map<String, Object> map = new HashMap<>();
                map.put("js", arrayJenis);
                map.put("merk", varMerk);
                map.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
                
                map.put(JRParameter.REPORT_CONNECTION, connection);
                map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                
                final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                    
                    @Override
                    protected JasperPrint doInBackground() throws Exception {
                        JasperPrint print;
                        print = displayReport(map, pathLapKendaraan, connection);
                        
                        return print;
                    }
                    
                };
                Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
                ProgressbarLoading loding = new ProgressbarLoading();
                worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                    if (evt1.getPropertyName().equals("state")) {
                        if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                            loding.dispose();
                        }
                    }
                });
                worker.execute();
                loding.pack();
                loding.setLocationRelativeTo(win);
                loding.setVisible(true);
            } catch (JRException | IOException ex) {
                Logger.getLogger(LaporanMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            session.close();
        
    }//GEN-LAST:event_btnLapKendaraanActionPerformed

    private void btnLapBasementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapBasementActionPerformed
        // TODO add your handling code here:
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork((Connection connection) -> {
            try {
                String varBs = comboBasement.getSelectedItem().toString();
                String[] arrayBs;
                String varSplitBs;
                if(varBs.equals("All")){
                    varSplitBs = "";
                }else{
                    arrayBs = varBs.split(" - ");
                    System.out.println("Split Basement: "+Arrays.toString(arrayBs));
                    varSplitBs = arrayBs[0];
                    System.out.println("Split Basement string: "+varSplitBs);
                }
                InputStream logo = getClass().getResourceAsStream("/com/imam/sp_checklist/report/secure-logo.png");
                
                Map<String, Object> map = new HashMap<>();
                map.put("basement", varSplitBs);
                map.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
                
                map.put(JRParameter.REPORT_CONNECTION, connection);
                map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                    
                    @Override
                    protected JasperPrint doInBackground() throws Exception {
                        JasperPrint print;
                        print = displayReport(map, pathLapBasement, connection);
                        
                        return print;
                    }
                    
                };
                Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
                ProgressbarLoading loding = new ProgressbarLoading();
                worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                    if (evt1.getPropertyName().equals("state")) {
                        if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                            loding.dispose();
                        }
                    }
                });
                worker.execute();
                loding.pack();
                loding.setLocationRelativeTo(win);
                loding.setVisible(true);
            } catch (JRException | IOException ex) {
                Logger.getLogger(LaporanMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            session.close();
        
        
       
        
    }//GEN-LAST:event_btnLapBasementActionPerformed

    private void btnLapZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapZonaActionPerformed
        // TODO add your handling code here:
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork(new Work() {

                @Override
                public void execute(Connection connection) throws SQLException {
                    try {
                        String varZona = comboZona.getSelectedItem().toString();
                        String[] arrayZona;
                        String varSplitZona;
                        if(varZona.equals("All")){
                            varSplitZona = "";
                        }else{
                            arrayZona = varZona.split(" - ");
                            System.out.println("Split Zona: "+Arrays.toString(arrayZona));
                            varSplitZona = arrayZona[0];
                            System.out.println("Split Zona string: "+varSplitZona);
                        }
                        InputStream logo = getClass().getResourceAsStream("/com/imam/sp_checklist/report/secure-logo.png");
                        
                        Map<String, Object> map = new HashMap<>();
                        map.put("zona", varSplitZona);
                        map.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
                        
                        map.put(JRParameter.REPORT_CONNECTION, connection);
                        map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                        final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                            
                            @Override
                            protected JasperPrint doInBackground() throws Exception {
                                JasperPrint print;
                                print = displayReport(map, pathLapZona, connection);
                                
                                return print;
                            }
                            
                        };
                        Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
                        ProgressbarLoading loding = new ProgressbarLoading();
                        worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                            if (evt1.getPropertyName().equals("state")) {
                                if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                                    loding.dispose();
                                }
                            }
                        });
                        worker.execute();
                        loding.pack();
                        loding.setLocationRelativeTo(win);
                        loding.setVisible(true);
                    } catch (JRException | IOException ex) {
                        Logger.getLogger(LaporanMaster.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            session.close();
        
    }//GEN-LAST:event_btnLapZonaActionPerformed

    private void btnLapLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapLotActionPerformed
        // TODO add your handling code here:
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork((Connection connection) -> {
            try {
                String varLot = comboLot.getSelectedItem().toString();
                String[] arrayLot;
                String varSplitLot;
                if(varLot.equals("All")){
                    varSplitLot = "";
                }else{
                    arrayLot = varLot.split(" - ");
                    System.out.println("Split Zona: "+Arrays.toString(arrayLot));
                    varSplitLot = arrayLot[3];
                    System.out.println("Split Zona string: "+varSplitLot);
                }
                InputStream logo = getClass().getResourceAsStream("/com/imam/sp_checklist/report/secure-logo.png");
                
                Map<String, Object> map = new HashMap<>();
                map.put("lot", varSplitLot);
                map.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
                
                map.put(JRParameter.REPORT_CONNECTION, connection);
                map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                    
                    @Override
                    protected JasperPrint doInBackground() throws Exception {
                        JasperPrint print;
                        print = displayReport(map, pathLapLot, connection);
                        
                        return print;
                    }
                    
                };
                Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
                ProgressbarLoading loding = new ProgressbarLoading();
                worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                    if (evt1.getPropertyName().equals("state")) {
                        if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                            loding.dispose();
                        }
                    }
                });
                worker.execute();
                loding.pack();
                loding.setLocationRelativeTo(win);
                loding.setVisible(true);
            } catch (JRException | IOException ex) {
                Logger.getLogger(LaporanMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            session.close();
        
        
    }//GEN-LAST:event_btnLapLotActionPerformed

    private void btnLapShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapShiftActionPerformed
        // TODO add your handling code here:
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork((Connection connection) -> {
            try {
                String varSip;
                if(comboShift.getSelectedItem().equals("All")){
                    varSip = "";
                }else{
                    varSip = comboShift.getSelectedItem().toString();
                }
                InputStream logo = getClass().getResourceAsStream("/com/imam/sp_checklist/report/secure-logo.png");
                
                
                Map<String, Object> map = new HashMap<>();
                map.put("shift", varSip);
                map.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
                
                map.put(JRParameter.REPORT_CONNECTION, connection);
                map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                    
                    @Override
                    protected JasperPrint doInBackground() throws Exception {
                        JasperPrint print;
                        print = displayReport(map, pathLapShift, connection);
                        
                        return print;
                    }
                    
                };
                Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
                ProgressbarLoading loding = new ProgressbarLoading();
                worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                    if (evt1.getPropertyName().equals("state")) {
                        if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                            loding.dispose();
                        }
                    }
                });
                worker.execute();
                loding.pack();
                loding.setLocationRelativeTo(win);
                loding.setVisible(true);
            } catch (JRException | IOException ex) {
                Logger.getLogger(LaporanMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            session.close();
        
    }//GEN-LAST:event_btnLapShiftActionPerformed

    private void btnLapAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapAreaActionPerformed
        // TODO add your handling code here:
        
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork((Connection connection) -> {
            try {
                ///BASEMENT///////
                String varBs = comboBasementArea.getSelectedItem().toString();
                String[] arrayBs;
                String varSplitBs;
                if(varBs.equals("All")){
                    varSplitBs = "";
                }else{
                    arrayBs = varBs.split(" - ");
                    System.out.println("Split Basement: "+Arrays.toString(arrayBs));
                    varSplitBs = arrayBs[0];
                    System.out.println("Split Basement string: "+varSplitBs);
                }
                /////ZONA////
                String varZona = comboZonaArea.getSelectedItem().toString();
                String[] arrayZona;
                String varSplitZona;
                if(varZona.equals("All")){
                    varSplitZona = "";
                }else{
                    arrayZona = varZona.split(" - ");
                    System.out.println("Split Zona: "+Arrays.toString(arrayZona));
                    varSplitZona = arrayZona[0];
                    System.out.println("Split Zona string: "+varSplitZona);
                }
                ////LOT/////////
                String varLot = comboLotArea.getSelectedItem().toString();
                String[] arrayLot;
                String varSplitLot;
                if(varLot.equals("All")){
                    varSplitLot = "";
                }else{
                    arrayLot = varLot.split("-");
                    System.out.println("Split Zona: "+Arrays.toString(arrayLot));
                    varSplitLot = arrayLot[2];
                    System.out.println("Split Zona string: "+varSplitLot);
                }
                InputStream logo = getClass().getResourceAsStream("/com/imam/sp_checklist/report/secure-logo.png");
                
                
                Map<String, Object> map = new HashMap<>();
                map.put("basement", varSplitBs);
                map.put("zona", varSplitZona);
                map.put("lot", varSplitLot);
                map.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
                
                map.put(JRParameter.REPORT_CONNECTION, connection);
                map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                    
                    @Override
                    protected JasperPrint doInBackground() throws Exception {
                        JasperPrint print;
                        print = displayReport(map, pathLapArea, connection);
                        
                        return print;
                    }
                    
                };
                Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
                ProgressbarLoading loding = new ProgressbarLoading();
                worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                    if (evt1.getPropertyName().equals("state")) {
                        if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                            loding.dispose();
                        }
                    }
                });
                worker.execute();
                loding.pack();
                loding.setLocationRelativeTo(win);
                loding.setVisible(true);
            } catch (JRException | IOException ex) {
                Logger.getLogger(LaporanMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            session.close();
        
        
    }//GEN-LAST:event_btnLapAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLapArea;
    private javax.swing.JButton btnLapBasement;
    private javax.swing.JButton btnLapJabatan;
    private javax.swing.JButton btnLapKaryawan;
    private javax.swing.JButton btnLapKendaraan;
    private javax.swing.JButton btnLapLot;
    private javax.swing.JButton btnLapShift;
    private javax.swing.JButton btnLapZona;
    private javax.swing.JComboBox<String> comboAktif;
    private javax.swing.JComboBox comboBasement;
    private javax.swing.JComboBox comboBasementArea;
    private javax.swing.JComboBox comboJabatanJabatan;
    private javax.swing.JComboBox comboJabatanKarywan;
    private javax.swing.JComboBox<String> comboJenis;
    private javax.swing.JComboBox comboKaryawan;
    private javax.swing.JComboBox comboLot;
    private javax.swing.JComboBox comboLotArea;
    private javax.swing.JComboBox<String> comboSebagai;
    private javax.swing.JComboBox comboShift;
    private javax.swing.JComboBox comboZona;
    private javax.swing.JComboBox comboZonaArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField txtMerk;
    // End of variables declaration//GEN-END:variables
}
