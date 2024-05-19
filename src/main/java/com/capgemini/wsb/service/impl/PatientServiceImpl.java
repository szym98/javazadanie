package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao)
    {
        patientDao = pPatientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public List<PatientTO> findByName(String name) {
        List<PatientTO> patients = new ArrayList<>();
        final List<PatientEntity> entity = patientDao.findAll();
        for (PatientEntity patientEntity : entity) {
            if(patientEntity.getLastName().equalsIgnoreCase(name)) {
                patients.add(PatientMapper.mapToTO(patientEntity));
            };
        }
        return patients.isEmpty() ? null : patients;

    }

    @Override
    public List<PatientTO> findByPatientVisits(Long x) {
        List<PatientTO> patients = new ArrayList<>();
        final List<PatientEntity> entity = patientDao.findAll();
        for (PatientEntity patientEntity : entity) {
            if((long) patientEntity.getVisits().size() > x) {
                patients.add(PatientMapper.mapToTO(patientEntity));
            };
        }
        return patients.isEmpty() ? null : patients;
    }

    // zawiera
    @Override
    public List<PatientTO> findByField1(String field1) {
        List<PatientTO> patients = new ArrayList<>();
        final List<PatientEntity> entity = patientDao.findAll();
        for (PatientEntity patientEntity : entity) {
            if(patientEntity.getField1().toLowerCase().contains(field1.toLowerCase())) {
                patients.add(PatientMapper.mapToTO(patientEntity));
            };
        }
        return patients.isEmpty() ? null : patients;
    }


}
