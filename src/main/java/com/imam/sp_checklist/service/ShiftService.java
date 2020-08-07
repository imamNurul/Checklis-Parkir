package com.imam.sp_checklist.service;

import com.imam.sp_checklist.entity.master.Shift;
import com.imam.sp_checklist.entity.transaksi.Jadwal;
import java.util.List;

/**
 *
 * @author Imam
 */
public interface ShiftService extends Service<Shift, String> {
    
    public Shift findJamShift(String id);
    public List<Shift> findShiftByJadwal(Jadwal jadwal);
    
}
