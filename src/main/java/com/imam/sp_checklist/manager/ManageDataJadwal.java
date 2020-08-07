/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.transaksi.Jadwal;
import com.imam.sp_checklist.service.JadwalService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataJadwal {
    
    private static ManageDataJadwal INSTANCE;
    
    public static ManageDataJadwal getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataJadwal();
        }
        return ManageDataJadwal.INSTANCE;
    }
    
    public ManageDataJadwal() {
    }
    
    public List<Jadwal> getJadwalAll() {
        return getJadwalService().findAll();
    }
    public List<Jadwal> getJadwalAllByFlag(boolean flg) {
        return getJadwalService().findAllByFlag(flg);
    }
  
    
//    public List<Jadwal> getJadwalByid(String id) {
//        
//        if(id==null){
//            return null;
//        }else{
//            return getJadwalService().findById(id);
//        }
//    }
//    
//    public void inActive(String id){
//        this.getJadwalService().inActive(id);
//    }

    private JadwalService getJadwalService() {
        return SpringManager.getInstance().getBean(JadwalService.class);
    }
    
}
