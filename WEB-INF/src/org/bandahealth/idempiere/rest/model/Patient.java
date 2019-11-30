package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patient")
public class Patient extends BusinessPartner {

	private static final long serialVersionUID = 1L;

	private String patientNumber;
	private String dateOfBirth;
	private String phone;
	private String address;
	private String gender;

	public Patient() {
	}

	public Patient(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String name, String description, BigDecimal totalOpenBalance, String patientNumber, String dateOfBirth,
			String phone, String address, String gender) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description, totalOpenBalance);

		this.patientNumber = patientNumber;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
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
}