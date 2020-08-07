/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.user_akses.Grup;
import com.imam.sp_checklist.service.GrupService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataGrup {
    
    private static ManageDataGrup INSTANCE;
    
    public static ManageDataGrup getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataGrup();
        }
        return ManageDataGrup.INSTANCE;
    }
    
    public ManageDataGrup() {
    }
    
    public List<Grup> getGrupAll() {
        return getGrupService().findAll();
    }
  
    
//    public List<Grup> getGrupByid(String id) {
//        
//        if(id==null){
//            return null;
//        }else{
//            return getGrupService().findById(id);
//        }
//    }
//    
//    public void inActive(String id){
//        this.getGrupService().inActive(id);
//    }

    private GrupService getGrupService() {
        return SpringManager.getInstance().getBean(GrupService.class);
    }
    
}
