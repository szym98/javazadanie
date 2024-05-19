package com.capgemini.wsb.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 20)
	private Long id;


	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;


	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;


	@Column(name = "TELEPHONE_NUMBER", nullable = false)
	private String telephoneNumber;

	@Column(name = "EMAIL")
	private String email;


	@Column(name = "PATIENT_NUMBER", nullable = false)
	private String patientNumber;

	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private LocalDate dateOfBirth;

	@OneToMany(mappedBy = "patient")
	@JsonIgnore
	private List<VisitEntity> visits;

	@OneToOne
	@JoinColumn
	private AddressEntity address;
	// dodana kulumna
	private String field1;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	public String getTelephoneNumber() { return this.telephoneNumber; }
	public void setTelephoneNumber(String telephoneNumber) { this.telephoneNumber = telephoneNumber; }
	public String getEmail() { return this.email; }
	public void setEmail(String email) { this.email = email; }
	public String getPatientNumber() { return patientNumber; }
	public void setPatientNumber(String patientNumber) { this.patientNumber = patientNumber; }
	public LocalDate getDateOfBirth() {	return dateOfBirth;	}
	public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

	public List<VisitEntity> getVisits() { return visits; }
	public void setVisits(List<VisitEntity> visits) { this.visits = visits;	}

	public AddressEntity getAddress() { return address; }
	public void setAddress(AddressEntity address) {	this.address = address;	}
	public String getField1() { return field1; }
	public void setField1(String field1) { this.field1 = field1; }

}