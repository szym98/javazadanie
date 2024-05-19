package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController
{

    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient/{id}")
    PatientTO findBaId(@PathVariable final Long id) {
        final PatientTO patient = patientService.findById(id);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient-name/{name}")
    List<PatientTO> findByName(@PathVariable final String name) {
        final List<PatientTO> patient = patientService.findByName(name);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(0L);
    }

    @GetMapping("/patient-more-visits/{x}")
    List<PatientTO> findByMoreVisits(@PathVariable final Long x) {
        final List<PatientTO> patient = patientService.findByPatientVisits(x);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(0L);
    }

    @GetMapping("/patient-field/{field1}")
    List<PatientTO> findByField1(@PathVariable final String field1) {
        final List<PatientTO> patient = patientService.findByField1(field1);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(0L);
    }


}
