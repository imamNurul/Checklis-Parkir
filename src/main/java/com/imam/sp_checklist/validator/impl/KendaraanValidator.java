
package com.imam.sp_checklist.validator.impl;

import com.imam.sp_checklist.entity.master.Kendaraan;
import com.imam.sp_checklist.validator.AbstractValidator;
import com.imam.sp_checklist.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Imam
 */
@Component
public class KendaraanValidator extends AbstractValidator<Kendaraan> {

    @Override
    protected void doValidate(Kendaraan data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Kendaraan tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Nopol tidak boleh kosong");
        } else if (data.getId()==null) {
            throwValidatorException("Nopol tidak boleh kosong");
        } else if (data.getJenis().trim().isEmpty()) {
            throwValidatorException("Jenis Kendaraan tidak boleh kosong");
        }else if (data.getMerk()==null) {
            throwValidatorException("Merk tidak boleh kosong");
        }
    }
}
