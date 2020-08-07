
package com.imam.sp_checklist.entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @param <T> id
 * @author Imam
 */
@MappedSuperclass
public abstract class AbstractEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "buatBy", nullable = false)
    private String buatBy;
    
    @Column(name = "waktu_dibuat", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuDibuat;

    @Column(name = "ubahBy", nullable = false)
    private String ubahBy;
    @Column(name = "waktu_ubah", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuUbah;

    @Lob
    @Column(name = "info")
    @TableColumn(number = 100, name = "Keterangan", size = 30)
    private String info;

    public abstract T getId();

    public abstract void setId(T id);

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @SuppressWarnings("ReturnOfDateField")
    public Date getWaktuUbah() {
        return waktuUbah;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setWaktuUbah(Date waktuUbah) {
        this.waktuUbah = waktuUbah;
    }

    @SuppressWarnings("ReturnOfDateField")
    public Date getWaktuDibuat() {
        return waktuDibuat;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setWaktuDibuat(Date waktuDibuat) {
        this.waktuDibuat = waktuDibuat;
    }
    @SuppressWarnings("ReturnOfStringField")
    public String getBuatBy() {
        return buatBy;
    }
    @SuppressWarnings("AssignmentToStringFieldFromParameter")
    public void setBuatBy(String buatBy) {
        this.buatBy = buatBy;
    }
    @SuppressWarnings("ReturnOfStringField")
    public String getUbahBy() {
        return ubahBy;
    }
    @SuppressWarnings("AssignmentToStringFieldFromParameter")
    public void setUbahBy(String ubahBy) {
        this.ubahBy = ubahBy;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        final AbstractEntity<T> other = (AbstractEntity<T>) obj;
        if (this.getId() != other.getId() && (this.getId() == null
                || !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }
}
