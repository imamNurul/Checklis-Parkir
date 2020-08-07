/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist;

import com.imam.sp_checklist.entity.user_akses.Grup;
import com.imam.sp_checklist.entity.user_akses.HakAksesConstant;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.manager.LoginManager;
import com.imam.sp_checklist.view.karyawan.PanelKaryawan;
import com.stripbandunk.jglasspane.helper.GraphicHelper;
import com.stripbandunk.jglasspane.transition.image.FadeImageTransition;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Imam-pc
 */
public class Menu_Utama extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    Container cnt;
    PanelKaryawan panelKaryawan;
    String bln;
    int thn;
    private Pengguna pengguna;
    
    public Menu_Utama() {
        this.setIconImage(new ImageIcon(getClass().getResource("/com/imam/sp_checklist/image/iconParking.png")).getImage());
        setExtendedState(MAXIMIZED_BOTH);
        jam();
        initComponents();
        
        
        Date now = new Date();
        Locale locale = new Locale("id","ID");
        SimpleDateFormat frm = new SimpleDateFormat("EEEE, dd MMMM YYYY",locale);
        SimpleDateFormat tm = new SimpleDateFormat("HH:mm:ss",locale);
        Calendar cal = Calendar.getInstance(locale);
        cal.setTime(now);
        
        int month = cal.get(Calendar.MONTH);
//        int idx = 1;
//        int vm = month + idx;
//        
          DateFormatSymbols dfs = new DateFormatSymbols(locale);
          String namaBln = dfs.getMonths()[month];
        
        bln = namaBln;
        thn = cal.get(Calendar.YEAR);
        System.out.println("bulan now: "+bln);
        System.out.println("tahun now: "+thn);
        
        String tgl = frm.format(now);
        String times = tm.format(now);
        lblTgl.setText(tgl);
        lblJam.setText(times);
    
    
    }
    
    public Pengguna getUser(Pengguna user){
        
        pengguna = user;
        
        if(pengguna != null){
            
            lblJabatan.setText(pengguna.getKaryawan().getJabatan().getNama());
            lblNamaUser.setText(pengguna.getKaryawan().getNama());
        }
        
        setLocationRelativeTo(this);
        setVisible(true);
        
        return pengguna;
    }
    
    public void login(){
        Login login = new Login();
        
        login.setLocationRelativeTo(this);
        login.setVisible(true);
        
        
    }
    
    private void logout(){
        login();
        dispose();
    }
    
    private void jam(){
        ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        String nol_bulan = "";
        String nol_hari = "";
        String nol_jam = "";
        String nol_menit = "";
        String nol_detik = "";
        // Membuat Date
        Date dt = new Date();
        // Mengambil nilaj JAM, MENIT, dan DETIK Sekarang
        int nilai_tahun = dt.getYear() + 1900;
        int nilai_bulan = dt.getMonth() + 1;
        int nilai_hari = dt.getDate();
        int nilai_jam = dt.getHours();
        int nilai_menit = dt.getMinutes();
        int nilai_detik = dt.getSeconds();
        // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
        if (nilai_bulan <= 9) {
          // Tambahkan "0" didepannya
          nol_bulan = "0";
        }
        if (nilai_hari <= 9) {
          // Tambahkan "0" didepannya
          nol_hari = "0";
        }
        if (nilai_jam <= 9) {
          // Tambahkan "0" didepannya
          nol_jam = "0";
        }
        // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
        if (nilai_menit <= 9) {
          // Tambahkan "0" didepannya
          nol_menit = "0";
        }
        // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
        if (nilai_detik <= 9) {
          // Tambahkan "0" didepannya
          nol_detik = "0";
        }
        // Membuat String JAM, MENIT, DETIK
        String bulan = nol_bulan + Integer.toString(nilai_bulan);
        String hari = nol_hari + Integer.toString(nilai_hari);
        String jam = nol_jam + Integer.toString(nilai_jam);
        String menit = nol_menit + Integer.toString(nilai_menit);
        String detik = nol_detik + Integer.toString(nilai_detik);
        // Menampilkan pada Layar
       lblJam.setFont(new java.awt.Font("Digifacewide", Font.BOLD, 12));
       lblJam.setText(jam + " : " + menit + " : " + detik);
      } 
    };
    // Timer
    new Timer(1000, taskPerformer).start();
    }
    
    public void renderHakAkses() {
        
        Pengguna pgn = LoginManager.getInstance().getPengguna();
        Grup grup = pgn.getGrup();
        
        lblJabatan.setText(pgn.getKaryawan().getJabatan().getNama());
        lblNamaUser.setText(pgn.getKaryawan().getNama());
        
        //System.out.println("grouupppp : "+grup);

        menuMaster.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_MASTER));
        menuHakAkses.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_HAKAKSES));
        menuTransaksi.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_TRANSAKSI));
        menuDataBasement.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_BASEMENT));
        menuDataKaryawan.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_KARYAWAN));
        menuDataKendaraan.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_KENDARAAN));
        menuDataLot.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_LOT));
        menuDataZona.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_ZONA));
        menuFormCeklis.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_FORM_CEKLIS));
        menuGroup.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_GRUP));
        menuLapMaster.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_LAPORAN_MASTER));
        menuDataJabatan.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_JABATAN));
        menuLapHakAkses.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_LAPORAN_HAK_AKSES));
        menuLapTransaksi.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_LAPORAN_TRANSAKSI));
        menuPengguna.setEnabled(grup.mengandungHakAkses(HakAksesConstant.LIHAT_PENGGUNA));
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jGlassPane1 = new com.stripbandunk.jglasspane.JGlassPane();
        imageTransitionComponent1 = new com.stripbandunk.jglasspane.component.ImageTransitionComponent();
        PanelBG = new com.imam.sp_checklist.widget.PanelImageBackground();
        lblTgl = new javax.swing.JLabel();
        lblJam = new javax.swing.JLabel();
        lblNamaUser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblJabatan = new javax.swing.JLabel();
        PanelCard = new javax.swing.JPanel();
        welcome1 = new com.imam.sp_checklist.Welcome();
        panelKaryawan1 = new com.imam.sp_checklist.view.karyawan.PanelKaryawan();
        panelPengguna1 = new com.imam.sp_checklist.view.pengguna.PanelPengguna();
        panelGrup1 = new com.imam.sp_checklist.view.grup.PanelGrup();
        panelJabatan1 = new com.imam.sp_checklist.view.jabatan.PanelJabatan();
        panelKendaraan1 = new com.imam.sp_checklist.view.kendaraan.PanelKendaraan();
        panelBasement1 = new com.imam.sp_checklist.view.basement.PanelBasement();
        panelLot1 = new com.imam.sp_checklist.view.lot.PanelLot();
        panelShift1 = new com.imam.sp_checklist.view.shift.PanelShift();
        panelZona1 = new com.imam.sp_checklist.view.zona.PanelZona();
        panelJadwal1 = new com.imam.sp_checklist.view.jadwal.PanelJadwal();
        panelCeklis1 = new com.imam.sp_checklist.view.ceklis.PanelCeklis();
        laporanMaster1 = new com.imam.sp_checklist.view.laporan.LaporanMaster();
        laporanTransaksi1 = new com.imam.sp_checklist.view.laporan.LaporanTransaksi();
        laporanHakAkses1 = new com.imam.sp_checklist.view.laporan.LaporanHakAkses();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuLogout = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuKeluar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuMaster = new javax.swing.JMenu();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuDataKendaraan = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        menuDataJabatan = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        menuDataKaryawan = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuDataBasement = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        menuDataZona = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        menuDataLot = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        menuDataShift = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        menuHakAkses = new javax.swing.JMenu();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        menuPengguna = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        menuGroup = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        menuTransaksi = new javax.swing.JMenu();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        menuFormCeklis = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuInputJadwal = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        menuLapMaster = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        menuLapHakAkses = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        menuLapTransaksi = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout imageTransitionComponent1Layout = new javax.swing.GroupLayout(imageTransitionComponent1);
        imageTransitionComponent1.setLayout(imageTransitionComponent1Layout);
        imageTransitionComponent1Layout.setHorizontalGroup(
            imageTransitionComponent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        imageTransitionComponent1Layout.setVerticalGroup(
            imageTransitionComponent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        lblTgl.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblTgl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTgl.setText("Rabu, 31 Desember 2020");
        lblTgl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblJam.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblJam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJam.setText("00:00:00");
        lblJam.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblNamaUser.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblNamaUser.setText("Username");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("|");

        lblJabatan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblJabatan.setText("JABATAN");

        PanelCard.setOpaque(false);
        PanelCard.setLayout(new java.awt.CardLayout());
        PanelCard.add(welcome1, "welcome");
        PanelCard.add(panelKaryawan1, "karyawan");
        PanelCard.add(panelPengguna1, "pengguna");
        PanelCard.add(panelGrup1, "grup");
        PanelCard.add(panelJabatan1, "jabatan");
        PanelCard.add(panelKendaraan1, "kendaraan");
        PanelCard.add(panelBasement1, "basement");
        PanelCard.add(panelLot1, "lot");
        PanelCard.add(panelShift1, "shift");
        PanelCard.add(panelZona1, "zona");
        PanelCard.add(panelJadwal1, "jadwal");
        PanelCard.add(panelCeklis1, "ceklis");
        PanelCard.add(laporanMaster1, "laporanMaster");
        PanelCard.add(laporanTransaksi1, "laporanTransaksi");
        PanelCard.add(laporanHakAkses1, "laporanAkses");

        javax.swing.GroupLayout PanelBGLayout = new javax.swing.GroupLayout(PanelBG);
        PanelBG.setLayout(PanelBGLayout);
        PanelBGLayout.setHorizontalGroup(
            PanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBGLayout.createSequentialGroup()
                .addComponent(lblJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblJam, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PanelCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelBGLayout.setVerticalGroup(
            PanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBGLayout.createSequentialGroup()
                .addComponent(PanelCard, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJam)
                    .addComponent(lblTgl)
                    .addComponent(lblJabatan)
                    .addComponent(jLabel4)
                    .addComponent(lblNamaUser)))
        );

        menuFile.setText("File");
        menuFile.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuFile.add(jSeparator1);

        menuLogout.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuLogout.setText("Keluar Pengguna");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuFile.add(menuLogout);
        menuFile.add(jSeparator2);

        menuKeluar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuKeluar.setText("Keluar Aplikasi");
        menuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKeluarActionPerformed(evt);
            }
        });
        menuFile.add(menuKeluar);
        menuFile.add(jSeparator3);

        jMenuBar1.add(menuFile);

        menuMaster.setText("Master");
        menuMaster.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuMaster.add(jSeparator4);

        menuDataKendaraan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuDataKendaraan.setText("Data Kendaraan");
        menuDataKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDataKendaraanActionPerformed(evt);
            }
        });
        menuMaster.add(menuDataKendaraan);
        menuMaster.add(jSeparator23);

        menuDataJabatan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuDataJabatan.setText("Data Jabatan");
        menuDataJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDataJabatanActionPerformed(evt);
            }
        });
        menuMaster.add(menuDataJabatan);
        menuMaster.add(jSeparator21);

        menuDataKaryawan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuDataKaryawan.setText("Data Karyawan");
        menuDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDataKaryawanActionPerformed(evt);
            }
        });
        menuMaster.add(menuDataKaryawan);
        menuMaster.add(jSeparator5);

        menuDataBasement.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuDataBasement.setText("Data Basement");
        menuDataBasement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDataBasementActionPerformed(evt);
            }
        });
        menuMaster.add(menuDataBasement);
        menuMaster.add(jSeparator12);

        menuDataZona.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuDataZona.setText("Data Zona");
        menuDataZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDataZonaActionPerformed(evt);
            }
        });
        menuMaster.add(menuDataZona);
        menuMaster.add(jSeparator13);

        menuDataLot.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuDataLot.setText("Data Lot");
        menuDataLot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDataLotActionPerformed(evt);
            }
        });
        menuMaster.add(menuDataLot);
        menuMaster.add(jSeparator24);

        menuDataShift.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuDataShift.setText("Data Shift");
        menuDataShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDataShiftActionPerformed(evt);
            }
        });
        menuMaster.add(menuDataShift);
        menuMaster.add(jSeparator6);

        jMenuBar1.add(menuMaster);

        menuHakAkses.setText("Hak Akses");
        menuHakAkses.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuHakAkses.add(jSeparator15);

        menuPengguna.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuPengguna.setText("Pengguna");
        menuPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPenggunaActionPerformed(evt);
            }
        });
        menuHakAkses.add(menuPengguna);
        menuHakAkses.add(jSeparator16);

        menuGroup.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuGroup.setText("Grup");
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menuHakAkses.add(menuGroup);
        menuHakAkses.add(jSeparator20);

        jMenuBar1.add(menuHakAkses);

        menuTransaksi.setText("Transaksi");
        menuTransaksi.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuTransaksi.add(jSeparator7);

        menuFormCeklis.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuFormCeklis.setText("Form Ceklis Kendaraan");
        menuFormCeklis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFormCeklisActionPerformed(evt);
            }
        });
        menuTransaksi.add(menuFormCeklis);
        menuTransaksi.add(jSeparator8);

        menuInputJadwal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuInputJadwal.setText("Data Jadwal Petugas");
        menuInputJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInputJadwalActionPerformed(evt);
            }
        });
        menuTransaksi.add(menuInputJadwal);

        jMenuBar1.add(menuTransaksi);

        jMenu4.setText("Laporan");
        jMenu4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jMenu4.add(jSeparator9);

        menuLapMaster.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuLapMaster.setText("Laporan Master");
        menuLapMaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLapMasterActionPerformed(evt);
            }
        });
        jMenu4.add(menuLapMaster);
        jMenu4.add(jSeparator10);

        menuLapHakAkses.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuLapHakAkses.setText("Laporan Hak Akses");
        menuLapHakAkses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLapHakAksesActionPerformed(evt);
            }
        });
        jMenu4.add(menuLapHakAkses);
        jMenu4.add(jSeparator11);

        menuLapTransaksi.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuLapTransaksi.setText("Laporan Transaksi");
        menuLapTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLapTransaksiActionPerformed(evt);
            }
        });
        jMenu4.add(menuLapTransaksi);
        jMenu4.add(jSeparator17);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        // TODO add your handling code here:
        
        int closing;
        closing = JOptionPane.showConfirmDialog(this,
            "Apakah anda yakin, ingin logout dari Aplikasi ini...?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (closing==0){
            
            FadeImageTransition transition = new FadeImageTransition();
            transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

            imageTransitionComponent1.setTransition(transition);
            CardLayout layout = (CardLayout) PanelCard.getLayout();
            layout.show(PanelCard, "welcome");
            
            logout();
        }else{
            this.show();
        }
        
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKeluarActionPerformed
        // TODO add your handling code here:
        
         int closing;
        closing = JOptionPane.showConfirmDialog(this,
            "Apakah anda yakin, ingin keluar dari Aplikasi ini...?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (closing==0){
            System.exit(0);

        }else{
            this.show();
        }
        
    }//GEN-LAST:event_menuKeluarActionPerformed

    private void menuDataKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDataKaryawanActionPerformed
        // TODO add your handling code here:
        
        panelKaryawan = new PanelKaryawan();
        
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "karyawan");
        panelKaryawan1.LoadKaryawan();
    }//GEN-LAST:event_menuDataKaryawanActionPerformed

    private void menuDataKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDataKendaraanActionPerformed
        // TODO add your handling code here:
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "kendaraan");
        panelKendaraan1.LoadKendaraan();
    }//GEN-LAST:event_menuDataKendaraanActionPerformed

    private void menuFormCeklisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFormCeklisActionPerformed
        // TODO add your handling code here:
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "ceklis");
        panelCeklis1.LoadCeklis(bln, thn);
    }//GEN-LAST:event_menuFormCeklisActionPerformed

    private void menuDataBasementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDataBasementActionPerformed
        // TODO add your handling code here:
        
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "basement");
        panelBasement1.LoadBasement();
        
    }//GEN-LAST:event_menuDataBasementActionPerformed

    private void menuDataZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDataZonaActionPerformed
        // TODO add your handling code here:
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "zona");
        panelZona1.LoadZona();
    }//GEN-LAST:event_menuDataZonaActionPerformed

    private void menuDataLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDataLotActionPerformed
        // TODO add your handling code here:
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "lot");
        panelLot1.LoadLot();
    }//GEN-LAST:event_menuDataLotActionPerformed

    private void menuPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenggunaActionPerformed
        // TODO add your handling code here:
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "pengguna");
        panelPengguna1.LoadPengguna();
    }//GEN-LAST:event_menuPenggunaActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
        // TODO add your handling code here:
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "grup");
        panelGrup1.LoadGrup();
    }//GEN-LAST:event_menuGroupActionPerformed

    private void menuDataJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDataJabatanActionPerformed
        // TODO add your handling code here:
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "jabatan");
        panelJabatan1.LoadJabatan();
    }//GEN-LAST:event_menuDataJabatanActionPerformed

    private void menuDataShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDataShiftActionPerformed
        // TODO add your handling code here:
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "shift");
        panelShift1.LoadShift();
    }//GEN-LAST:event_menuDataShiftActionPerformed

    private void menuInputJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInputJadwalActionPerformed
        // TODO add your handling code here:
        
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "jadwal");
        panelJadwal1.LoadJadwal(true);
        
    }//GEN-LAST:event_menuInputJadwalActionPerformed

    private void menuLapMasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLapMasterActionPerformed
        // TODO add your handling code here:
        
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "laporanMaster");
        laporanMaster1.LoadBasement();
        laporanMaster1.LoadJabatanCombo();
        laporanMaster1.LoadKaryawanKaryawanComboAll();
        laporanMaster1.LoadLot();
        laporanMaster1.LoadShift();
        laporanMaster1.LoadZona();
    }//GEN-LAST:event_menuLapMasterActionPerformed

    private void menuLapHakAksesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLapHakAksesActionPerformed
        // TODO add your handling code here:
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "laporanAkses");
        laporanHakAkses1.LoadGrupCombo();
        laporanHakAkses1.LoadPenggunaCombo();
    }//GEN-LAST:event_menuLapHakAksesActionPerformed

    private void menuLapTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLapTransaksiActionPerformed
        // TODO add your handling code here:
        FadeImageTransition transition = new FadeImageTransition();
        transition.setCoordinate(GraphicHelper.getLocation(PanelCard, jGlassPane1));

        imageTransitionComponent1.setTransition(transition);
        CardLayout layout = (CardLayout) PanelCard.getLayout();
        layout.show(PanelCard, "laporanTransaksi");
        laporanTransaksi1.LoadComboPengawas();
        laporanTransaksi1.LoadComboPetugas();
        laporanTransaksi1.LoadComboShift();
    }//GEN-LAST:event_menuLapTransaksiActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Menu_Utama utama = new Menu_Utama();
                utama.renderHakAkses();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.imam.sp_checklist.widget.PanelImageBackground PanelBG;
    private javax.swing.JPanel PanelCard;
    private com.stripbandunk.jglasspane.component.ImageTransitionComponent imageTransitionComponent1;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private com.imam.sp_checklist.view.laporan.LaporanHakAkses laporanHakAkses1;
    private com.imam.sp_checklist.view.laporan.LaporanMaster laporanMaster1;
    private com.imam.sp_checklist.view.laporan.LaporanTransaksi laporanTransaksi1;
    private javax.swing.JLabel lblJabatan;
    private javax.swing.JLabel lblJam;
    private javax.swing.JLabel lblNamaUser;
    private javax.swing.JLabel lblTgl;
    private javax.swing.JMenuItem menuDataBasement;
    private javax.swing.JMenuItem menuDataJabatan;
    private javax.swing.JMenuItem menuDataKaryawan;
    private javax.swing.JMenuItem menuDataKendaraan;
    private javax.swing.JMenuItem menuDataLot;
    private javax.swing.JMenuItem menuDataShift;
    private javax.swing.JMenuItem menuDataZona;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuFormCeklis;
    private javax.swing.JMenuItem menuGroup;
    private javax.swing.JMenu menuHakAkses;
    private javax.swing.JMenuItem menuInputJadwal;
    private javax.swing.JMenuItem menuKeluar;
    private javax.swing.JMenuItem menuLapHakAkses;
    private javax.swing.JMenuItem menuLapMaster;
    private javax.swing.JMenuItem menuLapTransaksi;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuMaster;
    private javax.swing.JMenuItem menuPengguna;
    private javax.swing.JMenu menuTransaksi;
    private com.imam.sp_checklist.view.basement.PanelBasement panelBasement1;
    private com.imam.sp_checklist.view.ceklis.PanelCeklis panelCeklis1;
    private com.imam.sp_checklist.view.grup.PanelGrup panelGrup1;
    private com.imam.sp_checklist.view.jabatan.PanelJabatan panelJabatan1;
    private com.imam.sp_checklist.view.jadwal.PanelJadwal panelJadwal1;
    private com.imam.sp_checklist.view.karyawan.PanelKaryawan panelKaryawan1;
    private com.imam.sp_checklist.view.kendaraan.PanelKendaraan panelKendaraan1;
    private com.imam.sp_checklist.view.lot.PanelLot panelLot1;
    private com.imam.sp_checklist.view.pengguna.PanelPengguna panelPengguna1;
    private com.imam.sp_checklist.view.shift.PanelShift panelShift1;
    private com.imam.sp_checklist.view.zona.PanelZona panelZona1;
    private com.imam.sp_checklist.Welcome welcome1;
    // End of variables declaration//GEN-END:variables
}
