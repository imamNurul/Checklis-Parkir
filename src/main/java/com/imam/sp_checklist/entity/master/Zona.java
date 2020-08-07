
package com.imam.sp_checklist.entity.master;

import com.imam.sp_checklist.entity.AbstractEntity;
import com.imam.sp_checklist.widget.render.BasementTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Imam
 */
@Entity
@Table(name = "tabel_zona")
public class Zona extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @TableColumn(number = 1, name = "Kode Zona", size = 15)
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    @TableColumn(number = 2, name = "Nama Zona", size = 20)
    private String nama;
    
    @ManyToOne
    @JoinColumn(name = "id_basement", nullable = false)
    @TableColumn(number = 3, name = "Basement", size = 15, renderer = BasementTableCellRenderer.class)
    private Basement basement;
    

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

    public Basement getBasement() {
        return basement;
    }

    public void setBasement(Basement basement) {
        this.basement = basement;
    }


    @Override
    public String toString() {
        return getNama()+" - "+getBasement().getNama();
    }
}
