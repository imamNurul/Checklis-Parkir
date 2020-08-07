/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.entity.user_akses;

/**
 *
 * @author echo
 */
public enum HakAksesConstant {

    JADWAL_SELESAI("Jadwal Selesai"),
    LIHAT_MASTER("Lihat Master"),
    LIHAT_HAKAKSES("Lihat Hak Akses"),
    LIHAT_TRANSAKSI("Lihat Transaksi"),
    LIHAT_LAPORAN("Lihat Laporan"),
    LIHAT_KENDARAAN("Lihat Kendaraan"),
    TAMBAH_KENDARAAN("Tambah Kendaraan"),
    UBAH_KENDARAAN("Ubah Kendaraan"),
    HAPUS_KENDARAAN("Hapus Kendaraan"),
    LIHAT_LOT("Lihat Lot"),
    TAMBAH_LOT("Tambah Lot"),
    UBAH_LOT("Ubah Lot"),
    HAPUS_LOT("Hapus Lot"),
    LIHAT_BASEMENT("Lihat Basement"),
    TAMBAH_BASEMENT("Tambah Basement"),
    UBAH_BASEMENT("Ubah Basement"),
    HAPUS_BASEMENT("Hapus Basement"),
    LIHAT_ZONA("Lihat Zona"),
    TAMBAH_ZONA("Tambah Zona"),
    UBAH_ZONA("Ubah Zona"),
    HAPUS_ZONA("Hapus Zona"),
    LIHAT_JABATAN("Lihat Jabatan"),
    TAMBAH_JABATAN("Tambah Jabatan"),
    UBAH_JABATAN("Ubah Jabatan"),
    HAPUS_JABATAN("Hapus Jabatan"),
    LIHAT_KARYAWAN("Lihat Karyawan"),
    TAMBAH_KARYAWAN("Tambah Karyawan"),
    UBAH_KARYAWAN("Ubah Karyawan"),
    HAPUS_KARYAWAN("Hapus Karyawan"),
    LIHAT_GRUP("Lihat Grup"),
    TAMBAH_GRUP("Tambah Grup"),
    UBAH_GRUP("Ubah Grup"),
    HAPUS_GRUP("Hapus Grup"),
    LIHAT_PENGGUNA("Lihat Pengguna"),
    TAMBAH_PENGGUNA("Tambah Pengguna"),
    UBAH_PENGGUNA("Ubah Pengguna"),
    HAPUS_PENGGUNA("Hapus Pengguna"),
    TAMBAH_SHIFT("Tambah Shift"),
    UBAH_SHIFT("Ubah Shift"),
    HAPUS_SHIFT("Hapus Shift"),
    DETAIL_JADWAL("Detail Jadwal"),
    DETAIL_CEKLIS("Detail Checklist"),
    UBAH_JADWAL("Ubah Jadwal"),
    TAMBAH_JADWAL("Tambah Jadwal"),
    HAPUS_JADWAL("Hapus Jadwal"),
    
    LIHAT_FORM_CEKLIS("Lihat Form Ceklis"),
    TAMBAH_FORM_CEKLIS("Tambah Form Ceklis"),
    UBAH_FORM_CEKLIS("Tambah Form Ceklis"),
    HAPUS_FORM_CEKLIS("Tambah Form Ceklis"),
    LIHAT_LAPORAN_MASTER("Lihat Laporan Basement"),
    LIHAT_LAPORAN_HAK_AKSES("Lihat Laporan Zona"),
    LIHAT_LAPORAN_TRANSAKSI("Lihat Laporan Lot");
    
    private String nama;

    private HakAksesConstant(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}
