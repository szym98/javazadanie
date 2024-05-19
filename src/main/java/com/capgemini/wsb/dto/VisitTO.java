package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable
{
    private Long id;
    private String description;
    private LocalDateTime time;
    private DoctorEntity doctor;;
    private PatientEntity patient;
    private List<MedicalTreatmentEntity> medicalTreatmentEntityList;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }
    public List<MedicalTreatmentEntity> getMedicalTreatmentEntityList() { return this.medicalTreatmentEntityList; }
    public void setMedicalTreatmentEntityList(List<MedicalTreatmentEntity> medicalTreatmentEntityList) { this.medicalTreatmentEntityList = medicalTreatmentEntityList; }
    public DoctorEntity getDoctor() { return doctor; }
    public void setDoctor(DoctorEntity doctor) { this.doctor = doctor; }
    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }
}
