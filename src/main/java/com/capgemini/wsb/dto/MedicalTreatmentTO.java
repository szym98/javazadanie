package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.io.Serializable;
import java.util.List;

public class MedicalTreatmentTO implements Serializable
{
    private Long id;
    private String description;
    private TreatmentType type;
    private String addressLine2;
    private String postalCode;
    private VisitEntity visits;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public TreatmentType getType() { return type; }
    public void setType(TreatmentType type) { this.type = type; }
    public VisitEntity  getVisits() { return visits; }
    public void setVisits(VisitEntity  visits) { this.visits = visits; }
}
