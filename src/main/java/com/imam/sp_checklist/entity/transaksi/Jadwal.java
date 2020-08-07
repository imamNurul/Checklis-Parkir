
package com.imam.sp_checklist.entity.transaksi;

import com.imam.sp_checklist.entity.master.*;
import com.imam.sp_checklist.entity.AbstractTransactionEntity;
import com.imam.sp_checklist.widget.render.KaryawanTableCellRenderer;
import com.imam.sp_checklist.widget.render.TanggalTableCellRenderer;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Imam
 */
@Entity
@Table(name = "tabel_jadwal")
public class Jadwal extends AbstractTransactionEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
  //  @TableColumn(number = 1, name = "Kode Jadwal", size = 15)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Tgl_jadwal")
    @TableColumn(number = 1, name = "Tanggal Buat", renderer = TanggalTableCellRenderer.class)
    private Date tglJadwal;

    
    @ManyToOne
    @JoinColumn(name = "id_pengawas", nullable = false)
    @TableColumn(number = 3, name = "Nama Pengawas", size = 20, renderer = KaryawanTableCellRenderer.class)
    private Karyawan pengawas;
    
    @ManyToOne
    @JoinColumn(name = "id_petugas", nullable = false)
    @TableColumn(number = 4, name = "Nama Petugas", size = 20, renderer = KaryawanTableCellRenderer.class)
    private Karyawan petugas;
    
    @Column(name = "bulan")
    @TableColumn(number = 5, name = "Bulan")
    private String bulan;
    
    @Column(name = "tahun")
    @TableColumn(number = 6, name = "Tahun")
    private int tahun;
    
    @Column(name = "flag")
    private boolean flag;
    
    @Column(name = "buat_by", nullable = true)
    @TableColumn(number = 8, name = "Dibuat Oleh")
    private String buatBy;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "jadwal")
    private List<JadwalDetail> daftarJadwal = new ArrayList<>();
    

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglJadwal() {
        return tglJadwal;
    }

    public void setTglJadwal(Date tglJadwal) {
        this.tglJadwal = tglJadwal;
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
    

    public List<JadwalDetail> getDaftarJadwal() {
        return daftarJadwal;
    }

    public void setDaftarJadwal(List<JadwalDetail> daftarJadwal) {
        this.daftarJadwal = daftarJadwal;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getBuatBy() {
        return buatBy;
    }

    public void setBuatBy(String buatBy) {
        this.buatBy = buatBy;
    }
    
    
    
    
    
    public void tambahDaftarJadwal(JadwalDetail jadwalDetail){
        jadwalDetail.setJadwal(this);
        daftarJadwal.add(jadwalDetail);
        
    }
    
    public void hapusDaftarJadwal(JadwalDetail jadwalDetail){
        jadwalDetail.setJadwal(null);
        daftarJadwal.remove(jadwalDetail);
        
    }
    
    

    
}
