/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.imam.sp_checklist.validator.impl;

import com.imam.sp_checklist.entity.user_akses.Grup;
import com.imam.sp_checklist.validator.AbstractValidator;
import com.imam.sp_checklist.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class GrupValidator extends AbstractValidator<Grup> {

    @Override
    protected void doValidate(Grup data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Grup tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Kode grup tidak boleh kosong");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama grup tidak boleh kosong");
        } else if (data.getDaftarHakAkses().isEmpty()) {
            throwValidatorException("Grup harus memiliki hak akses");
        }
    }
}
