
package com.imam.sp_checklist.entity.master;

import com.imam.sp_checklist.entity.AbstractEntity;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.widget.render.JabatanTableCellRenderer;
import com.imam.sp_checklist.widget.render.TanggalTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ImamNH
 */
@Entity
@Table(name = "tabel_karyawan")
public class Karyawan extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @TableColumn(number = 1, name = "Kode")
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    @TableColumn(number = 2, name = "Nama", size = 20)
    private String nama;
    
    @Column(name = "tmpt_lahir", nullable = false, length = 100)
    @TableColumn(number = 3, name = "Tempat Lahir", size = 25)
    private String tmpt_lahir;

    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    @TableColumn(number = 4, name = "Tanggal Lahir", renderer = TanggalTableCellRenderer.class)
    private Date tanggalLahir;

    @ManyToOne
    @JoinColumn(name = "id_jabatan", nullable = false)
    @TableColumn(number = 5, name = "Jabatan", renderer = JabatanTableCellRenderer.class)
    private Jabatan jabatan;
    
    @Column(name = "jekel", length = 1)
    @TableColumn(number = 6, name = "P/L")
    private String jekel;

    @Column(name = "telepon", length = 20)
    @TableColumn(number = 7, name = "Telepon")
    private String telepon;

    @Column(name = "alamat", length = 500)
    @TableColumn(number = 8, name = "Alamat", size = 30)
    private String alamat;

    @OneToOne(mappedBy = "karyawan")
    private Pengguna pengguna;
    
    @Column(name = "photo", length = 500, nullable = true)
    private String photo;
    
    @Column(name = "flag", length = 1)
    private boolean flag;

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @SuppressWarnings("ReturnOfDateField")
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getTmpt_lahir() {
        return tmpt_lahir;
    }

    public void setTmpt_lahir(String tmpt_lahir) {
        this.tmpt_lahir = tmpt_lahir;
    }

    public String getJekel() {
        return jekel;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return getNama()+"-"+getJabatan().getNama();
    }
    
    
    
    
    
}
