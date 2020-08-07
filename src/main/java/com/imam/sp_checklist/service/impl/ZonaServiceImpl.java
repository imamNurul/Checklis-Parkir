
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.entity.master.Zona;
import com.imam.sp_checklist.service.AbstractService;
import com.imam.sp_checklist.service.ZonaService;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Imam
 */
@Service
public class ZonaServiceImpl extends AbstractService<Zona, String> implements ZonaService {

    public ZonaServiceImpl() {
        super(Zona.class);
    }

    @Override
    @Transactional
    public List<Zona> findByidbs(Basement basement) {
        return currentSession().createCriteria(Zona.class).
                add(Restrictions.eq("basement", basement)).list();
    }
}
