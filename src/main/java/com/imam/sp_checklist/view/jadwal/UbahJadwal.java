/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.jadwal;

import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.entity.master.Lot;
import com.imam.sp_checklist.entity.master.Shift;
import com.imam.sp_checklist.entity.transaksi.Jadwal;
import com.imam.sp_checklist.entity.transaksi.JadwalDetail;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.manager.LoginManager;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.service.JadwalService;
import com.imam.sp_checklist.service.KaryawanService;
import com.imam.sp_checklist.service.LotService;
import com.imam.sp_checklist.service.ShiftService;
import com.stripbandunk.jwidget.model.DefaultDoubleListModel;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Imam-pc
 */
public class UbahJadwal extends javax.swing.JDialog {
    
    private DefaultDoubleListModel<Lot> model;
    private DynamicTableModel<JadwalDetail> tableModel;
    
    private JadwalDetail jadwalDetail; 
    private Jadwal jadwal;
    private Locale locale = Locale.forLanguageTag("in-ID");
    private Calendar now;
    
    public UbahJadwal() {
        setModal(true);
        initComponents();
        
        tableModel = new DynamicTableModel<>(JadwalDetail.class);
        tableJadwalDetail.setDynamicModel(tableModel);
        
        model = new DefaultDoubleListModel<>(Lot.class);
        AreaPlot.setModel(model);
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
        //Locale locale = Locale.forLanguageTag("in-ID");
        
        now = Calendar.getInstance(locale);
        //now.setTime(new Date());
        
        tglJadwal.setLocale(locale);
        tglJadwal.setDateFormatString("EEEE, d MMMM yyyy");
        
    }
    
    public Jadwal ubahJadwal(Jadwal param){
        
        LoadListLot();
        LoadComboPengawas();
        LoadComboPetugas();
        LoadComboShift();
        
        
        jadwal = param;
        
        lblBln.setText(jadwal.getBulan());
        lblThn.setText(String.valueOf(jadwal.getTahun()));
        comboPengawas.setSelectedItem(jadwal.getPengawas());
        comboPetugas.setSelectedItem(jadwal.getPetugas());
        lblId_header.setText(String.valueOf(jadwal.getId()));
        
        LoadJadwalDetail(Integer.parseInt(lblId_header.getText()));
        
        
        setLocationRelativeTo(this);
        setVisible(true);
        
        return jadwal;
        
    }
    
    public void LoadJadwalDetail(int id){
        
        JadwalService service = SpringManager.getInstance().getBean(JadwalService.class);
        List<JadwalDetail> jl = service.findAllDetail(id);
        
        for(JadwalDetail detail : jl){
            tableModel.add(detail);
        }
        
    }
    
    public void LoadListLot(){
        LotService service = SpringManager.getInstance().getBean(LotService.class);
        List<Lot> lt = service.findAll();

        
        for (Lot lot : lt) {
            model.add(lot);
        }
        
    }
    
    public void LoadComboPengawas(){
        KaryawanService ks = SpringManager.getInstance().getBean(KaryawanService.class);
        List<Karyawan> kr = ks.findPengawasByJabatan();

        
        for (Karyawan akses : kr) {
            comboPengawas.addItem(akses);
        }
        
    }
    
    public void LoadComboPetugas(){
        KaryawanService ks = SpringManager.getInstance().getBean(KaryawanService.class);
        List<Karyawan> kr = ks.findPetugasByJabatan();

        
        for (Karyawan akses : kr) {
            comboPetugas.addItem(akses);
        }
        
    }
    
    public void LoadComboShift(){
        ShiftService sf = SpringManager.getInstance().getBean(ShiftService.class);
        List<Shift> shifts = sf.findAll();

        
        for (Shift akses : shifts) {
            comboShift.addItem(akses);
        }
        
    }
    
    private void clear(){
        comboShift.setSelectedItem("Pilih");
        comboKet.setSelectedItem("Pilih");
        model.actionRemoveAll();
        
        
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
        lblIndex = new javax.swing.JLabel();
        lblId_header = new javax.swing.JLabel();
        lblId_detail = new javax.swing.JLabel();
        panelImageBackground1 = new com.imam.sp_checklist.widget.PanelImageBackground();
        jPanel1 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AreaPlot = new com.stripbandunk.jwidget.JDoubleList();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tglJadwal = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnUbahTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJadwalDetail = new com.stripbandunk.jwidget.JDynamicTable();
        comboPengawas = new javax.swing.JComboBox();
        comboPetugas = new javax.swing.JComboBox();
        comboShift = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboKet = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblBln = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblThn = new javax.swing.JLabel();

        lblIndex.setText("jLabel16");

        lblId_header.setText("jLabel14");

        lblId_detail.setText("jLabel16");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panelImageBackground1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ubah Jadwal Petugas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N

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

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("Pengawas");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Area Plot :");

        AreaPlot.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        AreaPlot.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("Petugas");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText(":");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText(":");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText("Tanggal");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText(":");

        tglJadwal.setDateFormatString("EEEE, d MMMM yyyy");
        tglJadwal.setEnabled(false);
        tglJadwal.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("Shift");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText(":");

        btnUbahTable.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnUbahTable.setText("Ubah table");
        btnUbahTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahTableActionPerformed(evt);
            }
        });

        tableJadwalDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableJadwalDetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableJadwalDetail);

        comboPengawas.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboPengawas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));

        comboPetugas.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboPetugas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));

        comboShift.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboShift.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText("Keterangan");

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText(":");

        comboKet.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Libur", "Masuk", "Cuti", "Izin", "Sakit" }));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText("Bln / Thn");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel15.setText(":");

        lblBln.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblBln.setText("November");

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel17.setText("/");

        lblThn.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblThn.setText("2020");

        javax.swing.GroupLayout panelImageBackground1Layout = new javax.swing.GroupLayout(panelImageBackground1);
        panelImageBackground1.setLayout(panelImageBackground1Layout);
        panelImageBackground1Layout.setHorizontalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboPengawas, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnUbahTable)
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tglJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboShift, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboKet, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                        .addComponent(lblBln, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblThn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(comboPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AreaPlot, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 69, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelImageBackground1Layout.setVerticalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AreaPlot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(comboPengawas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(comboPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(lblBln)
                            .addComponent(jLabel17)
                            .addComponent(lblThn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addComponent(tglJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(comboShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(comboKet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(btnUbahTable)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        int index = 1;
        int totDay;
        Date dts = null;
        Calendar blnInt = Calendar.getInstance(locale);
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            JadwalDetail item = tableModel.get(i);
            dts = item.getTglDetail();
            index =+ i;
            
        }
        
        Pengguna pgn = LoginManager.getInstance().getPengguna();
        
         System.out.println("total count table luar : "+index+1);
        
        
        if(comboPengawas.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Pengawas belum dipilih");
        }else if(comboPetugas.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Petugas belum dipilih");
        }else if(dts == null){
            messageComponent1.showWarning("Table kosong" );
        }else{
            
            blnInt.setTimeInMillis(dts.getTime());
             totDay = blnInt.getActualMaximum(Calendar.DAY_OF_MONTH);
             if(index+1 < totDay){
                messageComponent1.showWarning("Jumlah hari yang diinput kurang dari "+totDay);
             }else if(index+1 > totDay){
                messageComponent1.showWarning("Jumlah hari yang diinput lebih besar dari "+totDay); 
             }else{
                 
                    System.out.println("total count table : "+index);
                    System.out.println("total count tanggal : "+totDay);


                    jadwal = new Jadwal();
                    jadwalDetail = new JadwalDetail();
                    jadwal.setBulan(lblBln.getText());

                    jadwal.setPengawas((Karyawan) comboPengawas.getSelectedItem());
                    jadwal.setPetugas((Karyawan) comboPetugas.getSelectedItem());
                    jadwal.setTahun(Integer.parseInt(lblThn.getText()));
                    jadwal.setUbahBy(pgn.getKaryawan().getNama());
                    jadwal.setTglJadwal(new java.sql.Timestamp(new java.util.Date().getTime()));
                    jadwal.setWaktuTransaksiDiubah(new java.sql.Timestamp(new java.util.Date().getTime()));
                    jadwal.setId(Long.parseLong(lblId_header.getText()));
                    //jadwalDetail.hapusSemuaJadwalLot();
                   // jadwal.hapusDaftarJadwal(jadwalDetail);
                    
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        jadwalDetail = tableModel.get(i);

                        jadwal.tambahDaftarJadwal(jadwalDetail);
                        
                    }
                    List<Lot> lt = new ArrayList<>(jadwalDetail.getDaftarJadwalLot());

                    lt.forEach((lot) -> {
                        jadwalDetail.tambahJadwalLot(lot);
                });
                    
                    JadwalService service = SpringManager.getInstance().getBean(JadwalService.class);
                    service.update(jadwal);
                    dispose();

                    System.out.println("jadwal simpan daftar detail : "+jadwal.getDaftarJadwal());
                    System.out.println("jadwalDetail lot simpan : "+jadwalDetail.getDaftarJadwalLot());
                        System.out.println("jadwal bln simpan : "+jadwal.getBulan());
                        System.out.println("jadwal pngws simpan : "+jadwal.getPengawas());
                        System.out.println("jadwal ptgs simpan : "+jadwal.getPetugas());
                        System.out.println("jadwal thn simpan : "+jadwal.getTahun());
                        System.out.println("jadwal tglJdwl simpan : "+jadwal.getTglJadwal());
                        System.out.println("jadwal tglTranskasiUbah simpan : "+jadwal.getWaktuTransaksiDiubah());

                    
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

    private void btnUbahTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahTableActionPerformed
        // TODO add your handling code here:
        
        if(tglJadwal.getDate()== null){
            messageComponent1.showWarning("Tanggal Jadwal kosong");
        }else if(comboPengawas.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Pengawas belum dipilih");
        }else if(comboPetugas.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Petugas belum dipilih");
        }else if(comboKet.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Keterangan belum dipilih");
        }else if(tableJadwalDetail.getSelectedRow() == -1){
            messageComponent1.showWarning("Pilih salah satu dari tabel");
        }else{
            
            Date dt = new java.sql.Date(tglJadwal.getDate().getTime());
           // SimpleDateFormat format = new SimpleDateFormat("MM", locale);
           
                 
            
            System.out.println("gett hari: "+dt);
            System.out.println("gett Ket: "+comboKet.getSelectedItem());
            System.out.println("gett lot: "+model.getValues());
            
            jadwalDetail = new JadwalDetail();
            jadwalDetail.setTglDetail(dt);
            jadwalDetail.setKeterangan(comboKet.getSelectedItem().toString());
            if(comboShift.getSelectedItem().equals("Pilih")){
                jadwalDetail.setShift(null);
            }else{
                jadwalDetail.setShift((Shift) comboShift.getSelectedItem());
            }
            
            if(model.getValues() == null){
                jadwalDetail.tambahJadwalLot(null);
            }else{
                 List<Lot> lt = new ArrayList<>(model.getValues());
                 
                 lt.forEach((lot) -> {
                     jadwalDetail.tambahJadwalLot(lot);
                });
            }
            System.out.println("get hari: "+jadwalDetail.getTglDetail());
            System.out.println("get Ket: "+jadwalDetail.getKeterangan());
            System.out.println("get Shift: "+jadwalDetail.getShift());
            System.out.println("get lot: "+jadwalDetail.getDaftarJadwalLot());
            tableModel.remove(Integer.parseInt(lblIndex.getText()));
            tableModel.add(jadwalDetail);
            clear();
            
                    
               
            
        }
        
    }//GEN-LAST:event_btnUbahTableActionPerformed

    private void tableJadwalDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJadwalDetailMouseClicked
        // TODO add your handling code here:
        
        if(evt.getClickCount() == 1){
            
            jadwalDetail = new JadwalDetail();
            jadwalDetail = tableModel.get(tableJadwalDetail.convertRowIndexToModel(tableJadwalDetail.getSelectedRow()));
            int index = tableJadwalDetail.convertRowIndexToModel(tableJadwalDetail.getSelectedRow());
            
            lblIndex.setText(String.valueOf(index));
            lblId_detail.setText(String.valueOf(jadwalDetail.getId()));
            tglJadwal.setDate(jadwalDetail.getTglDetail());
            if(jadwalDetail.getShift() != null){
                comboShift.setSelectedItem(jadwalDetail.getShift());
            }else{
                comboShift.setSelectedItem("Pilih");
            }
            
            comboKet.setSelectedItem(jadwalDetail.getKeterangan());
            model.actionRemoveAll();
            model.removeSourceValues(jadwalDetail.getDaftarJadwalLot());
            model.addTargetValues(jadwalDetail.getDaftarJadwalLot());
            AreaPlot.setModel(model);
        }
        
    }//GEN-LAST:event_tableJadwalDetailMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.stripbandunk.jwidget.JDoubleList AreaPlot;
    private javax.swing.JButton btnBatal;
    private javax.swing.ButtonGroup btnGroupPL;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbahTable;
    private javax.swing.JComboBox comboKet;
    private javax.swing.JComboBox comboPengawas;
    private javax.swing.JComboBox comboPetugas;
    private javax.swing.JComboBox comboShift;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBln;
    private javax.swing.JLabel lblId_detail;
    private javax.swing.JLabel lblId_header;
    private javax.swing.JLabel lblIndex;
    private javax.swing.JLabel lblThn;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private com.imam.sp_checklist.widget.PanelImageBackground panelImageBackground1;
    private com.stripbandunk.jwidget.JDynamicTable tableJadwalDetail;
    private com.toedter.calendar.JDateChooser tglJadwal;
    // End of variables declaration//GEN-END:variables
}
