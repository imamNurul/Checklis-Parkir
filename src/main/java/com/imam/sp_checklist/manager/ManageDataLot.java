/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.master.Lot;
import com.imam.sp_checklist.entity.master.Zona;
import com.imam.sp_checklist.service.LotService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataLot {
    
    private static ManageDataLot INSTANCE;
    
    public static ManageDataLot getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataLot();
        }
        return ManageDataLot.INSTANCE;
    }
    
    public ManageDataLot() {
    }
    
    public List<Lot> getLotAll() {
        return getLotService().findAll();
    }
    
    public List<Lot> getLotByZona(Zona zona) {
        return getLotService().findByidZona(zona);
    }
  

    private LotService getLotService() {
        return SpringManager.getInstance().getBean(LotService.class);
    }
    
}
