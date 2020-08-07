
package com.imam.sp_checklist.validator.impl;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.validator.AbstractValidator;
import com.imam.sp_checklist.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Imam
 */
@Component
public class BasementValidator extends AbstractValidator<Basement> {

    @Override
    protected void doValidate(Basement data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Basement tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Kode tidak boleh kosong");
        } else if (data.getId()==null) {
            throwValidatorException("Kode tidak boleh kosong");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama tidak boleh kosong");
        }else if (data.getNama()==null) {
            throwValidatorException("Nama tidak boleh kosong");
        }
    }
}
