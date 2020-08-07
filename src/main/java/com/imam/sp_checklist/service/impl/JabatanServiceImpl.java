/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.master.Jabatan;
import com.imam.sp_checklist.service.AbstractService;
import com.imam.sp_checklist.service.JabatanService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class JabatanServiceImpl extends AbstractService<Jabatan, String> implements JabatanService {

    public JabatanServiceImpl() {
        super(Jabatan.class);
    }
}
