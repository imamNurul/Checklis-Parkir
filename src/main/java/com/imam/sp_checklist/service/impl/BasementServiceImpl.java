
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.service.AbstractService;
import com.imam.sp_checklist.service.BasementService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Imam
 */
@Service
public class BasementServiceImpl extends AbstractService<Basement, String> implements BasementService {

    public BasementServiceImpl() {
        super(Basement.class);
    }
}
