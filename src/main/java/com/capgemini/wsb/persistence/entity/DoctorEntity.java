package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;


	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;


	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;


	@Column(name = "TELEPHONE_NUMBER", nullable = false)
	private String telephoneNumber;

	@Column(name = "EMAIL")
	private String emails;


	@Column(name = "DOCTOR_NUMBER", nullable = false)
	private String doctorNumbers;


	@Column(name = "SPECIALIZATION", nullable = false)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	private List<VisitEntity> visits;

	@OneToOne
	@JoinColumn
	private AddressEntity address;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
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
		this.specialization = specialization;
	}

	public String getDoctorNumber() { return doctorNumbers;	}
	public void setDoctorNumber(String patientNumber) { this.doctorNumbers = patientNumber; }
	public String getEmail() { return this.emails; }
	public void setEmail(String emails) { this.emails = emails; }
	public String getTelephoneNumber() { return this.telephoneNumber; }
	public void setTelephoneNumber(String telephoneNumber) { this.telephoneNumber = telephoneNumber; }

	public List<VisitEntity> getVisits() {
		return visits;
	}
	public void setVisits(List<VisitEntity> visits) {
		this.visits = visits;
	}
	public AddressEntity getAddress() { return address;	}
	public void setAddress(AddressEntity address) {	this.address = address;	}
}