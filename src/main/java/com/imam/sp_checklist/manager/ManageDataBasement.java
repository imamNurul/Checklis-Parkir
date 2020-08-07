/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.service.BasementService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataBasement {
    
    private static ManageDataBasement INSTANCE;
    
    public static ManageDataBasement getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataBasement();
        }
        return ManageDataBasement.INSTANCE;
    }
    
    public ManageDataBasement() {
    }
    
    public List<Basement> getBasementAll() {
        return getBasementService().findAll();
    }
  
    
//    public List<Basement> getBasementByid(String id) {
//        
//        if(id==null){
//            return null;
//        }else{
//            return getBasementService().findById(id);
//        }
//    }
//    
//    public void inActive(String id){
//        this.getBasementService().inActive(id);
//    }

    private BasementService getBasementService() {
        return SpringManager.getInstance().getBean(BasementService.class);
    }
    
}
