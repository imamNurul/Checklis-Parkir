
package com.imam.sp_checklist.entity.user_akses;

import com.imam.sp_checklist.entity.AbstractEntity;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Imam
 */
@Entity
@Table(name = "tabel_hak_akses")
public class HakAkses extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @ManyToMany(mappedBy = "daftarHakAkses")
    private List<Grup> daftarGrup;

    public List<Grup> getDaftarGrup() {
        return Collections.unmodifiableList(daftarGrup);
    }

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

    @Override
    public String toString() {
        return getId()+" - "+getNama();
    }
}
