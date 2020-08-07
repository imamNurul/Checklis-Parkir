/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.entity.master.Zona;
import com.imam.sp_checklist.service.ZonaService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataZona {
    
    private static ManageDataZona INSTANCE;
    
    public static ManageDataZona getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataZona();
        }
        return ManageDataZona.INSTANCE;
    }
    
    public ManageDataZona() {
    }
    
    public List<Zona> getZonaAll() {
        return getZonaService().findAll();
    }
    
    public List<Zona> getZonaByBasement(Basement basement) {
        return getZonaService().findByidbs(basement);
    }
  

    private ZonaService getZonaService() {
        return SpringManager.getInstance().getBean(ZonaService.class);
    }
    
}
