/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.user_akses.HakAkses;
import com.imam.sp_checklist.service.HakAksesService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataHakAkses {
    
    private static ManageDataHakAkses INSTANCE;
    
    public static ManageDataHakAkses getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataHakAkses();
        }
        return ManageDataHakAkses.INSTANCE;
    }
    
    public ManageDataHakAkses() {
    }
    
    public List<HakAkses> getHakAksesAll() {
        return getHakAksesService().findAll();
    }
  
    

    private HakAksesService getHakAksesService() {
        return SpringManager.getInstance().getBean(HakAksesService.class);
    }
    
}
