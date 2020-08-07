/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.transaksi.Ceklis;
import com.imam.sp_checklist.service.CeklisService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataCeklis {
    
    private static ManageDataCeklis INSTANCE;
    
    public static ManageDataCeklis getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataCeklis();
        }
        return ManageDataCeklis.INSTANCE;
    }
    
    public ManageDataCeklis() {
    }
    
    public List<Ceklis> getCeklisAll(String bln, int thn) {
        return getCeklisService().findAll(bln,thn);
    }
  
    
//    public List<Ceklis> getCeklisByid(String id) {
//        
//        if(id==null){
//            return null;
//        }else{
//            return getCeklisService().findById(id);
//        }
//    }
//    
//    public void inActive(String id){
//        this.getCeklisService().inActive(id);
//    }

    private CeklisService getCeklisService() {
        return SpringManager.getInstance().getBean(CeklisService.class);
    }
    
}
