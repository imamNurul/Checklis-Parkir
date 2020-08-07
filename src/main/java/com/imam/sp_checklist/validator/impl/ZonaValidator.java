
package com.imam.sp_checklist.validator.impl;

import com.imam.sp_checklist.entity.master.Zona;
import com.imam.sp_checklist.validator.AbstractValidator;
import com.imam.sp_checklist.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Imam
 */
@Component
public class ZonaValidator extends AbstractValidator<Zona> {

    @Override
    protected void doValidate(Zona data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Zona tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Kode tidak boleh kosong");
        } else if (data.getId()==null) {
            throwValidatorException("Kode tidak boleh kosong");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama tidak boleh kosong");
        }else if (data.getNama()==null) {
            throwValidatorException("Nama tidak boleh kosong");
        }else if (data.getBasement()==null) {
            throwValidatorException("Basement tidak boleh kosong");
        }
    }
}
