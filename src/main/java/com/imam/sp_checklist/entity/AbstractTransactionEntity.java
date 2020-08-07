
package com.imam.sp_checklist.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Imam
 */
@MappedSuperclass
public abstract class AbstractTransactionEntity extends AbstractAutoIdEntity {

    private static final long serialVersionUID = 1L;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "waktu_transaksi_diubah")
    private Date waktuTransaksiDiubah;
    
    @Column(name = "ubah_by")
    private String ubahBy;

    @SuppressWarnings("ReturnOfDateField")
    public Date getWaktuTransaksiDiubah() {
        return waktuTransaksiDiubah;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setWaktuTransaksiDiubah(Date waktuTransaksiDiubah) {
        this.waktuTransaksiDiubah = waktuTransaksiDiubah;
    }

    public String getUbahBy() {
        return ubahBy;
    }

    public void setUbahBy(String ubahBy) {
        this.ubahBy = ubahBy;
    }
    
    
    
}
