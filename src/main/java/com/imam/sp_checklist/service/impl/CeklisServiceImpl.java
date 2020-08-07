/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.transaksi.Ceklis;
import com.imam.sp_checklist.entity.transaksi.CeklisDetail;
import com.imam.sp_checklist.service.CeklisService;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Imam-pc
 */
@Service
public class CeklisServiceImpl implements CeklisService{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    

    @Override
    @Transactional
    public void save(Ceklis ceklis) {
        Session session = currentSession();
        session.save(ceklis);
    }
    @Override
    @Transactional
    public void update(Ceklis ceklis) {
        Session session = currentSession();
        session.update(ceklis);
    }
    
    @Override
    @Transactional
    public void updateDetail(CeklisDetail detail) {
        Session session = currentSession();
        session.update(detail);
    }
    
    @Override
    @Transactional
    public void deleteDetail(CeklisDetail detail) {
        Session session = currentSession();
        session.delete(detail);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ceklis> findAll(String bln, int thn) {
        Session session = currentSession();
        return session.createQuery("select a from Ceklis a where a.bulan = :bln and a.tahun = :thn").
                setString("bln", bln).setInteger("thn", thn).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ceklis> findAll(Date from, Date to) {
        Session session = currentSession();
        return session.createQuery("select a from Ceklis a where date(a.Tgl_ceklis) between date(:from) and date(:to)").
                setDate("from", from).setDate("to", to).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CeklisDetail> findAllDetail(int id) {
        Session session = currentSession();
        return session.createQuery("select a from CeklisDetail a where a.ceklis = :id order by a.jam ASC").
                setInteger("id", id).list();
    }
    
    @Override
    @Transactional
    public void delete(Ceklis ceklis) {
        Session session = currentSession();
        session.delete(ceklis);
    }

    

    

    
    
}
