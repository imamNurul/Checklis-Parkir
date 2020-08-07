/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.imam.sp_checklist.service;

import com.imam.sp_checklist.entity.user_akses.Pengguna;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public interface PenggunaService extends Service<Pengguna, String> {

    boolean contains(String id, String kataSandi);
}
