
package com.imam.sp_checklist.entity.master;

import com.imam.sp_checklist.entity.AbstractEntity;
import com.imam.sp_checklist.widget.render.TimeCellRendererTable;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Imam
 */
@Entity
@Table(name = "tabel_shift")
public class Shift extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @TableColumn(number = 1, name = "Kode Shift", size = 15)
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    @TableColumn(number = 2, name = "Nama Shift", size = 20)
    private String nama;
    
    @Column(name = "jam_mulai")
    @TableColumn(number = 3, name = "Jam Mulai", size = 15, renderer = TimeCellRendererTable.class)
    private Time jamMulai;
    
    @Column(name = "jam_selesai")
    @TableColumn(number = 3, name = "Jam Selesai", size = 15, renderer = TimeCellRendererTable.class)
    private Time jamSelesai;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Time getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(Time jamMulai) {
        this.jamMulai = jamMulai;
    }

    public Time getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(Time jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.jamMulai);
        hash = 13 * hash + Objects.hashCode(this.jamSelesai);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Shift other = (Shift) obj;
        if (!Objects.equals(this.jamMulai, other.jamMulai)) {
            return false;
        }
        if (!Objects.equals(this.jamSelesai, other.jamSelesai)) {
            return false;
        }
        return true;
    }

   

    

    @Override
    public String toString() {
        return getNama();
    }
}
