package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.utils.DateUtil;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class BusinessPartner extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private BigDecimal totalOpenBalance;
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

	public BusinessPartner() {
	}

	public BusinessPartner(MBPartner_BH model) {
		super(model, model.getName(), model.getDescription(), model.getValue());

		this.totalOpenBalance = model.getTotalOpenBalance();

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

	public BusinessPartner(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String name, String description, BigDecimal totalOpenBalance) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.totalOpenBalance = totalOpenBalance;
	}

	public BigDecimal getTotalOpenBalance() {
		return totalOpenBalance;
	}

	public void setTotalOpenBalance(BigDecimal totalOpenBalance) {
		this.totalOpenBalance = totalOpenBalance;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNhifRelationship() {
		return nhifRelationship;
	}

	public void setNhifRelationship(String nhifRelationship) {
		this.nhifRelationship = nhifRelationship;
	}

	public String getNhifMemberName() {
		return nhifMemberName;
	}

	public void setNhifMemberName(String nhifMemberName) {
		this.nhifMemberName = nhifMemberName;
	}

	public String getNhifNumber() {
		return nhifNumber;
	}

	public void setNhifNumber(String nhifNumber) {
		this.nhifNumber = nhifNumber;
	}

	public String getNhifType() {
		return nhifType;
	}

	public void setNhifType(String nhifType) {
		this.nhifType = nhifType;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getNextOfKinName() {
		return nextOfKinName;
	}

	public void setNextOfKinName(String nextOfKinName) {
		this.nextOfKinName = nextOfKinName;
	}

	public String getNextOfKinContact() {
		return nextOfKinContact;
	}

	public void setNextOfKinContact(String nextOfKinContact) {
		this.nextOfKinContact = nextOfKinContact;
	}

	public String getLocalPatientNumber() {
		return localPatientNumber;
	}

	public void setLocalPatientNumber(String localPatientNumber) {
		this.localPatientNumber = localPatientNumber;
	}

	public int getTotalVisits() {
		return totalVisits;
	}

	public void setTotalVisits(int totalVisits) {
		this.totalVisits = totalVisits;
	}

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