/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.pengguna;

import com.imam.sp_checklist.entity.user_akses.Grup;
import com.imam.sp_checklist.entity.user_akses.HakAksesConstant;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.manager.LoginManager;
import com.imam.sp_checklist.manager.ManageDataPengguna;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.service.PenggunaService;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingWorker;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Imam-pc
 */
public class PanelPengguna extends javax.swing.JPanel {
    
    private final DynamicTableModel<Pengguna> tableModel;
    private Pengguna pengguna;
    
    
    public PanelPengguna() {
        
        initComponents();
        
        tableModel = new DynamicTableModel<>(Pengguna.class);
        tablePengguna.setDynamicModel(tableModel);
        
        
        
    }
    
    public void LoadPengguna(){
        
        Pengguna pgn = LoginManager.getInstance().getPengguna();
        Grup grup = pgn.getGrup();

        btnHapus.setEnabled(grup.mengandungHakAkses(HakAksesConstant.HAPUS_PENGGUNA));
        btnTambah.setEnabled(grup.mengandungHakAkses(HakAksesConstant.TAMBAH_PENGGUNA));
        btnUbah.setEnabled(grup.mengandungHakAkses(HakAksesConstant.UBAH_PENGGUNA));
        
        
       
        new SwingWorker<List<Pengguna>, Object>(){

            @Override
            protected List<Pengguna> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                 List<Pengguna> list = ManageDataPengguna.getInstance().getPenggunaAll();

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Pengguna jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelPengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
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
        tablePengguna = new com.stripbandunk.jwidget.JDynamicTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Data Pengguna", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N
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

        jScrollPane2.setViewportView(tablePengguna);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCari)))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        
        TambahPengguna tk = new TambahPengguna();
        tk.tambahPengguna();
        LoadPengguna();
        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        // Color c = new Color(-16726016, true);
         if(tablePengguna.getSelectedRow() != -1){
            int index = tablePengguna.convertRowIndexToModel(tablePengguna.getSelectedRow());
            Pengguna kr = tableModel.get(index);
            UbahPengguna ubh = new UbahPengguna();
            ubh.ubahPengguna(kr);
            LoadPengguna();

        }else{
            JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
        }
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(tablePengguna.getSelectedRow() != -1){
            
            int closing;
            closing = JOptionPane.showConfirmDialog(this,
                "Apakah anda yakin, ingin hapus...?", "Konfirmasi Hapus Data",JOptionPane.YES_NO_OPTION);
            if (closing==0){
                int index = tablePengguna.convertRowIndexToModel(tablePengguna.getSelectedRow());
                Pengguna kr = tableModel.get(index);
                PenggunaService sv = SpringManager.getInstance().getBean(PenggunaService.class);
                sv.remove(kr);
                LoadPengguna();

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
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tablePengguna.getRowSorter();
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
    private com.stripbandunk.jwidget.JDynamicTable tablePengguna;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
