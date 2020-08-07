/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.service.AbstractService;
import com.imam.sp_checklist.service.PenggunaService;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class PenggunaServiceImpl extends AbstractService<Pengguna, String> implements PenggunaService {

    public PenggunaServiceImpl() {
        super(Pengguna.class);
    }

    @Transactional(readOnly = true)
    public boolean contains(String id, String kataSandi) {
        Long count = (Long) currentSession().createCriteria(clazz).
                setProjection(Projections.count("id")).add(Restrictions.eq("id", id)).
                add(Restrictions.eq("kataSandi", kataSandi))
                .setMaxResults(1).uniqueResult();
                
        return count > 0;
    }
}
