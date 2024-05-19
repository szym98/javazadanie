package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.VisitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitController
{

    private final VisitService visitService;


    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/visit/{id}")
    VisitTO findBaId(@PathVariable final Long id) {
        final VisitTO visit = visitService.findById(id);
        if(visit != null)
        {
            return visit;
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient-visits/{idPatent}")
    List<VisitTO> findPatientVisits(@PathVariable final Long idPatent) {
        final List<VisitTO> patient = visitService.findPatientVisits(idPatent);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(idPatent);
    }

}
