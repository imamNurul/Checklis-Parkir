
package com.imam.sp_checklist.service.impl;

import com.imam.sp_checklist.entity.master.Lot;
import com.imam.sp_checklist.entity.master.Zona;
import com.imam.sp_checklist.service.AbstractService;
import com.imam.sp_checklist.service.LotService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Imam
 */
@Service
public class LotServiceImpl extends AbstractService<Lot, String> implements LotService {

    public LotServiceImpl() {
        super(Lot.class);
    }

    @Override
    @Transactional
    public List<Lot> findByidZona(Zona zona) {
        return currentSession().createCriteria(Lot.class).
                add(Restrictions.eq("zona", zona)).list();
    }
}
