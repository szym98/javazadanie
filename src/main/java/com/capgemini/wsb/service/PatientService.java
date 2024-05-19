package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;

import java.util.List;

public interface PatientService
{
    public PatientTO findById(final Long id);

    public List<PatientTO> findByName(final String name);
    public List<PatientTO> findByPatientVisits(final Long x);
    public List<PatientTO> findByField1(final String field1);
}
