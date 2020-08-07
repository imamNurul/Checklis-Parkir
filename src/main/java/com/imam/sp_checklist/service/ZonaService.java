package com.imam.sp_checklist.service;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.entity.master.Zona;
import java.util.List;

/**
 *
 * @author Imam
 */
public interface ZonaService extends Service<Zona, String> {
    
    List<Zona> findByidbs(Basement basement);
    
}
