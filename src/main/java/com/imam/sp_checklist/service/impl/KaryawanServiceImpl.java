
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.master.Jabatan;
import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.service.AbstractService;
import com.imam.sp_checklist.service.KaryawanService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Imam
 */
@Service
public class KaryawanServiceImpl extends AbstractService<Karyawan, String> implements KaryawanService {

    public KaryawanServiceImpl() {
        super(Karyawan.class);
    }
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional(readOnly = true)
    public Karyawan findImg(String NIP) {
        
        return (Karyawan) sessionFactory.getCurrentSession().get(Karyawan.class, NIP);
        //Session session = currentSession();
        //return (Karyawan) session.createQuery("SELECT k.id, k.photo FROM Karyawan k WHERE k.id = :NIP").setString("NIP", NIP);
    }

    @Override
    @Transactional
    public void inActive(String id) {
        Session session = currentSession();
        session.createQuery("UPDATE Karyawan SET flag = 'N' WHERE id = :id").setString("id", id).executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Karyawan> findById(String NIP) {
        Session session = currentSession();
        return session.createQuery("SELECT * FROM Karyawan WHERE id = :NIP").setString("NIP", NIP).list();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Karyawan> findByJabatan(Jabatan jabatan) {
        return currentSession().createCriteria(Karyawan.class).
                add(Restrictions.eq("jabatan", jabatan)).list();
    }

    @Override
    @Transactional(readOnly = true)
    public Karyawan findJabatanById(String id) {
        Session session = currentSession();
        return (Karyawan) session.createQuery("SELECT tk.id, tj.id_jabatan FROM Karyawan tk "
                                                + "inner join Jabatan tj on tk.id_jabatan = tj.id WHERE tk.id = :id").setString("id", id);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Karyawan> findPengawasByJadwalBlnThn(String bln, int thn) {
        Session session = currentSession();
        return session.createQuery("SELECT distinct k FROM Karyawan k, Jadwal j "
                + "WHERE k.id = j.pengawas AND j.bulan = :bln AND j.tahun = :thn "
                + " and j.petugas in (select tj.petugas from Jadwal tj where tj.flag = 1)").setString("bln", bln).setInteger("thn", thn).list();
    }

    @Override
    @Transactional
    public List<Karyawan> findPetugasByPengawas(String NIP) {
        Session session = currentSession();
        return session.createQuery("SELECT distinct k FROM Karyawan k, Jadwal j "
                + "WHERE k.id = j.petugas AND j.pengawas = :NIP AND j.flag = 1").setString("NIP", NIP).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Karyawan> findPengawasByJabatan() {
        Session session = currentSession();
        return session.createQuery("SELECT distinct k FROM Karyawan k, Jabatan j "
                + "WHERE k.jabatan = j.id AND j.pengawas = 1").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Karyawan> findPetugasByJabatan() {
        Session session = currentSession();
        return session.createQuery("SELECT distinct k FROM Karyawan k, Jabatan j "
                + "WHERE k.jabatan = j.id AND j.pengawas = 0").list();
    }

    
}
