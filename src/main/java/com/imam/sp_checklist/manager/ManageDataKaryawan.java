/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.master.Jabatan;
import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.service.KaryawanService;
import java.util.List;


/**
 *
 * @author Imam-pc
 */
public class ManageDataKaryawan {
    
    private static ManageDataKaryawan INSTANCE;
    
    public static ManageDataKaryawan getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ManageDataKaryawan();
        }
        return ManageDataKaryawan.INSTANCE;
    }
    
    public ManageDataKaryawan() {
    }
    
    public List<Karyawan> getKaryawanAll() {
        return getKaryawanService().findAll();
    }
    
    public List<Karyawan> getKaryawanPengawas() {
        return getKaryawanService().findPengawasByJabatan();
    }
    
    public List<Karyawan> getKaryawanPetugas() {
        return getKaryawanService().findPetugasByJabatan();
    }
    
    public List<Karyawan> getKaryawanByJabatan(Jabatan jabatan) {
        return getKaryawanService().findByJabatan(jabatan);
    }
    
    public Karyawan getKaryawanImg(String id) {
        
        if(id==null){
            return null;
        }else{
            return getKaryawanService().findImg(id);
        }
    }
    
    public List<Karyawan> getKaryawanByid(String id) {
        
        if(id==null){
            return null;
        }else{
            return getKaryawanService().findById(id);
        }
    }
    
    public void inActive(String id){
        this.getKaryawanService().inActive(id);
    }

    private KaryawanService getKaryawanService() {
        return SpringManager.getInstance().getBean(KaryawanService.class);
    }
    
}
