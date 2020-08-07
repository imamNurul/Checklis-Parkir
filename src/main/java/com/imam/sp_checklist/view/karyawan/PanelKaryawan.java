/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.karyawan;

import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.entity.user_akses.Grup;
import com.imam.sp_checklist.entity.user_akses.HakAksesConstant;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.manager.LoginManager;
import com.imam.sp_checklist.manager.ManageDataKaryawan;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.service.KaryawanService;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Imam-pc
 */
public class PanelKaryawan extends javax.swing.JPanel {
    
    private final DynamicTableModel<Karyawan> tableModel;
    private Karyawan karyawan;
    private ImageIcon nmKryawan;
    
    
    public PanelKaryawan() {
        
        initComponents();
        
        tableModel = new DynamicTableModel<>(Karyawan.class);
        tableKaryawan.setDynamicModel(tableModel);
        
        tableKaryawan.setAutoCreateColumnsFromModel(false);
        tableKaryawan.getSelectionModel().addListSelectionListener(new KaryawanImgSelection());
        
        
    }
    
    public void LoadKaryawan(){
        
        Pengguna pengguna = LoginManager.getInstance().getPengguna();
        Grup grup = pengguna.getGrup();

        btnHapus.setEnabled(grup.mengandungHakAkses(HakAksesConstant.HAPUS_KARYAWAN));
        btnTambah.setEnabled(grup.mengandungHakAkses(HakAksesConstant.TAMBAH_KARYAWAN));
        btnUbah.setEnabled(grup.mengandungHakAkses(HakAksesConstant.UBAH_KARYAWAN));
        
        
       
        new SwingWorker<List<Karyawan>, Object>(){

            @Override
            protected List<Karyawan> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                 List<Karyawan> list = ManageDataKaryawan.getInstance().getKaryawanAll();

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Karyawan jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelKaryawan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    private class KaryawanImgSelection implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(tableKaryawan.getSelectedRow() >= 0){
                karyawan = tableModel.get(tableKaryawan.getSelectedRow());
                //List<Karyawan> list = ManageDataKaryawan.getInstance().getKaryawanImg(karyawan.getId());
                
                
                Karyawan kr = ManageDataKaryawan.getInstance().getKaryawanImg(karyawan.getId());
                karyawan = kr;
                
                System.err.println("LoadDataImage photo : "+karyawan.getPhoto());
                System.err.println("LoadDataImage id: "+karyawan.getId());
                
                if(karyawan.getPhoto() == null || karyawan.getPhoto().equals("")){
                    
                    try {
                        URL imgPath = getClass().getResource("/com/imam/sp_checklist/image/user-kosong.png");
                        BufferedImage myImg = ImageIO.read(imgPath);
                        System.out.println("image path: "+imgPath);
                        
                        Image rImg = myImg.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
                        lblPhoto.setIcon(new ImageIcon(rImg));
                        nmKryawan = null;
                        
                        JFrame frame = new JFrame("Message Warning");
                        JOptionPane.showMessageDialog(frame, "Photo tidak ditemukan");
                    } catch (IOException ex) {
                        Logger.getLogger(PanelKaryawan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                     loadImageKaryawan();
                }
                
               
            }
        }
        
    }
    
    private void loadImageKaryawan(){
        try{
              
                String imgPath = karyawan.getPhoto();
                BufferedImage myImg = ImageIO.read(new File(imgPath));
                System.out.println("image path: "+imgPath);
                
                Image rImg = myImg.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
                lblPhoto.setIcon(new ImageIcon(rImg));
                
                nmKryawan = (ImageIcon) lblPhoto.getIcon();
            }catch(IOException ex){
                try {
                    
                    URL imgPath = getClass().getResource("/com/imam/sp_checklist/image/user-kosong.png");
                    BufferedImage myImg = ImageIO.read(imgPath);
                    System.out.println("image path error: "+imgPath);
                    
                    Image rImg = myImg.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
                    lblPhoto.setIcon(new ImageIcon(rImg));
                    nmKryawan = null;
                    JFrame frame = new JFrame("Message Warning");
                    JOptionPane.showMessageDialog(frame, "Photo tidak ditemukan");
                    System.out.println("error load image font "+ex.getMessage() );
                } catch (IOException ex1) {
                    Logger.getLogger(PanelKaryawan.class.getName()).log(Level.SEVERE, null, ex1);
                }
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

        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKaryawan = new com.stripbandunk.jwidget.JDynamicTable();
        panel_Gambar1 = new com.imam.sp_checklist.widget.Panel_Gambar();
        lblPhoto = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Data Karyawan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N
        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Cari :");

        txtCari.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        jPanel1.setOpaque(false);

        btnTambah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah);

        btnUbah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah);

        btnHapus.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus);

        jScrollPane2.setViewportView(tableKaryawan);

        panel_Gambar1.setOpaque(false);

        lblPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imam/sp_checklist/image/user-kosong.png"))); // NOI18N

        javax.swing.GroupLayout panel_Gambar1Layout = new javax.swing.GroupLayout(panel_Gambar1);
        panel_Gambar1.setLayout(panel_Gambar1Layout);
        panel_Gambar1Layout.setHorizontalGroup(
            panel_Gambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Gambar1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPhoto)
                .addContainerGap())
        );
        panel_Gambar1Layout.setVerticalGroup(
            panel_Gambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Gambar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCari))
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Gambar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_Gambar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        
        TambahKaryawan tk = new TambahKaryawan();
        tk.tambahKaryawan();
        LoadKaryawan();
        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        // Color c = new Color(-16726016, true);
         if(tableKaryawan.getSelectedRow() != -1){
            int index = tableKaryawan.convertRowIndexToModel(tableKaryawan.getSelectedRow());
            Karyawan kr = tableModel.get(index);
            UbahKaryawan ubh = new UbahKaryawan();
            ubh.ubahKaryawan(kr, (ImageIcon) nmKryawan);
            LoadKaryawan();

        }else{
            JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
        }
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(tableKaryawan.getSelectedRow() != -1){
            
            int closing;
            closing = JOptionPane.showConfirmDialog(this,
                "Apakah anda yakin, ingin hapus...?", "Konfirmasi Hapus Data",JOptionPane.YES_NO_OPTION);
            if (closing==0){
                int index = tableKaryawan.convertRowIndexToModel(tableKaryawan.getSelectedRow());
                Karyawan kr = tableModel.get(index);
                KaryawanService sv = SpringManager.getInstance().getBean(KaryawanService.class);
                sv.remove(kr);
                LoadKaryawan();

            }else{
                this.show();
            }
            

        }else{
            JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
        }
        
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
        
         try{
            String cari = txtCari.getText();
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tableKaryawan.getRowSorter();
            sorter.setRowFilter(RowFilter.regexFilter(cari));
        }catch(PatternSyntaxException ex){

        }
        
    }//GEN-LAST:event_txtCariKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPhoto;
    private com.imam.sp_checklist.widget.Panel_Gambar panel_Gambar1;
    private com.stripbandunk.jwidget.JDynamicTable tableKaryawan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
