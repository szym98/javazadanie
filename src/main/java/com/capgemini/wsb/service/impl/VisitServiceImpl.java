package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@Transactional
public class VisitServiceImpl implements VisitService
{
    private final VisitDao visitDao;

    @Autowired
    public VisitServiceImpl(VisitDao pVisitDao)
    {
        visitDao = pVisitDao;
    }

    @Override
    public VisitTO findById(Long id) {
        final VisitEntity entity = visitDao.findOne(id);
        return VisitMapper.mapToTO(entity);
    }

    @Override
    public List<VisitTO> findPatientVisits(Long idPatent) {
        final List<VisitEntity> entities = visitDao.findAll();
        List<VisitTO> visits = new ArrayList<>();

        for (VisitEntity visitEntity : entities) {
            if (Objects.equals(visitEntity.getPatient().getId(), idPatent)) {
                visits.add(VisitMapper.mapToTO(visitEntity));
            }
        }
        return visits.isEmpty() ? null : visits;


    }


}
