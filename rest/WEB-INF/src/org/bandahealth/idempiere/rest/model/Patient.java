package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.utils.DateUtil;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

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
	private String localPatientNumber;
	private int totalVisits;
	private String lastVisitDate;
	private Boolean isApproximateDateOfBirth;

	public Patient() {
	}

	public Patient(MBPartner_BH model) {
		super(model);

		this.patientNumber = model.getBH_PatientID();
		this.dateOfBirth = DateUtil.parseDateOnly(model.getBH_Birthday());
		this.phone = model.getBH_Phone();
		this.gender = model.getbh_gender();
		this.email = model.getBH_EMail();
		this.nhifRelationship = model.getbh_nhif_relationship();
		this.nhifMemberName = model.getbh_nhif_member_name();
		this.nhifNumber = model.getNHIF_Number();
		this.nhifType = model.getBH_NHIF_Type();
		this.nationalId = model.getNationalID();
		this.occupation = model.getbh_occupation();
		this.nextOfKinName = model.getNextOfKin_Name();
		this.nextOfKinContact = model.getNextOfKin_Contact();
		this.localPatientNumber = model.getBH_Local_PatientID();
		this.isApproximateDateOfBirth = model.isBH_IsApproximateDateOfBirth();
	}

	public Patient(String name, String uuid) {
		setName(name);
		setUuid(uuid);
	}

	public Patient(String uuid, String name, BigDecimal totalOpenBalance) {
		setUuid(uuid);
		setName(name);
		setTotalOpenBalance(totalOpenBalance);
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

	@XmlElement
	public String getLocalPatientNumber() {
		return localPatientNumber;
	}

	public void setLocalPatientNumber(String localPatientNumber) {
		this.localPatientNumber = localPatientNumber;
	}

	@XmlElement
	public int getTotalVisits() {
		return totalVisits;
	}

	public void setTotalVisits(int totalVisits) {
		this.totalVisits = totalVisits;
	}

	@XmlElement
	public String getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(String lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	@JsonProperty("isApproximateDateOfBirth")
	public void setIsApproximateDateOfBirth(Boolean isApproximateDateOfBirth) {
		this.isApproximateDateOfBirth = isApproximateDateOfBirth;
	}

	@JsonProperty("isApproximateDateOfBirth")
	public Boolean isApproximateDateOfBirth() {
		return isApproximateDateOfBirth;
	}
}