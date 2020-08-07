/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.imam.sp_checklist.validator.impl;

import com.imam.sp_checklist.entity.master.Jabatan;
import com.imam.sp_checklist.validator.AbstractValidator;
import com.imam.sp_checklist.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class JabatanValidator extends AbstractValidator<Jabatan> {

    @Override
    protected void doValidate(Jabatan data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Jabatan tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Id jabatan tidak boleh kosong");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama jabatan tidak boleh kosong");
        }
    }
}
