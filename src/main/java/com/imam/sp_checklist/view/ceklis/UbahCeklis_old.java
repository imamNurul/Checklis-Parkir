/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.ceklis;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.entity.master.Kendaraan;
import com.imam.sp_checklist.entity.master.Lot;
import com.imam.sp_checklist.entity.master.Shift;
import com.imam.sp_checklist.entity.master.Zona;
import com.imam.sp_checklist.entity.transaksi.Ceklis;
import com.imam.sp_checklist.entity.transaksi.CeklisDetail;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.service.BasementService;
import com.imam.sp_checklist.service.CeklisService;
import com.imam.sp_checklist.service.KaryawanService;
import com.imam.sp_checklist.service.LotService;
import com.imam.sp_checklist.service.ShiftService;
import com.imam.sp_checklist.service.ZonaService;
import com.imam.sp_checklist.view.karyawan.ViewPetugas;
import com.imam.sp_checklist.view.kendaraan.ViewKendaraan;
import com.imam.sp_checklist.widget.isValidTime;
import com.imam.sp_checklist.widget.render.CeklisDetailLotTableCellEditorCombo;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author Imam-pc
 */
public class UbahCeklis_old extends javax.swing.JDialog {

    private DynamicTableModel<CeklisDetail> tableModel;
    private Ceklis ceklis;
    private CeklisDetail ceklisDetail;
    private JComboBox<Lot> comboLot;
    private int bulan;
    private int tahun;
    private Locale locale = Locale.forLanguageTag("in-ID");
    private Calendar now;
    private JComboBox<String> comboDopDpnKnan;
    private JComboBox<String> comboDopDpnKiri;
    private JComboBox<String> comboDopBlkKnan;
    private JComboBox<String> comboDopBlkKiri;
    private JComboBox<String> comboSpionKnan;
    private JComboBox<String> comboSpionKri;
    private JComboBox<String> comboKondsBaret;
    private JComboBox<String> comboKondsPenyok;
    private JComboBox<String> comboKcaTutup;
    private JComboBox<String> combocekPlat;
    
    public UbahCeklis_old() {
        setModal(true);
        initComponents();
        
        tableModel = new DynamicTableModel<>(CeklisDetail.class);
        tableCeklisDetail.setDynamicModel(tableModel);
        
        now = Calendar.getInstance(locale);
        //now.setTime(new Date());
        
        dateTglCeklis.setLocale(locale);
        dateTglCeklis.setDateFormatString("EEEE, d MMMM yyyy");
        
        // set nama table combo
        
       // TableColumn area = tableCeklisDetail.getColumnModel().getColumn(2);
        TableColumn dopDpnKnan = tableCeklisDetail.getColumnModel().getColumn(3);
        TableColumn dopDpnKiri = tableCeklisDetail.getColumnModel().getColumn(4);
        TableColumn dopBlkKnan = tableCeklisDetail.getColumnModel().getColumn(5);
        TableColumn dopBlkKiri = tableCeklisDetail.getColumnModel().getColumn(6);
        TableColumn spionKnan = tableCeklisDetail.getColumnModel().getColumn(7);
        TableColumn spionKri = tableCeklisDetail.getColumnModel().getColumn(8);
        TableColumn kondsBaret = tableCeklisDetail.getColumnModel().getColumn(9);
        TableColumn kondsPenyok = tableCeklisDetail.getColumnModel().getColumn(10);
        TableColumn kcaTutup = tableCeklisDetail.getColumnModel().getColumn(11);
        TableColumn cekPlat = tableCeklisDetail.getColumnModel().getColumn(12);
        
       
        
        //set isi table combo
        comboDopDpnKnan = new JComboBox<>();
        comboDopDpnKnan.addItem("Baik");
        comboDopDpnKnan.addItem("Baret");
        comboDopDpnKnan.addItem("Penyok");
        
        comboDopDpnKiri = new JComboBox<>();
        comboDopDpnKiri.addItem("Baik");
        comboDopDpnKiri.addItem("Baret");
        comboDopDpnKiri.addItem("Penyok");
        
        comboDopBlkKnan = new JComboBox<>();
        comboDopBlkKnan.addItem("Baik");
        comboDopBlkKnan.addItem("Baret");
        comboDopBlkKnan.addItem("Penyok");
        
        comboDopBlkKiri = new JComboBox<>();
        comboDopBlkKiri.addItem("Baik");
        comboDopBlkKiri.addItem("Baret");
        comboDopBlkKiri.addItem("Penyok");
        
        comboSpionKnan = new JComboBox<>();
        comboSpionKnan.addItem("Baik");
        comboSpionKnan.addItem("Baret");
        comboSpionKnan.addItem("Penyok");
        
        comboSpionKri = new JComboBox<>();
        comboSpionKri.addItem("Baik");
        comboSpionKri.addItem("Baret");
        comboSpionKri.addItem("Penyok");
        
        comboKondsBaret = new JComboBox<>();
        comboKondsBaret.addItem("Ya");
        comboKondsBaret.addItem("Tidak");
        
        comboKondsPenyok = new JComboBox<>();
        comboKondsPenyok.addItem("Ya");
        comboKondsPenyok.addItem("Tidak");
        
        comboKcaTutup = new JComboBox<>();
        comboKcaTutup.addItem("Ya");
        comboKcaTutup.addItem("Tidak");
        
        combocekPlat = new JComboBox<>();
        combocekPlat.addItem("Ya");
        combocekPlat.addItem("Tidak");
        
        dopDpnKnan.setCellEditor(new DefaultCellEditor(comboDopDpnKnan));
        dopDpnKiri.setCellEditor(new DefaultCellEditor(comboDopDpnKiri));
        dopBlkKnan.setCellEditor(new DefaultCellEditor(comboDopBlkKnan));
        dopBlkKiri.setCellEditor(new DefaultCellEditor(comboDopBlkKiri));
        spionKnan.setCellEditor(new DefaultCellEditor(comboSpionKnan));
        spionKri.setCellEditor(new DefaultCellEditor(comboSpionKri));
        kondsBaret.setCellEditor(new DefaultCellEditor(comboKondsBaret));
        kondsPenyok.setCellEditor(new DefaultCellEditor(comboKondsPenyok));
        kcaTutup.setCellEditor(new DefaultCellEditor(comboKcaTutup));
        cekPlat.setCellEditor(new DefaultCellEditor(combocekPlat));
//        if(comboLot != null){
//            area.setCellEditor(new DefaultCellEditor(comboLot));
//        }
        
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
    }
    
    public Ceklis ubahCeklis(Ceklis param){
        
        ceklis = param;
        
        
        LoadBasementCombo();
        LoadShiftCombo();
        LoadCeklisDetail(ceklis.getId().intValue());
        
        lblId.setText(String.valueOf(ceklis.getId()));
     //   comboPengawas.addItem(ceklis.getPengawas());
       // comboPetugas.addItem(ceklis.getPetugas());
        comboSifth.setSelectedItem(ceklis.getShift());
        dateTglCeklis.setDate(ceklis.getTglCeklis());
      //  bulan = ceklis.getBulan();
        tahun = ceklis.getTahun();
        
        for(int i=0;i<tableModel.getRowCount();i++){
            ceklisDetail = new CeklisDetail();
                ceklisDetail = tableModel.get(i);
                    comboDopDpnKnan.setSelectedItem(ceklisDetail.getDopDpnKanan());
                        comboDopDpnKiri.setSelectedItem(ceklisDetail.getDopDpnKiri());
                        comboDopBlkKnan.setSelectedItem(ceklisDetail.getDopBlkKanan());
                        comboDopBlkKiri.setSelectedItem(ceklisDetail.getDopBlkKiri());
                        comboSpionKnan.setSelectedItem(ceklisDetail.getSpionKanan());
                        comboSpionKri.setSelectedItem(ceklisDetail.getSpionKiri());
                        comboKondsBaret.setSelectedItem(ceklisDetail.getKdsBaret());
                        comboKondsPenyok.setSelectedItem(ceklisDetail.getKdsPenyok());
                        comboKcaTutup.setSelectedItem(ceklisDetail.getKacaTutup());
                        combocekPlat.setSelectedItem(ceklisDetail.getCekPlat());
                        //comboLot.addItem(ceklisDetail.getAreaParkir());
                      
                      //  comboLot.setSelectedItem(ceklisDetail.getAreaParkir());
                        
        }
        
        
        setLocationRelativeTo(this);
        setVisible(true);
        
        return ceklis;
        
    }
    
    public void LoadCeklisDetail(int id){
        CeklisService jb = SpringManager.getInstance().getBean(CeklisService.class);
     
        List<CeklisDetail> list =  jb.findAllDetail(id);
        
        for(CeklisDetail bs : list){
           tableModel.add(bs);
//           
//           comboDopDpnKnan.setSelectedItem(bs.getDopDpnKanan());
//           comboDopDpnKiri.setSelectedItem(bs.getDopDpnKiri());
//           comboDopBlkKnan.setSelectedItem(bs.getDopBlkKanan());
//           comboDopBlkKiri.setSelectedItem(bs.getDopBlkKiri());
//           comboSpionKnan.setSelectedItem(bs.getSpionKanan());
//           comboSpionKri.setSelectedItem(bs.getSpionKiri());
//           comboKondsBaret.setSelectedItem(bs.getKdsBaret());
//           comboKondsPenyok.setSelectedItem(bs.getKdsPenyok());
//           comboKcaTutup.setSelectedItem(bs.getKacaTutup());
//           combocekPlat.setSelectedItem(bs.getCekPlat());
           
        }
        
        
    }
    
    public void LoadBasementCombo(){
        BasementService jb = SpringManager.getInstance().getBean(BasementService.class);
     
        List<Basement> list =  jb.findAll();
        
        for(Basement bs : list){
           comboBasement.addItem(bs);
        }
    }
    
    public void LoadZonaCombo(Basement bs){
        ZonaService jb = SpringManager.getInstance().getBean(ZonaService.class);
     
        List<Zona> list =  jb.findByidbs(bs);
        comboZona.removeAllItems();
        comboZona.addItem("Pilih");
        for(Zona zn : list){
           comboZona.addItem(zn);
        }
    }
    
    public void LoadLotCombo(Zona zona){
        
        if(zona != null){
            LotService jb = SpringManager.getInstance().getBean(LotService.class);
            comboLot = new JComboBox<>();
            List<Lot> list = jb.findByidZona(zona);
             System.out.println("list combo lot service: "+comboLot);
            for(Lot lot : list){
                comboLot.addItem(lot);
            }
            System.out.println("list combo lot: "+comboLot);
           // area.setCellEditor(new DefaultCellEditor(comboLot));
            tableCeklisDetail.setDefaultEditor(Lot.class, new CeklisDetailLotTableCellEditorCombo(list));
            
        }
        
    }
    
    public void LoadShiftCombo(){
        ShiftService jb = SpringManager.getInstance().getBean(ShiftService.class);
     
        List<Shift> list =  jb.findAll();
        
        for(Shift bs : list){
           comboSifth.addItem(bs);
        }
    }
    
    
    public void kosongSemua(){
        comboPengawas.removeAllItems();
        comboPetugas.removeAllItems();
        dateTglCeklis.setDate(new java.util.Date());
        comboSifth.setSelectedItem("Pilih");
        comboBasement.setSelectedItem("Pilih");
        comboZona.setSelectedItem("Pilih");
        comboNopol.removeAllItems();
        txtMerk.setText("");
        txtJenis.setText("");
        tableModel.clear();
    }
    
    public void kosongDetail(){
        comboBasement.setSelectedItem("Pilih");
        comboZona.setSelectedItem("Pilih");
        comboNopol.removeAllItems();
        txtMerk.setText("");
        txtJenis.setText("");
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
        lblId = new javax.swing.JLabel();
        lblIdx = new javax.swing.JLabel();
        lblIdDetail = new javax.swing.JLabel();
        panelImageBackground1 = new com.imam.sp_checklist.widget.PanelImageBackground();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtMerk = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        btnCariKendaraan = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnUbahKetable = new javax.swing.JButton();
        btnBatal1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comboBasement = new javax.swing.JComboBox();
        comboZona = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        SpinerJam = new javax.swing.JSpinner();
        comboNopol = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        dateTglCeklis = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        comboSifth = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCeklisDetail = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel1 = new javax.swing.JPanel();
        btnSimpanLanjut = new javax.swing.JButton();
        btnSimpanKeluar = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboPengawas = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        btnCariPengawas = new javax.swing.JButton();
        comboPetugas = new javax.swing.JComboBox();

        lblId.setText("jLabel1");

        lblIdx.setText("jLabel1");

        lblIdDetail.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panelImageBackground1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ubah Checklist Kendaraan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Form Input Kendaraan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel18.setText("Nopol Mobil");

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel19.setText("Merk Mobil");

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel20.setText("Jenis");

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel21.setText(":");

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel22.setText(":");

        txtMerk.setEditable(false);
        txtMerk.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel23.setText(":");

        txtJenis.setEditable(false);
        txtJenis.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        btnCariKendaraan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCariKendaraan.setText("Cari");
        btnCariKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariKendaraanActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel17.setText(":");

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText("Basement");

        btnUbahKetable.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnUbahKetable.setText("Ubah ke tabel");
        btnUbahKetable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahKetableActionPerformed(evt);
            }
        });

        btnBatal1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBatal1.setText("Hapus Tabel");
        btnBatal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatal1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel15.setText("Zona");

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel24.setText(":");

        comboBasement.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboBasement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        comboBasement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBasementActionPerformed(evt);
            }
        });

        comboZona.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboZona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        comboZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboZonaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel16.setText("Jam");

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel25.setText(":");

        SpinerJam.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        SpinerJam.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        SpinerJam.setEditor(new javax.swing.JSpinner.DateEditor(SpinerJam, "HH:mm:ss"));

        comboNopol.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboNopol.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText("Hari/Tgl");

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel27.setText(":");

        dateTglCeklis.setDate(new java.util.Date());
        dateTglCeklis.setDateFormatString("EEEE, d MMMM yyyy");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText("Shift");

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel28.setText(":");

        comboSifth.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSifth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        comboSifth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSifthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboNopol, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCariKendaraan))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMerk))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtJenis))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnUbahKetable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSifth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBasement, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpinerJam, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateTglCeklis, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21)
                    .addComponent(btnCariKendaraan)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(comboBasement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22)
                    .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel24)
                    .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel25)
                    .addComponent(SpinerJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel27))
                    .addComponent(dateTglCeklis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUbahKetable)
                        .addComponent(btnBatal1))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel28)
                        .addComponent(comboSifth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tabel Checklist", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);

        tableCeklisDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCeklisDetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCeklisDetail);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setOpaque(false);

        btnSimpanLanjut.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSimpanLanjut.setText("Simpan Lanjut");
        btnSimpanLanjut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanLanjutActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpanLanjut);

        btnSimpanKeluar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSimpanKeluar.setText("Simpan Keluar");
        btnSimpanKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpanKeluar);

        btnBatal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel1.add(btnBatal);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pengawas & Petugas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText("Pengawas :");

        comboPengawas.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboPengawas.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel26.setText("Petugas :");

        btnCariPengawas.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCariPengawas.setText("Cari");
        btnCariPengawas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPengawasActionPerformed(evt);
            }
        });

        comboPetugas.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboPetugas.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboPengawas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboPetugas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCariPengawas))
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 140, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnCariPengawas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPengawas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelImageBackground1Layout = new javax.swing.GroupLayout(panelImageBackground1);
        panelImageBackground1.setLayout(panelImageBackground1Layout);
        panelImageBackground1Layout.setHorizontalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelImageBackground1Layout.setVerticalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelImageBackground1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBatal1ActionPerformed

    private void btnUbahKetableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahKetableActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dtf = new SimpleDateFormat("HH:mm", locale);
        String dtfs = dtf.format(SpinerJam.getValue());
        
        String timev = dtfs;
        isValidTime vt = new isValidTime();
        boolean vdt = vt.isValidTimeVal(timev);
        
        System.out.println("jammmmmmm: "+timev);
        System.out.println("jam valid: "+vdt);
        
        
        
        if(comboNopol.getSelectedItem()==null){
            messageComponent1.showWarning("Kendaraan belum dipilih");
        }else if(comboBasement.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Basement belum dipilih");
        }else if(comboZona.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Zona belum dipilih");
        }else if(comboSifth.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Shift belum dipilih");
        }else if(!vdt){
            messageComponent1.showWarning("Jam tidak valid");
        }else{
            
            
                Shift sh = (Shift) comboSifth.getSelectedItem();
                ShiftService ss = SpringManager.getInstance().getBean(ShiftService.class);
                Shift shift = ss.findJamShift(sh.getId());
                
                Time jmAwal = shift.getJamMulai();
                Time jmAkhir = shift.getJamSelesai();
                
                Calendar cjmMulai = Calendar.getInstance(locale);
                Calendar cjmSelesai = Calendar.getInstance(locale);
               // Calendar cjmCeklis = Calendar.getInstance(locale);
                cjmMulai.setTime(jmAwal);
                cjmSelesai.setTime(jmAkhir);
                Time tmCeklis = new java.sql.Time(SpinerJam.getValue().hashCode());
                try {
                    SimpleDateFormat parser = new SimpleDateFormat("HH:mm");

                    Date timeMulai = parser.parse(jmAwal.toString());
                    Date timeSelesai = parser.parse(jmAkhir.toString());
                    Date timeCeklis = parser.parse(tmCeklis.toString());
                    
                
                
                System.out.println("jm mulai tambahhh: "+timeMulai);
                System.out.println("jam selesai tambahhh: "+timeSelesai);
                System.out.println("jam ceklis tambahhh: "+timeCeklis);
                
                
                if(timeCeklis.after(timeMulai) && timeCeklis.before(timeSelesai)){
                    ceklisDetail = new CeklisDetail();
                    ceklisDetail.setJam(new java.sql.Time(SpinerJam.getValue().hashCode()));
                    ceklisDetail.setKendaraan((Kendaraan) comboNopol.getSelectedItem());
                    for(int i=0;i<tableModel.getRowCount();i++){
                        CeklisDetail item = tableModel.get(i);
                        if(item.getKendaraan().getId().equals(ceklisDetail.getKendaraan().getId())){
                            tableModel.remove(i);
                            break;
                        }
                        
                    }
                    
                    tableModel.add(ceklisDetail);
                    kosongDetail();
                }else{
                    
                    messageComponent1.showWarning("Jam tidak sesuai dengan jam shift "+shift.getNama());
                    
                }
            
            } catch (ParseException ex) {
                    Logger.getLogger(UbahCeklis_old.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }//GEN-LAST:event_btnUbahKetableActionPerformed

    private void btnCariKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariKendaraanActionPerformed
        // TODO add your handling code here:
        
        ViewKendaraan vk = new ViewKendaraan();
        Kendaraan kendaraan = vk.CariKendaraan();
        
        if(kendaraan != null){
            comboNopol.addItem(kendaraan);
            txtMerk.setText(kendaraan.getMerk());
            txtJenis.setText(kendaraan.getJenis());
        }else{
            comboNopol.removeAllItems();
            txtMerk.setText("");
            txtJenis.setText("");
        }
        
    }//GEN-LAST:event_btnCariKendaraanActionPerformed

    private void btnSimpanLanjutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanLanjutActionPerformed
        // TODO add your handling code here:
        
        Kendaraan kd = null;
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            CeklisDetail item = tableModel.get(i);
            kd = item.getKendaraan();
            
        }
        
        if(kd == null){
            messageComponent1.showWarning("Tabel masoh kosong");
        }else if(comboPetugas.getSelectedIndex() == -1){
            messageComponent1.showWarning("Pengawas belum dipih");
        }else if(comboPengawas.getSelectedIndex() == -1){
            messageComponent1.showWarning("Petugas belum dipih");
        }else if(dateTglCeklis.getDate() == null){
            messageComponent1.showWarning("Tanggal ceklis kosong");
        }else if(comboSifth.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Shift belum dipih");
        }else{
            
            ceklis = new Ceklis();
          //  ceklis.setBulan(bulan);
            
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                    ceklisDetail = tableModel.get(i);

                    ceklis.tambahDaftarCeklis(ceklisDetail);
                }
            
           // ceklis.setPengawas((Karyawan) comboPetugas.getSelectedItem());
          //  ceklis.setPetugas((Karyawan) comboPengawas.getSelectedItem());
            ceklis.setShift((Shift) comboSifth.getSelectedItem());
            ceklis.setTahun(tahun);
            ceklis.setTglCeklis(new java.sql.Timestamp(dateTglCeklis.getDate().getTime()));
            ceklis.setWaktuTransaksiDiubah(new java.sql.Timestamp(new java.util.Date().getTime()));
            
            CeklisService service = SpringManager.getInstance().getBean(CeklisService.class);
            service.save(ceklis);
            
            kosongSemua();

        }

    }//GEN-LAST:event_btnSimpanLanjutActionPerformed

    private void btnSimpanKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanKeluarActionPerformed
        // TODO add your handling code here:
        
        Kendaraan kd = null;
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            CeklisDetail item = tableModel.get(i);
            kd = item.getKendaraan();
            
        }
        
        if(kd == null){
            messageComponent1.showWarning("Tabel masoh kosong");
        }else if(comboPetugas.getSelectedIndex() == -1){
            messageComponent1.showWarning("Pengawas belum dipih");
        }else if(comboPengawas.getSelectedIndex() == -1){
            messageComponent1.showWarning("Petugas belum dipih");
        }else if(dateTglCeklis.getDate() == null){
            messageComponent1.showWarning("Tanggal ceklis kosong");
        }else if(comboSifth.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Shift belum dipih");
        }else{
            
            ceklis = new Ceklis();
           // ceklis.setBulan(bulan);
            
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                    ceklisDetail = tableModel.get(i);

                    ceklis.tambahDaftarCeklis(ceklisDetail);
                }
            
          // ceklis.setPengawas((Karyawan) comboPetugas.getSelectedItem());
           // ceklis.setPetugas((Karyawan) comboPengawas.getSelectedItem());
            ceklis.setShift((Shift) comboSifth.getSelectedItem());
            ceklis.setTahun(tahun);
            ceklis.setTglCeklis(new java.sql.Timestamp(dateTglCeklis.getDate().getTime()));
            ceklis.setWaktuTransaksiDiubah(new java.sql.Timestamp(new java.util.Date().getTime()));
            
            CeklisService service = SpringManager.getInstance().getBean(CeklisService.class);
            service.save(ceklis);
            
            kosongSemua();
            dispose();

        }
        
    }//GEN-LAST:event_btnSimpanKeluarActionPerformed

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

    private void btnCariPengawasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPengawasActionPerformed
        // TODO add your handling code here:
        
        if(dateTglCeklis.getDate() == null){
            messageComponent1.showWarning("Hari / Tanggal belum dipilih");
        }else{
            
            ViewPetugas vp = new ViewPetugas();
            vp.setTitle("Cari Pengawas");
            Karyawan pengawas = vp.CariKaryawanPengawas();

            if(pengawas != null){

                KaryawanService service = SpringManager.getInstance().getBean(KaryawanService.class);
                List<Karyawan> list = service.findPetugasByPengawas(pengawas.getId());

                for(Karyawan kr: list){
                    comboPetugas.addItem(kr);
                }

                comboPengawas.addItem(pengawas);
            }else{
                comboPengawas.removeAllItems();

            }

            }
        
        
    }//GEN-LAST:event_btnCariPengawasActionPerformed

    private void comboBasementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBasementActionPerformed
        // TODO add your handling code here:
        
        if(comboBasement.getSelectedIndex() == -1){
            
        }else if(comboBasement.getSelectedItem().equals("Pilih")){
            LoadZonaCombo(null);
        }else{
            LoadZonaCombo((Basement) comboBasement.getSelectedItem());
        }
        
        
    }//GEN-LAST:event_comboBasementActionPerformed

    private void comboZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboZonaActionPerformed
        // TODO add your handling code here:
        
        if(comboZona.getSelectedIndex() == -1){
          
        }else if(comboZona.getSelectedItem().equals("Pilih")){
            //LoadLotCombo(null);
        }else{
            LoadLotCombo((Zona) comboZona.getSelectedItem());
            
        }
        
    }//GEN-LAST:event_comboZonaActionPerformed

    private void comboSifthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSifthActionPerformed
        // TODO add your handling code here:
        
        if(comboSifth.getSelectedItem().equals("Pilih")){
            SpinerJam.setValue(new java.sql.Time(new java.util.Date().getTime()));
        }else{
            Shift sh = (Shift) comboSifth.getSelectedItem();
            ShiftService ss = SpringManager.getInstance().getBean(ShiftService.class);
            Shift shift = ss.findJamShift(sh.getId());
            
            System.out.println("shift name: "+shift.getNama());
            System.out.println("shift jamMulai: "+shift.getJamMulai());
            System.out.println("shift jamSelesai: "+shift.getJamSelesai());
            
            SpinerJam.setValue(shift.getJamMulai());
        }
        
    }//GEN-LAST:event_comboSifthActionPerformed

    private void tableCeklisDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCeklisDetailMouseClicked
        // TODO add your handling code here:
        
        if(evt.getClickCount() == 1){
            
            ceklisDetail = new CeklisDetail();
            ceklisDetail = tableModel.get(tableCeklisDetail.convertRowIndexToModel(tableCeklisDetail.getSelectedRow()));
            int index = tableCeklisDetail.convertRowIndexToModel(tableCeklisDetail.getSelectedRow());
            
            lblIdx.setText(String.valueOf(index));
            lblIdDetail.setText(String.valueOf(ceklisDetail.getId()));
            SpinerJam.setValue(ceklisDetail.getJam());
            comboNopol.addItem(ceklisDetail.getKendaraan());
            txtMerk.setText(ceklisDetail.getKendaraan().getMerk());
            txtJenis.setText(ceklisDetail.getKendaraan().getJenis());
            comboBasement.setSelectedItem(ceklisDetail.getAreaParkir().getZona().getBasement());
            comboZona.setSelectedItem(ceklisDetail.getAreaParkir().getZona());
            
        }
        
    }//GEN-LAST:event_tableCeklisDetailMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinerJam;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBatal1;
    private javax.swing.JButton btnCariKendaraan;
    private javax.swing.JButton btnCariPengawas;
    private javax.swing.ButtonGroup btnGroupPL;
    private javax.swing.JButton btnSimpanKeluar;
    private javax.swing.JButton btnSimpanLanjut;
    private javax.swing.JButton btnUbahKetable;
    private javax.swing.JComboBox comboBasement;
    private javax.swing.JComboBox comboNopol;
    private javax.swing.JComboBox comboPengawas;
    private javax.swing.JComboBox comboPetugas;
    private javax.swing.JComboBox comboSifth;
    private javax.swing.JComboBox comboZona;
    private com.toedter.calendar.JDateChooser dateTglCeklis;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdDetail;
    private javax.swing.JLabel lblIdx;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private com.imam.sp_checklist.widget.PanelImageBackground panelImageBackground1;
    private com.stripbandunk.jwidget.JDynamicTable tableCeklisDetail;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtMerk;
    // End of variables declaration//GEN-END:variables
}
