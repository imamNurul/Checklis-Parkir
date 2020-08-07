/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.imam.sp_checklist.validator;

import com.imam.sp_checklist.entity.AbstractEntity;

/**
 *
 * @param <T> data
 * @author Eko Kurniawan Khannedy
 */
public abstract class AbstractValidator<T> implements Validator<T> {

    protected void throwValidatorException(String message) throws ValidatorException {
        throw new ValidatorException(message);
    }

    public void validate(T data) throws ValidatorException {

        doValidate(data);

        if (data instanceof AbstractEntity<?>) {
            AbstractEntity<?> entity = (AbstractEntity<?>) data;
            validateEntity(entity);
        }
    }

    protected void validateEntity(AbstractEntity<?> entity) throws ValidatorException {
        if (entity.getWaktuDibuat() == null) {
            throwValidatorException("Waktu dibuat tidak boleh null");
        } else if (entity.getBuatBy() == null) {
            throwValidatorException("Dibuat oleh tidak boleh null");
        }else if (entity.getUbahBy()== null) {
            throwValidatorException("Diubah oleh tidak boleh null");
        }else if (entity.getWaktuUbah() == null) {
            throwValidatorException("Waktu ubah oleh tidak boleh null");
        }
    }

    protected abstract void doValidate(T data) throws ValidatorException;
}
