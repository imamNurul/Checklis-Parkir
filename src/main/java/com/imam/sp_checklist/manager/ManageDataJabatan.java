/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.master.Jabatan;
import com.imam.sp_checklist.service.JabatanService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataJabatan {
    
    private static ManageDataJabatan INSTANCE;
    
    public static ManageDataJabatan getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataJabatan();
        }
        return ManageDataJabatan.INSTANCE;
    }
    
    public ManageDataJabatan() {
    }
    
    public List<Jabatan> getJabatanAll() {
        return getJabatanService().findAll();
    }
  
    
//    public List<Jabatan> getJabatanByid(String id) {
//        
//        if(id==null){
//            return null;
//        }else{
//            return getJabatanService().findById(id);
//        }
//    }
//    
//    public void inActive(String id){
//        this.getJabatanService().inActive(id);
//    }

    private JabatanService getJabatanService() {
        return SpringManager.getInstance().getBean(JabatanService.class);
    }
    
}
