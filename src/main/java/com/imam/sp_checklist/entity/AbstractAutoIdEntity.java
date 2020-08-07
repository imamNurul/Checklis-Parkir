
package com.imam.sp_checklist.entity;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Imam
 */
@MappedSuperclass
public abstract class AbstractAutoIdEntity implements Serializable {

    public abstract Long getId();

    public abstract void setId(Long id);

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractAutoIdEntity other = (AbstractAutoIdEntity) obj;
        if (this.getId() != other.getId() && (this.getId() == null
                || !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }
}
