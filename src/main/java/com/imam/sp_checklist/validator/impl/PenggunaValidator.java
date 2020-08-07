/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.imam.sp_checklist.validator.impl;

import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.validator.AbstractValidator;
import com.imam.sp_checklist.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class PenggunaValidator extends AbstractValidator<Pengguna> {

    @Override
    protected void doValidate(Pengguna data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Pengguna tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Kode pengguna tidak boleh kosong");
        } else if (data.getKataSandi().trim().isEmpty()) {
            throwValidatorException("Kata sandi pengguna tidak boleh kosong");
        } else if (data.getGrup() == null) {
            throwValidatorException("Grup pengguna tidak boleh null");
        } else if (data.getKaryawan() == null) {
            throwValidatorException("Karyawan pengguna tidak boleh null");
        }
    }
}
