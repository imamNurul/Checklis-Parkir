/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.entity.transaksi;

import com.imam.sp_checklist.entity.AbstractAutoIdEntity;
import com.imam.sp_checklist.entity.AbstractTransactionEntity;
import com.imam.sp_checklist.entity.master.Kendaraan;
import com.imam.sp_checklist.entity.master.Lot;
import com.imam.sp_checklist.widget.render.TimeCellRendererTable;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Imam-pc
 */
@Entity
@Table(name = "tabel_ceklis_detail")
public class CeklisDetail extends AbstractAutoIdEntity{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "jam")
    @TableColumn(number = 1, name = "Jam", size = 10, renderer = TimeCellRendererTable.class)
    private Time jam;
    
    @ManyToOne
    @JoinColumn(name = "id_kendaraan", nullable = false)
    @TableColumn(number = 2, name = "Nopol", size = 15)
    private Kendaraan kendaraan;
    
    @ManyToOne
    @JoinColumn(name = "id_lot", nullable = false)
    @TableColumn(number = 3, name = "Area Parkir", size = 30,editable = true)
    private Lot areaParkir;
    
    @Column(name = "dop_dpn_kanan")
    @TableColumn(number = 4, name = "Dop Dpn knn", size = 15, editable = true)
    private String dopDpnKanan;
    
    @Column(name = "dop_dpn_kiri")
    @TableColumn(number = 5, name = "Dop Dpn kiri", size = 15, editable = true)
    private String dopDpnKiri;
    
    @Column(name = "dop_blk_kanan")
    @TableColumn(number = 6, name = "Dop Blk knn", size = 15, editable = true)
    private String dopBlkKanan;
    
    @Column(name = "dop_blk_kiri")
    @TableColumn(number = 7, name = "Dop Blk kiri", size = 15, editable = true)
    private String dopBlkKiri;
    
    @Column(name = "spion_kanan")
    @TableColumn(number = 8, name = "Spion Kanan", size = 15, editable = true)
    private String spionKanan;
    
    @Column(name = "spion_kiri")
    @TableColumn(number = 9, name = "Spion Kiri", size = 15, editable = true)
    private String spionKiri;
    
    @Column(name = "kondisi_baret")
    @TableColumn(number = 10, name = "Kondisi Baret", size = 15, editable = true)
    private String kdsBaret;
    
    @Column(name = "kondisi_penyok")
    @TableColumn(number = 11, name = "Kondisi Penyok", size = 15, editable = true)
    private String kdsPenyok;
    
    @Column(name = "kaca_tutup")
    @TableColumn(number = 12, name = "Kaca Tertutup", size = 15, editable = true)
    private String kacaTutup;
    
    @Column(name = "cek_plat")
    @TableColumn(number = 13, name = "Check Plat", size = 15, editable = true)
    private String cekPlat;
    
    @Column(name = "keterangan")
    @TableColumn(number = 14, name = "Keterangan", size = 20, editable = true)
    private String ket;
    
    @ManyToOne
    @JoinColumn(name = "id_ceklis")
    private Ceklis ceklis;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Time getJam() {
        return jam;
    }

    public void setJam(Time jam) {
        this.jam = jam;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public Lot getAreaParkir() {
        return areaParkir;
    }

    public void setAreaParkir(Lot areaParkir) {
        this.areaParkir = areaParkir;
    }
    
    

    public String getDopDpnKanan() {
        return dopDpnKanan;
    }

    public void setDopDpnKanan(String dopDpnKanan) {
        this.dopDpnKanan = dopDpnKanan;
    }

    public String getDopDpnKiri() {
        return dopDpnKiri;
    }

    public void setDopDpnKiri(String dopDpnKiri) {
        this.dopDpnKiri = dopDpnKiri;
    }

    public String getDopBlkKanan() {
        return dopBlkKanan;
    }

    public void setDopBlkKanan(String dopBlkKanan) {
        this.dopBlkKanan = dopBlkKanan;
    }

    public String getDopBlkKiri() {
        return dopBlkKiri;
    }

    public void setDopBlkKiri(String dopBlkKiri) {
        this.dopBlkKiri = dopBlkKiri;
    }

    public String getSpionKanan() {
        return spionKanan;
    }

    public void setSpionKanan(String spionKanan) {
        this.spionKanan = spionKanan;
    }

    public String getSpionKiri() {
        return spionKiri;
    }

    public void setSpionKiri(String spionKiri) {
        this.spionKiri = spionKiri;
    }

    public String getKdsBaret() {
        return kdsBaret;
    }

    public void setKdsBaret(String kdsBaret) {
        this.kdsBaret = kdsBaret;
    }

    public String getKdsPenyok() {
        return kdsPenyok;
    }

    public void setKdsPenyok(String kdsPenyok) {
        this.kdsPenyok = kdsPenyok;
    }

    public String getKacaTutup() {
        return kacaTutup;
    }

    public void setKacaTutup(String kacaTutup) {
        this.kacaTutup = kacaTutup;
    }

    public String getCekPlat() {
        return cekPlat;
    }

    public void setCekPlat(String cekPlat) {
        this.cekPlat = cekPlat;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public Ceklis getCeklis() {
        return ceklis;
    }

    public void setCeklis(Ceklis ceklis) {
        this.ceklis = ceklis;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.jam);
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
        final CeklisDetail other = (CeklisDetail) obj;
        if (!Objects.equals(this.jam, other.jam)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
