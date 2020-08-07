/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.master.Shift;
import com.imam.sp_checklist.service.ShiftService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataShift {
    
    private static ManageDataShift INSTANCE;
    
    public static ManageDataShift getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataShift();
        }
        return ManageDataShift.INSTANCE;
    }
    
    public ManageDataShift() {
    }
    
    public List<Shift> getShiftAll() {
        return getShiftService().findAll();
    }
  
    
//    public List<Shift> getShiftByid(String id) {
//        
//        if(id==null){
//            return null;
//        }else{
//            return getShiftService().findById(id);
//        }
//    }
//    
//    public void inActive(String id){
//        this.getShiftService().inActive(id);
//    }

    private ShiftService getShiftService() {
        return SpringManager.getInstance().getBean(ShiftService.class);
    }
    
}
