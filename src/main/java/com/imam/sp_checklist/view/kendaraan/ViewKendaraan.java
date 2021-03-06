/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.view.kendaraan;

import com.imam.sp_checklist.entity.master.Kendaraan;
import com.imam.sp_checklist.manager.ManageDataKendaraan;
import com.imam.sp_checklist.manager.SpringManager;
import com.imam.sp_checklist.service.KendaraanService;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author Imam-pc
 */
public class ViewKendaraan extends javax.swing.JDialog {

    private final DynamicTableModel<Kendaraan> tableModel;
    private Kendaraan kendaraan;
    
    public ViewKendaraan() {
        setModal(true);
        initComponents();
        
        tableModel = new DynamicTableModel<>(Kendaraan.class);
        tableCari.setDynamicModel(tableModel);
        
    }
    
    public Kendaraan CariKendaraan(){
        
         KendaraanService service = SpringManager.getInstance().getBean(KendaraanService.class);
        List<Kendaraan> list = service.findAll();

        for (Kendaraan value : list) {
            tableModel.add(value);
        }
        
        setLocationRelativeTo(this);
        setVisible(true);
        
        return kendaraan;
    }
    
    
//    private void LoadCariKendaraan(){
//        
//        new SwingWorker<List<Kendaraan>, Object>(){
//
//            @Override
//            protected List<Kendaraan> doInBackground() throws Exception {
//                
//                Thread.sleep(1000);
//                List<Kendaraan> list = ManageDataKendaraan.getInstance().getKendaraanAll();
//
//                return list;
//            }
//
//            @Override
//            protected void done() {
//                try {
//                    tableModel.clear();
//                    for(Kendaraan jsb : get()){
//                    tableModel.add(jsb);
//                }
//                } catch (InterruptedException | ExecutionException ex) {
//                    Logger.getLogger(ViewKendaraan.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//  
//        }.execute();
//        
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImageBackground1 = new com.imam.sp_checklist.widget.PanelImageBackground();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCari = new com.stripbandunk.jwidget.JDynamicTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelImageBackground1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cari Kendaraan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Cari :");

        jTextField1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        tableCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCariMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCari);

        javax.swing.GroupLayout panelImageBackground1Layout = new javax.swing.GroupLayout(panelImageBackground1);
        panelImageBackground1.setLayout(panelImageBackground1Layout);
        panelImageBackground1Layout.setHorizontalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        panelImageBackground1Layout.setVerticalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelImageBackground1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCariMouseClicked
        // TODO add your handling code here:
        
        if(evt.getClickCount()==2){
            
            kendaraan = tableModel.get(tableCari.convertRowIndexToModel(tableCari.getSelectedRow()));
            dispose();
            
        }
        
    }//GEN-LAST:event_tableCariMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private com.imam.sp_checklist.widget.PanelImageBackground panelImageBackground1;
    private com.stripbandunk.jwidget.JDynamicTable tableCari;
    // End of variables declaration//GEN-END:variables
}
