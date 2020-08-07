package com.imam.sp_checklist.service;

import com.imam.sp_checklist.entity.master.Lot;
import com.imam.sp_checklist.entity.master.Zona;
import java.util.List;

/**
 *
 * @author Imam
 */
public interface LotService extends Service<Lot, String> {
    
    List<Lot> findByidZona(Zona zona);
    
}
