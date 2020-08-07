
package com.imam.sp_checklist.entity.master;

import com.imam.sp_checklist.entity.AbstractEntity;
import com.imam.sp_checklist.widget.render.JabatanPengawasTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_jabatan")
public class Jabatan extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @TableColumn(number = 1, name = "Kode", size = 15)
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    @TableColumn(number = 2, name = "Nama", size = 20)
    private String nama;
    
    @Column(name = "pengawas", nullable = false, length = 100)
    @TableColumn(number = 2, name = "Pengawas", size = 20, renderer = JabatanPengawasTableCellRenderer.class)
    private boolean pengawas;

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

    public boolean isPengawas() {
        return pengawas;
    }

    public void setPengawas(boolean pengawas) {
        this.pengawas = pengawas;
    }
    
    

    @Override
    public String toString() {
        return getId() + " - " + getNama();
    }
}
