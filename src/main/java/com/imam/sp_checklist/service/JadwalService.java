package com.imam.sp_checklist.service;

import com.imam.sp_checklist.entity.transaksi.Jadwal;
import com.imam.sp_checklist.entity.transaksi.JadwalDetail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Imam
 */
public interface JadwalService {
    
    void save(Jadwal jadwal);
    void update(Jadwal jadwal);
    void delete(Jadwal jadwal);
    public List<Jadwal> findByDate(int bln, int thn);
    List<Jadwal> findAll();
    Jadwal findById(long id);
    List<Jadwal> findAllByFlag(boolean flg);
    List<Jadwal> findByDate(Date date);
    List<JadwalDetail> findAllDetail(int id);
    List<Jadwal> findJadwalByPengawasByPetugasByBln(String pengawas,String petugas, String bln, int thn);
    List<JadwalDetail> findDetailByDate(Date date, int jadwal);
    void isFlag(Jadwal jadwal);
    
    
}
