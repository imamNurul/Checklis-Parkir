/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.transaksi.Jadwal;
import com.imam.sp_checklist.entity.transaksi.JadwalDetail;
import com.imam.sp_checklist.service.JadwalService;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Imam
 */
@Service
public class JadwalServiceImpl implements JadwalService {

    @Autowired
    private SessionFactory sessionFactory;


    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jadwal> findByDate(int bln, int thn) {
        Session session = currentSession();
        return session.createQuery("select a from Jadwal a where a.flag = 1 AND bulan = :bln AND tahun = :to ").
                setInteger("bln", bln).setInteger("thn", thn).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jadwal> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Jadwal.class).list();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Jadwal findById(long id) {
        return (Jadwal) sessionFactory.getCurrentSession().get(Jadwal.class, id);
    }

    @Override
    @Transactional
    public void save(Jadwal jadwal) {
        Session session = currentSession();
        session.save(jadwal);
    }

    @Override
    @Transactional
    public void update(Jadwal jadwal) {
        Session session = currentSession();
        session.update(jadwal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JadwalDetail> findAllDetail(int id) {
        Session session = currentSession();
        return session.createQuery("select a from JadwalDetail a where jadwal = :id ").
                setInteger("id", id).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jadwal> findByDate(Date date) {
        Session session = currentSession();
        return session.createQuery("select a from Jadwal a where a.flag = 1 AND tglJadwal = :date ").
                setDate("date", date).list();
    }

    @Override
    @Transactional
    public void delete(Jadwal jadwal) {
        Session session = currentSession();
        session.delete(jadwal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jadwal> findJadwalByPengawasByPetugasByBln(String pengawas,String petugas, String bln, int thn) {
       // sessionFactory.getCurrentSession().get(Jadwal.class, pengawas).get(Jadwal.class, petugas);
       // return (Jadwal) sessionFactory.getCurrentSession().get(Jadwal.class, pengawas);
        Session session = currentSession();
        return session.createQuery("select a from Jadwal a where a.flag = 1 AND a.pengawas = :pengawas AND a.petugas = :petugas AND a.bulan = :bln AND a.tahun = :thn ").
                setString("pengawas",pengawas).
                setString("petugas",petugas).
                setString("bln", bln).
                setInteger("thn", thn).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<JadwalDetail> findDetailByDate(Date date, int jadwal) {
        Session session = currentSession();
        return session.createQuery("select a from JadwalDetail a where a.tglDetail = :date and a.jadwal = :jadwal order by a.tglDetail ASC").
                setDate("date", date).
                setInteger("jadwal", jadwal).list();
    }

    @Override
    @Transactional
    public void isFlag(Jadwal jadwal) {
        sessionFactory.getCurrentSession().update(jadwal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jadwal> findAllByFlag(boolean flg) {
        Session session = currentSession();
        return session.createQuery("select a from Jadwal a where a.flag = :flg").setBoolean("flg", flg).list();
    }

    
    

}
