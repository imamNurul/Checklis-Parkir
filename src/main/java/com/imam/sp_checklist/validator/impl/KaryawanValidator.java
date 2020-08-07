
package com.imam.sp_checklist.validator.impl;

import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.validator.AbstractValidator;
import com.imam.sp_checklist.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Imam
 */
@Component
public class KaryawanValidator extends AbstractValidator<Karyawan> {

    @Override
    protected void doValidate(Karyawan data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Karyawan tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Id karyawan tidak boleh kosong");
        } else if (data.getId()== null) {
            throwValidatorException("Id karyawan tidak boleh kosong");
        }else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama karyawan tida boleh kosong");
        } else if (data.getNama() == null) {
            throwValidatorException("Nama karyawan tida boleh kosong");
        }else if (data.getJabatan() == null) {
            throwValidatorException("Jabatan karyawan tidak boleh null");
        } else if (data.getTmpt_lahir().trim().isEmpty()) {
            throwValidatorException("Tempat Lahir karyawan tidak boleh null");
        }else if (data.getTmpt_lahir()==null) {
            throwValidatorException("Tempat Lahir karyawan tidak boleh null");
        }else if (data.getTanggalLahir() == null) {
            throwValidatorException("Tanggal Lahir karyawan tidak boleh null");
        }else if (data.getAlamat()== null) {
            throwValidatorException("Alamat karyawan tidak boleh null");
        }else if (data.getTelepon().trim().isEmpty()) {
            throwValidatorException("No HP tidak boleh null");
        }else if (data.getTelepon()==null) {
            throwValidatorException("No HP tidak boleh null");
        }
    }
}
