
package com.imam.sp_checklist.entity.transaksi;

import com.imam.sp_checklist.entity.master.*;
import com.imam.sp_checklist.entity.AbstractTransactionEntity;
import com.imam.sp_checklist.widget.render.CeklisPengawasTableCellRenderer;
import com.imam.sp_checklist.widget.render.CeklisPetugasTableCellRenderer;
import com.imam.sp_checklist.widget.render.KaryawanTableCellRenderer;
import com.imam.sp_checklist.widget.render.TanggalTableCellRenderer;
import com.imam.sp_checklist.widget.render.TanggalTimeTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Imam
 */
@Entity
@Table(name = "tabel_ceklis")
public class Ceklis extends AbstractTransactionEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "Tgl_ceklis")
    @TableColumn(number = 1, name = "Tanggal Checklist", renderer = TanggalTableCellRenderer.class)
    private Date tglCeklis;
    
    @Column(name = "bulan")
    @TableColumn(number = 2, name = "Bulan Jadwal")
    private String bulan;
    
    @Column(name = "tahun")
    @TableColumn(number = 3, name = "Tahun Jadwal")
    private int tahun;
    
    @ManyToOne
    @JoinColumn(name = "id_jadwal")
    private Jadwal jadwal;
    
    
    @ManyToOne
    @JoinColumn(name = "id_pengawas", nullable = false)
    @TableColumn(number = 4, name = "Nama Pengawas", size = 25, renderer = KaryawanTableCellRenderer.class)
    private Karyawan pengawas;
    
    @ManyToOne
    @JoinColumn(name = "id_petugas", nullable = false)
    @TableColumn(number = 5, name = "Nama Petugas", size = 25, renderer = KaryawanTableCellRenderer.class)
    private Karyawan petugas;
    
    @ManyToOne
    @JoinColumn(name = "id_shift", nullable = false)
    @TableColumn(number = 6, name = "Shift", size = 20)
    private Shift shift;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_buat", nullable = true)
    @TableColumn(number = 7, name = "Tanggal Buat", renderer = TanggalTimeTableCellRenderer.class)
    private Date tglBuat;
    
    @Column(name = "buat_by", nullable = true)
    @TableColumn(number = 8, name = "Dibuat Oleh")
    private String buatBy;
    
    
    
    
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "ceklis")
    private List<CeklisDetail> daftarCeklis = new ArrayList<>();
    

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglCeklis() {
        return tglCeklis;
    }

    public void setTglCeklis(Date tglCeklis) {
        this.tglCeklis = tglCeklis;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public Karyawan getPengawas() {
        return pengawas;
    }

    public void setPengawas(Karyawan pengawas) {
        this.pengawas = pengawas;
    }

    public Karyawan getPetugas() {
        return petugas;
    }

    public void setPetugas(Karyawan petugas) {
        this.petugas = petugas;
    }

    
    
    

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Date getTglBuat() {
        return tglBuat;
    }

    public void setTglBuat(Date tglBuat) {
        this.tglBuat = tglBuat;
    }

    public String getBuatBy() {
        return buatBy;
    }

    public void setBuatBy(String buatBy) {
        this.buatBy = buatBy;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }
    
    


    public List<CeklisDetail> getDaftarCeklis() {
        return daftarCeklis;
    }

    public void setDaftarCeklis(List<CeklisDetail> daftarCeklis) {
        this.daftarCeklis = daftarCeklis;
    }
    
    public void tambahDaftarCeklis(CeklisDetail detail){
        detail.setCeklis(this);
        daftarCeklis.add(detail);
        
    }
    
    public void hapusDaftarCeklis(CeklisDetail detail){
        detail.setCeklis(null);
        daftarCeklis.remove(detail);
        
    }
    
    

    
}
