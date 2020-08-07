
package com.imam.sp_checklist.entity.transaksi;

import com.imam.sp_checklist.entity.AbstractAutoIdEntity;
import com.imam.sp_checklist.entity.master.*;
import com.imam.sp_checklist.widget.render.ShiftTableCellRenderer;
import com.imam.sp_checklist.widget.render.TanggalJadwalTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Imam
 */
@Entity
@Table(name = "tabel_jadwal_detail")
public class JadwalDetail extends AbstractAutoIdEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_shift", nullable = true)
    @TableColumn(number = 2, name = "Shift", size = 15, renderer = ShiftTableCellRenderer.class)
    private Shift shift;
//
//    @ManyToOne
//    @JoinColumn(name = "id_lot", nullable = false)
//    @TableColumn(number = 2, name = "Nama Lot", size = 20, renderer = KaryawanTableCellRenderer.class)
//    private Lot lot;
    
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tabel_join_jadwalDetail_dan_lot", joinColumns =
    @JoinColumn(name = "id_jadwalDetail", nullable = true), inverseJoinColumns =
    @JoinColumn(name = "id_lot", nullable = true))
    @TableColumn(number = 3, name = "Area Plot", size = 100)
    private List<Lot> daftarLot = new ArrayList<>(0);
    
    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_detail")
    @TableColumn(number = 1,size = 25, name = "Hari, Tanggal Bulan", renderer = TanggalJadwalTableCellRenderer.class)
    private Date tglDetail;
    
    @Column(name = "keterangan")
    @TableColumn(number = 4, name = "Keterangan")
    private String keterangan;
    
    @ManyToOne
    @JoinColumn(name = "id_jadwal")
    private Jadwal jadwal;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }


    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Date getTglDetail() {
        return tglDetail;
    }

    public void setTglDetail(Date tglDetail) {
        this.tglDetail = tglDetail;
    }


    

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    public Jadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }
    
    
     public void tambahJadwalLot(Lot lot) {
        if (!daftarLot.contains(lot)) {
            
            daftarLot.add(lot);
        }
    }

    public void hapusJadwalLot(Lot lot) {
        if (daftarLot.contains(lot)) {
            daftarLot.remove(lot);
        }
    }


    public void hapusSemuaJadwalLot() {
        daftarLot.clear();
    }

    public List<Lot> getDaftarJadwalLot() {
        return Collections.unmodifiableList(daftarLot);
    }
    
    
    
    
    

}
