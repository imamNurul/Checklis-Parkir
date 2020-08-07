package com.imam.sp_checklist.service;

import com.imam.sp_checklist.entity.transaksi.Ceklis;
import com.imam.sp_checklist.entity.transaksi.CeklisDetail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Imam
 */
public interface CeklisService{
    
    void save(Ceklis ceklis);
    void update(Ceklis ceklis);
    void updateDetail(CeklisDetail detail);
    void deleteDetail(CeklisDetail detail);
    
    public List<Ceklis> findAll(String bln, int thn);
    
    public List<Ceklis> findAll(Date from, Date to);
    List<CeklisDetail> findAllDetail(int id);
    void delete(Ceklis ceklis);
}
