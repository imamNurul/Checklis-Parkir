/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.master.Kendaraan;
import com.imam.sp_checklist.service.KendaraanService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataKendaraan {
    
    private static ManageDataKendaraan INSTANCE;
    
    public static ManageDataKendaraan getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataKendaraan();
        }
        return ManageDataKendaraan.INSTANCE;
    }
    
    public ManageDataKendaraan() {
    }
    
    public List<Kendaraan> getKendaraanAll() {
        return getKendaraanService().findAll();
    }
  
    
//    public List<Kendaraan> getKendaraanByid(String id) {
//        
//        if(id==null){
//            return null;
//        }else{
//            return getKendaraanService().findById(id);
//        }
//    }
//    
//    public void inActive(String id){
//        this.getKendaraanService().inActive(id);
//    }

    private KendaraanService getKendaraanService() {
        return SpringManager.getInstance().getBean(KendaraanService.class);
    }
    
}
