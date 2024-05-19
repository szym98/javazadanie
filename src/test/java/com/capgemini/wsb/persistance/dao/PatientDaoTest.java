package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        PatientEntity patientEntity = patientDao.findOne(1L);
        // then
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getFirstName()).isEqualTo("Marika");
        assertThat(patientEntity.getLastName()).isEqualTo("Fiodrowa");
        assertThat(patientEntity.getTelephoneNumber()).isEqualTo("122233311");
        assertThat(patientEntity.getEmail()).isEqualTo("marika@example.com");
        assertThat(patientEntity.getPatientNumber()).isEqualTo("P123");
        assertThat(patientEntity.getDateOfBirth()).isEqualTo(LocalDate.of(1975, 3, 14));
        assertThat(patientEntity.getField1()).isEqualTo("ABC");

    }

    @Test
    public void testShouldSavePatient() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("FirstName");
        patientEntity.setLastName("LastName");
        patientEntity.setTelephoneNumber("123456789");
        patientEntity.setEmail("example2@example.com");
        patientEntity.setPatientNumber("98765");
        patientEntity.setDateOfBirth(LocalDate.of(1970, 1, 1));
        patientEntity.setField1("Abc123");
        long entitiesNumBefore = patientDao.count();

        // when
        final PatientEntity saved = patientDao.save(patientEntity);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(patientDao.count()).isEqualTo(entitiesNumBefore+1);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemovePatient() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("FirstName");
        patientEntity.setLastName("LastName");
        patientEntity.setTelephoneNumber("123456789");
        patientEntity.setEmail("example2@example.com");
        patientEntity.setPatientNumber("98765");
        patientEntity.setDateOfBirth(LocalDate.of(1970, 1, 1));
        patientEntity.setField1("Abc123");

        // when
        final PatientEntity saved = patientDao.save(patientEntity);
        assertThat(saved.getId()).isNotNull();
        final PatientEntity newSaved = patientDao.findOne(saved.getId());
        assertThat(newSaved).isNotNull();

        patientDao.delete(saved.getId());

        // then
        final PatientEntity removed = patientDao.findOne(saved.getId());
        assertThat(removed).isNull();
    }


    @Test
    public void testFindByName() {
        final List<PatientEntity> patients = patientDao.findAll();
        String f;
        f = "No";
        for (PatientEntity patient : patients) {
            if (patient.getLastName().equalsIgnoreCase("Cichy")) {
                f = "Yes";
            }
        }
        assertThat(f.equals("Yes")).isTrue();
    }

    /*
    @Test
    public void testFindByPatientVisits() {
        final List<PatientEntity> entity = patientDao.findAll();
        String f;

        f = "No";
        for (PatientEntity patientEntity : entity) {
            if((long) patientEntity.getVisits().size() > 0) {
                f = "Yes";
            };
        }
        assertThat(f.equals("Yes")).isTrue();



        f = "No";
        for (PatientEntity patientEntity : entity) {
            if((long) patientEntity.getVisits().size() > 1) {
                f = "Yes";
            };
        }
        assertThat(f.equals("Yes")).isTrue();

        f = "No";
        for (PatientEntity patientEntity : entity) {
            if((long) patientEntity.getVisits().size() > 2) {
                f = "Yes";
            };
        }
        assertThat(f.equals("Yes")).isTrue();


        f = "No";
        for (PatientEntity patientEntity : entity) {
            if((long) patientEntity.getVisits().size() > 3) {
                f = "Yes";
            };
        }
        assertThat(f.equals("Yes")).isFalse();


    }
    */

    @Test
    public void testFindByfield1() {
        final List<PatientEntity> patients = patientDao.findAll();
        String f;
        f = "No";
        for (PatientEntity patient : patients) {
            if (patient.getField1().toLowerCase().contains("z")) {
                f = "Yes";
            }
        }
        assertThat(f.equals("Yes")).isTrue();
    }



}
