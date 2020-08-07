
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.master.Shift;
import com.imam.sp_checklist.entity.transaksi.Jadwal;
import com.imam.sp_checklist.service.AbstractService;
import com.imam.sp_checklist.service.ShiftService;
import java.sql.Time;
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
public class ShiftServiceImpl extends AbstractService<Shift, String> implements ShiftService {

    
    @Autowired
    private SessionFactory sessionFactory;
    
    public ShiftServiceImpl() {
        super(Shift.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Shift findJamShift(String id) {
        return (Shift) sessionFactory.getCurrentSession().get(Shift.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shift> findShiftByJadwal(Jadwal jadwal) {
        return (List<Shift>) sessionFactory.getCurrentSession().get(Shift.class, jadwal);
    }
}
