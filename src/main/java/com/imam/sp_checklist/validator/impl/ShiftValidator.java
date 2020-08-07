
package com.imam.sp_checklist.validator.impl;

import com.imam.sp_checklist.entity.master.Shift;
import com.imam.sp_checklist.validator.AbstractValidator;
import com.imam.sp_checklist.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Imam
 */
@Component
public class ShiftValidator extends AbstractValidator<Shift> {

    @Override
    protected void doValidate(Shift data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Shift tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Kode tidak boleh kosong");
        } else if (data.getId()==null) {
            throwValidatorException("Kode tidak boleh kosong");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama tidak boleh kosong");
        }else if (data.getNama()==null) {
            throwValidatorException("Nama tidak boleh kosong");
        }else if (data.getJamMulai()==null) {
            throwValidatorException("Jam Mulai tidak boleh kosong");
        }else if (data.getJamSelesai()==null) {
            throwValidatorException("Jam Selesai tidak boleh kosong");
        }
    }
}
