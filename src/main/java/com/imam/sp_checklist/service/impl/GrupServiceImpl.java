/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.user_akses.Grup;
import com.imam.sp_checklist.service.AbstractService;
import com.imam.sp_checklist.service.GrupService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class GrupServiceImpl extends AbstractService<Grup, String> implements GrupService {

    public GrupServiceImpl() {
        super(Grup.class);
    }
}
