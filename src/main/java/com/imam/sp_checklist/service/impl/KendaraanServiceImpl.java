
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.master.Kendaraan;
import com.imam.sp_checklist.service.AbstractService;
import com.imam.sp_checklist.service.KendaraanService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Imam
 */
@Service
public class KendaraanServiceImpl extends AbstractService<Kendaraan, String> implements KendaraanService {

    public KendaraanServiceImpl() {
        super(Kendaraan.class);
    }
}
