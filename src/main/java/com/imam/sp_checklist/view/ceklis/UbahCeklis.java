/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.ceklis;

import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.entity.master.Kendaraan;
import com.imam.sp_checklist.entity.master.Lot;
import com.imam.sp_checklist.entity.master.Shift;
import com.imam.sp_checklist.entity.transaksi.Ceklis;
import com.imam.sp_checklist.entity.transaksi.CeklisDetail;
import com.imam.sp_checklist.entity.transaksi.Jadwal;
import com.imam.sp_checklist.entity.transaksi.JadwalDetail;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.manager.LoginManager;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.service.CeklisService;
import com.imam.sp_checklist.service.JadwalService;
import com.imam.sp_checklist.service.ShiftService;
import com.imam.sp_checklist.view.karyawan.ViewPetugas;
import com.imam.sp_checklist.view.kendaraan.ViewKendaraan;
import com.imam.sp_checklist.widget.isValidTime;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Imam-pc
 */
public class UbahCeklis extends javax.swing.JDialog {

    private final DynamicTableModel<CeklisDetail> tableModel;
    private Ceklis ceklis;
    private CeklisDetail ceklisDetail;
    private String bulan;
    private int tahun;
    private Locale locale = Locale.forLanguageTag("in-ID");
    private final Calendar now;
    private Jadwal jadwal;
    private List<JadwalDetail> listJadwalDetail;
    private JadwalDetail jadwalDetail;
    private String monthHeader;
    private final JComboBox<String> comboDopDpnKnan;
    private final JComboBox<String> comboDopDpnKiri;
    private final JComboBox<String> comboDopBlkKnan;
    private final JComboBox<String> comboDopBlkKiri;
    private final JComboBox<String> comboSpionKnan;
    private final JComboBox<String> comboSpionKri;
    private final JComboBox<String> comboKondsBaret;
    private final JComboBox<String> comboKondsPenyok;
    private final JComboBox<String> comboKcaTutup;
    private final JComboBox<String> combocekPlat;
    
    
    public UbahCeklis() {
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
        comboSpionKnan.addItem("Nihil");
        comboSpionKnan.addItem("Retak");
        comboSpionKnan.addItem("Pecah");
        
        comboSpionKri = new JComboBox<>();
        comboSpionKri.addItem("Nihil");
        comboSpionKri.addItem("Retak");
        comboSpionKri.addItem("Pecah");
        
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
        
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
    }
    
    public Ceklis ubahCeklis(Ceklis param, String bln, int thn){
        
        ceklis = param;
        
        bulan = bln;
        tahun = thn;
        
//        int month = ceklis.getBulan();
//        DateFormatSymbols dfs = new DateFormatSymbols(locale);
//        String namaBln = dfs.getMonths()[month-1];
        
        lblBulan.setText(ceklis.getBulan());
        lblTahun.setText(String.valueOf(ceklis.getTahun()));
        dateTglCeklis.setDate(ceklis.getTglCeklis());
        comboSifth.addItem(ceklis.getShift());
        comboPengawas.addItem(ceklis.getPengawas());
        comboPetugas.addItem(ceklis.getPetugas());
        lblIdCeklis.setText(String.valueOf(ceklis.getId()));
        lblJdwal.setText(String.valueOf(ceklis.getJadwal().getId().longValue()));
        System.out.println("get lbl jadwalId: "+ Long.parseLong(lblJdwal.getText()));
        LoadJadwalCeklis(Long.parseLong(lblJdwal.getText()));
        lblBuatBy.setText(ceklis.getBuatBy());
        lblTglBuat.setText(String.valueOf(ceklis.getTglBuat()));
        
        
        Karyawan pengawas = (Karyawan) comboPengawas.getSelectedItem();
            Karyawan petugas = (Karyawan) comboPetugas.getSelectedItem();
            
             System.out.println("jadwal get petugas: "+petugas.getId());
             System.out.println("jadwal get pengawas: "+pengawas.getId());
             System.out.println("jadwal get bln: "+lblBulan.getText());
             //System.out.println("jadwal get tahun: "+Integer.parseInt(lblTahun.getText()));
            
          
        
        LoadCeklisDetail(Integer.parseInt(lblIdCeklis.getText()));
        
        
        setLocationRelativeTo(this);
        setVisible(true);
        
        return ceklis;
        
    }
    
    public void LoadCeklisDetail(int id){
        CeklisService service = SpringManager.getInstance().getBean(CeklisService.class);
        List<CeklisDetail> list = service.findAllDetail(id);
        tableModel.clear();
        list.forEach((cd) -> {
            tableModel.add(cd);
        });
        
    }
    
    public Jadwal LoadJadwalCeklis(long id){
        JadwalService service = SpringManager.getInstance().getBean(JadwalService.class);
        jadwal = new Jadwal();
        jadwal = service.findById(id);
        System.out.println("jadwal service get jadwal: "+jadwal);
        
        System.out.println("dari tgl get idjadwal: "+jadwal.getId().intValue());
             
             if(dateTglCeklis.getDate() != null){
                 
                 System.out.println("get tanggal dr tgl: "+new java.sql.Date(dateTglCeklis.getDate().getTime()));
                 
                // JadwalService service = SpringManager.getInstance().getBean(JadwalService.class);
                 List<JadwalDetail> lts = service.findDetailByDate(new java.sql.Date(dateTglCeklis.getDate().getTime()), jadwal.getId().intValue());
                 System.out.println("get jadwalDetail by Date: "+lts);
                 
                if(lts != null){
                    
                    lts.stream().map((j) -> {
                        List<JadwalDetail> jdl = new ArrayList<>();
                        jdl.add(j);
                        labelKet.setText(j.getKeterangan());
                        if(j.getShift() != null){
                            comboSifth.removeAllItems();
                            comboSifth.addItem(j.getShift());
                            SpinerJam.setValue(j.getShift().getJamMulai());
                        }else{
                            SpinerJam.setValue(new java.sql.Time(00,00,00));
                            comboSifth.removeAllItems();
                        }System.out.println("get jadwaldetail dr tgl: "+jdl);
                        System.out.println("get Lot dr tgl: "+j.getDaftarJadwalLot());
                         return j;
                     }).map((j) -> j.getDaftarJadwalLot()).forEachOrdered((listLot) -> {
                         if(listLot != null){
                             comboAreaPlot.removeAllItems();
                             listLot.forEach((lt) -> {
                                 comboAreaPlot.addItem(lt);
                             });
                             
                         }else{
                             comboAreaPlot.removeAllItems();
                         }
                     }); 
                }
                 
             }
        
        
        return jadwal;
        
    }
    
    
    
    public void kosongSemua(){
        comboPengawas.removeAllItems();
        comboPetugas.removeAllItems();
        dateTglCeklis.setDate(new java.util.Date());
        comboSifth.removeAllItems();
        comboAreaPlot.removeAllItems();
        comboNopol.removeAllItems();
        txtMerk.setText("");
        txtJenis.setText("");
        tableModel.clear();
        SpinerJam.setValue(new java.sql.Time(00, 00, 00));
        labelKet.setText("");
        lblBulan.setText("");
        lblTahun.setText("");
    }
    
    public void kosongDetail(){
        comboNopol.removeAllItems();
        txtMerk.setText("");
        txtJenis.setText("");
        SpinerJam.setValue(new java.sql.Time(00,00,00));
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
        lblIdCeklis = new javax.swing.JLabel();
        lblIndex = new javax.swing.JLabel();
        lblIdDetailCeklis = new javax.swing.JLabel();
        lblJdwal = new javax.swing.JLabel();
        lblBuatBy = new javax.swing.JLabel();
        lblTglBuat = new javax.swing.JLabel();
        lblKetDetail = new javax.swing.JLabel();
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
        btnUbahDetail = new javax.swing.JButton();
        comboNopol = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        comboSifth = new javax.swing.JComboBox();
        SpinerJam = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comboAreaPlot = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        labelKet = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        dateTglCeklis = new com.toedter.calendar.JDateChooser();
        lblBulan = new javax.swing.JLabel();
        lblTahun = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCeklisDetail = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel1 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnHapusTable = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboPengawas = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        btnCariPengawas = new javax.swing.JButton();
        comboPetugas = new javax.swing.JComboBox();

        lblIdCeklis.setText("jLabel1");

        lblIndex.setText("jLabel1");

        lblIdDetailCeklis.setText("jLabel1");

        lblJdwal.setText("jLabel1");

        lblBuatBy.setText("jLabel2");

        lblTglBuat.setText("jLabel3");

        lblKetDetail.setText("jLabel1");

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

        btnUbahDetail.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnUbahDetail.setText("Ubah ke tabel");
        btnUbahDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahDetailActionPerformed(evt);
            }
        });

        comboNopol.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboNopol.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText("Hari/Tgl");

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel27.setText(":");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText("Shift");

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel28.setText(":");

        comboSifth.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSifth.setEnabled(false);
        comboSifth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSifthActionPerformed(evt);
            }
        });

        SpinerJam.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        SpinerJam.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        SpinerJam.setEditor(new javax.swing.JSpinner.DateEditor(SpinerJam, "HH:mm:ss"));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel16.setText("Jam");

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel25.setText(":");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel15.setText("Area Plot");

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel24.setText(":");

        comboAreaPlot.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel29.setText("Keterangan");

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel30.setText(":");

        labelKet.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        labelKet.setText("Keterangan");

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText("Bln / Thn");

        jLabel31.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel31.setText(":");

        dateTglCeklis.setDateFormatString("EEEE, d MMMM yyyy");
        dateTglCeklis.setEnabled(false);
        dateTglCeklis.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        dateTglCeklis.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTglCeklisPropertyChange(evt);
            }
        });

        lblBulan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblBulan.setText("Bulan");
        lblBulan.setToolTipText("");
        lblBulan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTahun.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblTahun.setText("Tahun");
        lblTahun.setToolTipText("");
        lblTahun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAreaPlot, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnUbahDetail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboNopol, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCariKendaraan))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMerk))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtJenis))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelKet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel30)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SpinerJam, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboSifth, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateTglCeklis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTahun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel21)
                        .addComponent(btnCariKendaraan)
                        .addComponent(comboNopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel31)
                        .addComponent(lblBulan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel22)
                        .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel27))
                    .addComponent(dateTglCeklis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel23)
                            .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel28)
                            .addComponent(comboSifth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel24)
                            .addComponent(comboAreaPlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel30)
                            .addComponent(SpinerJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(btnUbahDetail)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel25)
                            .addComponent(labelKet))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tabel Detail Checklist", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setOpaque(false);

        btnSimpan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan);

        btnHapusTable.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnHapusTable.setText("Hapus Detail");
        btnHapusTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusTableActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapusTable);

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
        btnCariPengawas.setText("Cari Pengawas");
        btnCariPengawas.setEnabled(false);
        btnCariPengawas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPengawasActionPerformed(evt);
            }
        });

        comboPetugas.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboPetugas.setEnabled(false);
        comboPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPetugasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(comboPetugas, 0, 285, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariPengawas))
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPengawas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImageBackground1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnHapusTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusTableActionPerformed
        // TODO add your handling code here:
        
        if (tableCeklisDetail.getSelectedRow() == -1) {
            messageComponent1.showWarning("Pilih salah satu");
        } else {
            
            ceklisDetail = tableModel.get(tableCeklisDetail.convertRowIndexToModel(tableCeklisDetail.getSelectedRow()));
            
            int closing;
            closing = JOptionPane.showConfirmDialog(this,
                "Apakah anda yakin, hapus detail checklist Nopol: "+ceklisDetail.getKendaraan().getId()+"...?", "Konfirmasi Hapus Detail Checklist",JOptionPane.YES_NO_OPTION);
            if (closing==0){
                
                comboNopol.removeAllItems();
                txtJenis.setText("");
                txtMerk.setText("");
                
                int index = tableCeklisDetail.convertRowIndexToModel(tableCeklisDetail.getSelectedRow());
                CeklisDetail cd = tableModel.get(index);
                System.out.println("delete index: "+index);
                System.out.println("delete id nopol: "+cd.getKendaraan().getId());
                CeklisService sv = SpringManager.getInstance().getBean(CeklisService.class);
                sv.deleteDetail(cd);
                dateTglCeklis.setDate(ceklis.getTglCeklis());
                LoadCeklisDetail(ceklis.getId().intValue());
                
            }else{
                this.show();
            }
            
            
            
        }
        
    }//GEN-LAST:event_btnHapusTableActionPerformed

    private void btnUbahDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahDetailActionPerformed
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
        }else if(dateTglCeklis.getDate() == null){
            messageComponent1.showWarning("Hari / Tanggal belum dipilih");
        }else if(comboPengawas.getSelectedIndex() == -1){
            messageComponent1.showWarning("Pengawas belum dipilih");
        }else if(comboPetugas.getSelectedIndex() == -1){
            messageComponent1.showWarning("Petugas belum dipilih");
        }else if(comboAreaPlot.getSelectedIndex() == -1){
            messageComponent1.showWarning("Area Plot belum dipilih");
        }else if(comboSifth.getSelectedIndex() == -1){
            messageComponent1.showWarning("Shift Kosong");
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
                        ceklisDetail.setAreaParkir((Lot) comboAreaPlot.getSelectedItem());
                        ceklisDetail.setKendaraan((Kendaraan) comboNopol.getSelectedItem());
                        ceklisDetail.setDopDpnKanan(comboDopDpnKnan.getSelectedItem().toString());
                        ceklisDetail.setDopDpnKiri(comboDopDpnKiri.getSelectedItem().toString());
                        ceklisDetail.setDopBlkKanan(comboDopBlkKnan.getSelectedItem().toString());
                        ceklisDetail.setDopBlkKiri(comboDopBlkKiri.getSelectedItem().toString());
                        ceklisDetail.setSpionKanan(comboSpionKnan.getSelectedItem().toString());
                        ceklisDetail.setSpionKiri(comboSpionKri.getSelectedItem().toString());
                        ceklisDetail.setKdsBaret(comboKondsBaret.getSelectedItem().toString());
                        ceklisDetail.setKdsPenyok(comboKondsPenyok.getSelectedItem().toString());
                        ceklisDetail.setKacaTutup(comboKcaTutup.getSelectedItem().toString());
                        ceklisDetail.setCekPlat(combocekPlat.getSelectedItem().toString());
                        ceklisDetail.setKet(lblKetDetail.getText());
                        
                        for(int i=0;i<tableModel.getRowCount();i++){
                            CeklisDetail item = tableModel.get(i);
                            if(item.getKendaraan().getId().equals(ceklisDetail.getKendaraan().getId())){
                                tableModel.remove(i);
                                break;
                            }

                        }
                      
                        
                        
                        
                        
                        
                       // tableModel.remove(Integer.parseInt(lblIndex.getText()));
                        tableModel.add(ceklisDetail);
                        kosongDetail();
                    }else{

                        messageComponent1.showWarning("Jam tidak sesuai dengan jam shift "+shift.getNama());

                    }
            
                } catch (ParseException ex) {
                        Logger.getLogger(UbahCeklis.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            }
        
    }//GEN-LAST:event_btnUbahDetailActionPerformed

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

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Pengguna pgn = LoginManager.getInstance().getPengguna();
       // Kendaraan kd = null;
        
       
        
//        for (int i = 0; i < tableModel.getRowCount(); i++) {
//            CeklisDetail item = tableModel.get(i);
//            kd = item.getKendaraan();
//            
//        }
//        
        if(tableModel.isEmpty()){
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
            
            DateTimeFormatter dtf = DateTimeFormat.forPattern("MMMM");
                DateTime ins = dtf.withLocale(locale).parseDateTime(lblBulan.getText());
                int montInt = ins.getMonthOfYear();
                System.out.println("bulan integer: "+ montInt);
            
            ceklis = new Ceklis();
            ceklisDetail = new CeklisDetail();
            ceklis.setBulan(lblBulan.getText());
            
            
            ceklis.setPengawas((Karyawan) comboPengawas.getSelectedItem());
            ceklis.setPetugas((Karyawan) comboPetugas.getSelectedItem());
            ceklis.setShift((Shift) comboSifth.getSelectedItem());
            ceklis.setTahun(tahun);
            ceklis.setTglCeklis(new java.sql.Timestamp(dateTglCeklis.getDate().getTime()));
            ceklis.setUbahBy(pgn.getKaryawan().getNama());
            ceklis.setWaktuTransaksiDiubah(new java.sql.Timestamp(new java.util.Date().getTime()));
            ceklis.setBuatBy(lblBuatBy.getText());
            ceklis.setTglBuat(Timestamp.valueOf(lblTglBuat.getText()));
            ceklis.setId(Long.parseLong(lblIdCeklis.getText()));
            ceklis.setJadwal(jadwal);
            
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                
                    ceklisDetail = tableModel.get(i);

                    ceklis.tambahDaftarCeklis(ceklisDetail);
                }
            
            
            CeklisService service = SpringManager.getInstance().getBean(CeklisService.class);
            service.update(ceklis);
            dispose();
            System.out.println("simpan ceklis detail NOPOL "+ ceklisDetail.getKendaraan().getId());
            System.out.println("simpan ceklis detail"+ ceklis.getDaftarCeklis());
            
            

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

    private void btnCariPengawasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPengawasActionPerformed
        // TODO add your handling code here:
        
            ViewPetugas vp = new ViewPetugas();
            vp.setTitle("Cari Pengawas");
            Karyawan pengawas = vp.CariKaryawanPengawas();
            Karyawan petugas = vp.LoadPetugas();
            Jadwal jdwl = vp.LoadJadwalByPengawasByPetugasByBlnByThn();

            if(pengawas != null){
                comboPengawas.removeAllItems();
                comboPetugas.removeAllItems();
                comboPengawas.addItem(pengawas);
                comboPetugas.addItem(petugas);
                jadwal = jdwl;
                lblBulan.setText(jadwal.getBulan());
                lblTahun.setText(String.valueOf(jadwal.getTahun()));
                DateTimeFormatter dtf = DateTimeFormat.forPattern("MMMM");
                DateTime ins = dtf.withLocale(locale).parseDateTime(lblBulan.getText());
                int montInt = ins.getMonthOfYear();
                System.out.println("bulan integer: "+ montInt);
                
                Date dt = new GregorianCalendar(Integer.parseInt(lblTahun.getText()), montInt -1, 1).getTime();
                
                System.out.println("tangga dari cri: "+ dt);
                dateTglCeklis.setDate(dt);
                

            }else{
                comboPengawas.removeAllItems();
                comboPetugas.removeAllItems();
                jadwal = null;
            }
        
        
        
    }//GEN-LAST:event_btnCariPengawasActionPerformed

    private void comboSifthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSifthActionPerformed
        // TODO add your handling code here:
        
        if(comboSifth.getSelectedIndex() == -1){
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

    private void comboPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPetugasActionPerformed

    private void dateTglCeklisPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTglCeklisPropertyChange
        // TODO add your handling code here:
        
//        System.out.println("ceklis ditanggal get jadwal: "+ceklis.getJadwal().getId().intValue());
          System.out.println("jadwal ditanggal get jadwal: "+jadwal);
//          System.out.println("Tanggal ditanggal get jadwal: "+new java.sql.Date(dateTglCeklis.getDate().getTime()));
        
        if(jadwal != null){
            
             System.out.println("dari tgl get idjadwal: "+jadwal.getId().intValue());
             
             if(dateTglCeklis.getDate() != null){
                 
                 System.out.println("get tanggal dr tgl: "+new java.sql.Date(dateTglCeklis.getDate().getTime()));
                 
                 JadwalService service = SpringManager.getInstance().getBean(JadwalService.class);
                 List<JadwalDetail> lts = service.findDetailByDate(new java.sql.Date(dateTglCeklis.getDate().getTime()), jadwal.getId().intValue());
                 System.out.println("get jadwalDetail by Date: "+lts);
                 
                if(lts != null){
                    
                    lts.stream().map((j) -> {
                        List<JadwalDetail> jdl = new ArrayList<>();
                        jdl.add(j);
                        labelKet.setText(j.getKeterangan());
                        if(j.getShift() != null){
                            comboSifth.removeAllItems();
                            comboSifth.addItem(j.getShift());
                            SpinerJam.setValue(j.getShift().getJamMulai());
                        }else{
                            SpinerJam.setValue(new java.sql.Time(00,00,00));
                            comboSifth.removeAllItems();
                        }System.out.println("get jadwaldetail dr tgl: "+jdl);
                        System.out.println("get Lot dr tgl: "+j.getDaftarJadwalLot());
                         return j;
                     }).map((j) -> j.getDaftarJadwalLot()).forEachOrdered((listLot) -> {
                         if(listLot != null){
                             comboAreaPlot.removeAllItems();
                             listLot.forEach((lt) -> {
                                 comboAreaPlot.addItem(lt);
                             });
                             
                         }else{
                             comboAreaPlot.removeAllItems();
                         }
                     }); 
                }
                 
             }
            
            
            
            
        }
        
    }//GEN-LAST:event_dateTglCeklisPropertyChange

    private void tableCeklisDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCeklisDetailMouseClicked
        // TODO add your handling code here:
        
        if(evt.getClickCount() == 2){
            
            ceklisDetail = new CeklisDetail();
            ceklisDetail = tableModel.get(tableCeklisDetail.convertRowIndexToModel(tableCeklisDetail.getSelectedRow()));
            int index = tableCeklisDetail.convertRowIndexToModel(tableCeklisDetail.getSelectedRow());
            System.out.println("get klik indext: "+index);
            lblIndex.setText(String.valueOf(index));
            lblIdDetailCeklis.setText(String.valueOf(ceklisDetail.getId()));
            SpinerJam.setValue(ceklisDetail.getJam());
            comboNopol.removeAllItems();
            comboNopol.addItem(ceklisDetail.getKendaraan());
            txtMerk.setText(ceklisDetail.getKendaraan().getMerk());
            txtJenis.setText(ceklisDetail.getKendaraan().getJenis());
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
            lblKetDetail.setText(ceklisDetail.getKet());
            
            
            if(comboAreaPlot.getSelectedIndex() != -1){
                comboAreaPlot.setSelectedItem(ceklisDetail.getAreaParkir());
            }else{
                comboAreaPlot.setSelectedItem(null);
            }
            
            
            
        }
        
    }//GEN-LAST:event_tableCeklisDetailMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinerJam;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCariKendaraan;
    private javax.swing.JButton btnCariPengawas;
    private javax.swing.ButtonGroup btnGroupPL;
    private javax.swing.JButton btnHapusTable;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbahDetail;
    private javax.swing.JComboBox comboAreaPlot;
    private javax.swing.JComboBox comboNopol;
    private javax.swing.JComboBox comboPengawas;
    private javax.swing.JComboBox comboPetugas;
    private javax.swing.JComboBox comboSifth;
    private com.toedter.calendar.JDateChooser dateTglCeklis;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelKet;
    private javax.swing.JLabel lblBuatBy;
    private javax.swing.JLabel lblBulan;
    private javax.swing.JLabel lblIdCeklis;
    private javax.swing.JLabel lblIdDetailCeklis;
    private javax.swing.JLabel lblIndex;
    private javax.swing.JLabel lblJdwal;
    private javax.swing.JLabel lblKetDetail;
    private javax.swing.JLabel lblTahun;
    private javax.swing.JLabel lblTglBuat;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private com.imam.sp_checklist.widget.PanelImageBackground panelImageBackground1;
    private com.stripbandunk.jwidget.JDynamicTable tableCeklisDetail;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtMerk;
    // End of variables declaration//GEN-END:variables
}
