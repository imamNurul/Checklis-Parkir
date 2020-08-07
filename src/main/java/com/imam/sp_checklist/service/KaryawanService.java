package com.imam.sp_checklist.service;

import com.imam.sp_checklist.entity.master.Jabatan;
import com.imam.sp_checklist.entity.master.Karyawan;
import java.util.List;

/**
 *
 * @author Eko Imam
 */
public interface KaryawanService extends Service<Karyawan, String> {
    
    Karyawan findImg(String NIP);
    List<Karyawan> findById(String NIP);
    List<Karyawan> findByJabatan(Jabatan jabatan);
    Karyawan findJabatanById(String id);
    void inActive(String id);
    List<Karyawan> findPengawasByJadwalBlnThn(String bln, int thn);
    List<Karyawan> findPetugasByPengawas(String NIP);
    List<Karyawan> findPengawasByJabatan();
    List<Karyawan> findPetugasByJabatan();
    
    
}
