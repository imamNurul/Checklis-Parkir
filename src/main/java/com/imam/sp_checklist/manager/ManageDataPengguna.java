/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.service.PenggunaService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataPengguna {
    
    private static ManageDataPengguna INSTANCE;
    
    public static ManageDataPengguna getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataPengguna();
        }
        return ManageDataPengguna.INSTANCE;
    }
    
    public ManageDataPengguna() {
    }
    
    public List<Pengguna> getPenggunaAll() {
        return getPenggunaService().findAll();
    }
  
    
//    public List<Pengguna> getPenggunaByid(String id) {
//        
//        if(id==null){
//            return null;
//        }else{
//            return getPenggunaService().findById(id);
//        }
//    }
//    
//    public void inActive(String id){
//        this.getPenggunaService().inActive(id);
//    }

    private PenggunaService getPenggunaService() {
        return SpringManager.getInstance().getBean(PenggunaService.class);
    }
    
}
