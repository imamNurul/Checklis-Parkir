
package com.imam.sp_checklist.entity.user_akses;

import com.imam.sp_checklist.entity.AbstractEntity;
import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.widget.render.GrupTableCellRenderer;
import com.imam.sp_checklist.widget.render.KaryawanTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author ImamNH
 */
@Entity
@Table(name = "tabel_pengguna")
public class Pengguna extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @TableColumn(number = 1, name = "Kode Karyawan")
    private String id;

    @Column(name = "kata_sandi")
    private String kataSandi;

    @Column(name = "aktif", nullable = false)
    private boolean aktif;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    @TableColumn(number = 2, name = "Nama Karyawan", size = 20, renderer = KaryawanTableCellRenderer.class)
    private Karyawan karyawan;

    @ManyToOne
    @JoinColumn(name = "id_grup", nullable = false)
    @TableColumn(number = 3, name = "Grup", renderer = GrupTableCellRenderer.class)
    private Grup grup;

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    public Grup getGrup() {
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public String getKataSandi() {
        return kataSandi;
    }

    public void setKataSandi(String kataSandi) {
        this.kataSandi = kataSandi;
    }

    @Override
    public String toString() {
        return getKaryawan().getNama();
    }
}
