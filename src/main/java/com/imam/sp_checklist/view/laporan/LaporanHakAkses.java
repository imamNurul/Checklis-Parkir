/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.laporan;

import com.imam.sp_checklist.entity.user_akses.Grup;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.manager.ManageDataGrup;
import com.imam.sp_checklist.manager.ManageDataPengguna;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.widget.ProgressbarLoading;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
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
import javax.swing.AbstractButton;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.jdbc.Work;

/**
 *
 * @author Imam-pc
 */
public class LaporanHakAkses extends javax.swing.JPanel {

    /**
     * Creates new form LaporanMaster
     */
    public LaporanHakAkses() {
        initComponents();
    }
    
    public void LoadPenggunaCombo(){
        List<Pengguna> list = ManageDataPengguna.getInstance().getPenggunaAll();
        comboPengguna.removeAllItems();
        comboPengguna.addItem("All");
        list.forEach((pgn) -> {
            comboPengguna.addItem(pgn);
        });
    }
    
    public void LoadGrupCombo(){
        List<Grup> list = ManageDataGrup.getInstance().getGrupAll();
        
        comboGrup.removeAllItems();
        comboGrupAkses.removeAllItems();
        comboGrupPengguna.removeAllItems();
        comboGrup.addItem("All");
        comboGrupAkses.addItem("All");
        comboGrupPengguna.addItem("All");
        list.stream().map((gp) -> {
            comboGrup.addItem(gp);
            return gp;
        }).map((gp) -> {
            comboGrupAkses.addItem(gp);
            return gp;
        }).forEachOrdered((gp) -> {
            comboGrupPengguna.addItem(gp);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnLapGrup = new javax.swing.JButton();
        comboGrup = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnLapPengguna = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboAktif = new javax.swing.JComboBox<>();
        comboPengguna = new javax.swing.JComboBox();
        comboGrupPengguna = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnLapHakAkses = new javax.swing.JButton();
        txtNamaHakAkses = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnLapHakAksesGrup = new javax.swing.JButton();
        txtNamaHakAksesGrup = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        comboGrupAkses = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Akses Pengguna", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N
        setOpaque(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Grup", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setText("Grup");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText(":");

        btnLapGrup.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapGrup.setText("Tampilkan Laporan");
        btnLapGrup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapGrupActionPerformed(evt);
            }
        });

        comboGrup.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboGrup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLapGrup)
                    .addComponent(comboGrup, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(comboGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLapGrup)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Pengguna", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("Grup");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText(":");

        btnLapPengguna.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapPengguna.setText("Tampilkan Laporan");
        btnLapPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapPenggunaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText("Pengguna");

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText(":");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel15.setText("Aktif");

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel16.setText(":");

        comboAktif.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboAktif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Aktif", "Tidak Aktif" }));

        comboPengguna.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboPengguna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        comboGrupPengguna.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboGrupPengguna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboGrupPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(90, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLapPengguna)
                            .addComponent(comboAktif, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(comboPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(comboGrupPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(comboAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnLapPengguna)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Data Hak Akses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText("Nama Hak Akses");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText(":");

        btnLapHakAkses.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapHakAkses.setText("Tampilkan Laporan");
        btnLapHakAkses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapHakAksesActionPerformed(evt);
            }
        });

        txtNamaHakAkses.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLapHakAkses)
                    .addComponent(txtNamaHakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(txtNamaHakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLapHakAkses)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Laporan Grup Hak Akses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel5.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText("Nama Hak Akses");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText(":");

        btnLapHakAksesGrup.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnLapHakAksesGrup.setText("Tampilkan Laporan");
        btnLapHakAksesGrup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapHakAksesGrupActionPerformed(evt);
            }
        });

        txtNamaHakAksesGrup.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel17.setText("Grup");

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel18.setText(":");

        comboGrupAkses.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboGrupAkses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLapHakAksesGrup)
                    .addComponent(txtNamaHakAksesGrup, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(comboGrupAkses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(txtNamaHakAksesGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(comboGrupAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnLapHakAksesGrup)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLapPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapPenggunaActionPerformed
        // TODO add your handling code here:
        
         SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork((Connection connection) -> {
                String inputStream = "/com/imam/sp_checklist/report/LapHakAksesPengguna.jasper";
                String varPgn = comboPengguna.getSelectedItem().toString();
                String varGrup = comboGrupPengguna.getSelectedItem().toString();
                String[] splitPgn;
                String[] splitGrup;
                String varSplitPgn;
                String varSplitGrup;
                if(varPgn.equals("All")){
                    varSplitPgn = "";
                }else{
                    splitPgn = varPgn.split(" - ");
                    System.out.println("Split Pengguna: "+Arrays.toString(splitPgn));
                    varSplitPgn = splitPgn[0];
                    System.out.println("Split Pengguna string: "+varSplitPgn);
                }
                if(varGrup.equals("All")){
                    varSplitGrup = "";
                }else{
                    splitGrup = varGrup.split("-");
                    System.out.println("Split Grup pengguna: "+Arrays.toString(splitGrup));
                    varSplitGrup = splitGrup[0];
                    System.out.println("Split Grup pengguna string: "+varSplitGrup);
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
                Map<String, Object> map = new HashMap<>();
                map.put("nama", varSplitPgn);
                map.put("grup", varSplitGrup);
                map.put("flag", flag);
                map.put(JRParameter.REPORT_CONNECTION, connection);
                map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                    
                    @Override
                    protected JasperPrint doInBackground() throws Exception {
                        JasperPrint print;
                        print = displayReport(map, inputStream, connection);
                        
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
         });
            session.close();
        
    }//GEN-LAST:event_btnLapPenggunaActionPerformed

    private void btnLapHakAksesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapHakAksesActionPerformed
        // TODO add your handling code here:
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork((Connection connection) -> {
                String inputStream = "/com/imam/sp_checklist/report/LapHakAkses.jasper";
                String varKaes = txtNamaHakAkses.getText();
                Map<String, Object> map = new HashMap<>();
                map.put("akses", varKaes);
                map.put(JRParameter.REPORT_CONNECTION, connection);
                map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                    
                    @Override
                    protected JasperPrint doInBackground() throws Exception {
                        JasperPrint print;
                        print = displayReport(map, inputStream, connection);
                        
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
        });
            session.close();
        
    }//GEN-LAST:event_btnLapHakAksesActionPerformed

    private void btnLapGrupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapGrupActionPerformed
        // TODO add your handling code here:
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork(new Work() {

                @Override
                public void execute(Connection connection) throws SQLException {
                    String inputStream = "/com/imam/sp_checklist/report/LapHakAksesGrup.jasper";
                    String varGrup = comboGrup.getSelectedItem().toString();
                    String[] splitGrup;
                    String varSplitGrup;
                    if(varGrup.equals("All")){
                        varSplitGrup = "";
                    }else{
                        splitGrup = varGrup.split(" - ");
                        System.out.println("Split Grup pengguna: "+Arrays.toString(splitGrup));
                        varSplitGrup = splitGrup[0];
                        System.out.println("Split Grup pengguna string: "+varSplitGrup);
                    }
                    Map<String, Object> map = new HashMap<>();
                    map.put("grup", varSplitGrup);
                    map.put(JRParameter.REPORT_CONNECTION, connection);
                    map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                    final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
                        
                        @Override
                        protected JasperPrint doInBackground() throws Exception {
                            JasperPrint print;
                            print = displayReport(map, inputStream, connection);
                            
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
                }
            });
            session.close();
        
    }//GEN-LAST:event_btnLapGrupActionPerformed

    private void btnLapHakAksesGrupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapHakAksesGrupActionPerformed
        // TODO add your handling code here:
        
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            
            session.doWork((Connection connection) -> {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("/com/imam/sp_checklist/report/LapHakAksesGrupPengguna.jasper");
                    
                    String varGrup = comboGrupAkses.getSelectedItem().toString();
                    String[] splitGrup;
                    
                    String varSplitGrup;
                    
                    if(varGrup.equals("All")){
                        varSplitGrup = "";
                    }else{
                        splitGrup = varGrup.split(" - ");
                        System.out.println("Split Grup pengguna: "+Arrays.toString(splitGrup));
                        varSplitGrup = splitGrup[0];
                        System.out.println("Split Grup pengguna string: "+varSplitGrup);
                    }
                    
                    String varKaes = txtNamaHakAksesGrup.getText();
                    
                    
                    Map<String, Object> map = new HashMap<>();
                    
                    map.put("grup", varSplitGrup);
                    map.put("akses", varKaes);
                    
                    map.put(JRParameter.REPORT_CONNECTION, connection);
                    map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
                    
                    JasperPrint report = JasperFillManager.fillReport(inputStream, map, connection);
                    
                    JasperViewer.viewReport(report,false);
                } catch (JRException ex) {
                    Logger.getLogger(LaporanHakAkses.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
            session.close();
        
    }//GEN-LAST:event_btnLapHakAksesGrupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLapGrup;
    private javax.swing.JButton btnLapHakAkses;
    private javax.swing.JButton btnLapHakAksesGrup;
    private javax.swing.JButton btnLapPengguna;
    private javax.swing.JComboBox<String> comboAktif;
    private javax.swing.JComboBox comboGrup;
    private javax.swing.JComboBox comboGrupAkses;
    private javax.swing.JComboBox comboGrupPengguna;
    private javax.swing.JComboBox comboPengguna;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtNamaHakAkses;
    private javax.swing.JTextField txtNamaHakAksesGrup;
    // End of variables declaration//GEN-END:variables
}
