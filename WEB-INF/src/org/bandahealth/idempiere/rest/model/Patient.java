package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "patient")
@JsonInclude(value = Include.NON_NULL)
public class Patient extends BusinessPartner {

	private static final long serialVersionUID = 1L;

	private String patientNumber;
	private String dateOfBirth;
	private String phone;
	private String address;
	private String gender;
	private String email;
	private String nhifRelationship;
	private String nhifMemberName;
	private String nhifNumber;
	private String nhifType;
	private String nationalId;
	private String occupation;
	private String nextOfKinName;
	private String nextOfKinContact;

	public Patient() {
	}

	public Patient(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
			String description, BigDecimal totalOpenBalance, String patientNumber, String dateOfBirth, String phone,
			String address, String gender, String email, String nhifRelationship, String nhifMemberName,
			String nhifNumber, String nhifType, String nationalId, String occupation, String nextOfKinName,
			String nextOfKinContact) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description, totalOpenBalance);

		this.patientNumber = patientNumber;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.nhifRelationship = nhifRelationship;
		this.nhifMemberName = nhifMemberName;
		this.nhifNumber = nhifNumber;
		this.nhifType = nhifType;
		this.nationalId = nationalId;
		this.occupation = occupation;
		this.nextOfKinName = nextOfKinName;
		this.nextOfKinContact = nextOfKinContact;
	}

	public Patient(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
			String description, BigDecimal totalOpenBalance, String patientNumber) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description, totalOpenBalance);

		this.patientNumber = patientNumber;
	}

	public Patient(String uuid, String name, BigDecimal totalOpenBalance, String patientNumber, String dateOfBirth,
			String phone, String address) {
		setUuid(uuid);
		setName(name);
		setTotalOpenBalance(totalOpenBalance);

		String description = name;
		if (patientNumber != null) {
			description += ", patient #:" + patientNumber;
		}

		if (dateOfBirth != null) {
			description += ", date of birth:" + dateOfBirth;
		}

		if (phone != null) {
			description += ", phone:" + phone;
		}

		if (address != null) {
			description += ", address:" + address;
		}

		setDescription(description);

		this.patientNumber = patientNumber;
	}

	@XmlElement
	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	@XmlElement
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@XmlElement
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement
	public String getNhifRelationship() {
		return nhifRelationship;
	}

	public void setNhifRelationship(String nhifRelationship) {
		this.nhifRelationship = nhifRelationship;
	}

	@XmlElement
	public String getNhifMemberName() {
		return nhifMemberName;
	}

	public void setNhifMemberName(String nhifMemberName) {
		this.nhifMemberName = nhifMemberName;
	}

	@XmlElement
	public String getNhifNumber() {
		return nhifNumber;
	}

	public void setNhifNumber(String nhifNumber) {
		this.nhifNumber = nhifNumber;
	}

	@XmlElement
	public String getNhifType() {
		return nhifType;
	}

	public void setNhifType(String nhifType) {
		this.nhifType = nhifType;
	}

	@XmlElement
	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	@XmlElement
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@XmlElement
	public String getNextOfKinName() {
		return nextOfKinName;
	}

	public void setNextOfKinName(String nextOfKinName) {
		this.nextOfKinName = nextOfKinName;
	}

	@XmlElement
	public String getNextOfKinContact() {
		return nextOfKinContact;
	}

	public void setNextOfKinContact(String nextOfKinContact) {
		this.nextOfKinContact = nextOfKinContact;
	}

}