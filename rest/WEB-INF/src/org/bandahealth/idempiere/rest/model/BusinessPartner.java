package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.utils.DateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BusinessPartner extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private BigDecimal totalOpenBalance;
	private String patientNumber;
	private String dateOfBirth;
	private String phone;
	private String address;
	private String gender;
	private String email;
	private String nationalId;
	private String occupation;
	private String nextOfKinName;
	private String nextOfKinContact;
	private String localPatientNumber;
	private int totalVisits;
	private String lastVisitDate;
	private Boolean isApproximateDateOfBirth;
	private List<PayerInformationField> payerInformationFieldList = new ArrayList<>();
	private BusinessPartnerGroup businessPartnerGroup;
	@JsonProperty("isCustomer")
	private Boolean isCustomer;
	@JsonProperty("isVendor")
	private Boolean isVendor;
	private boolean needAdditionalVisitInformation;
	@JsonProperty("isLocked")
	private boolean isLocked;

	public BusinessPartner() {
		isCustomer = false;
		isVendor = false;
		needAdditionalVisitInformation = false;
	}

	public BusinessPartner(MBPartner_BH model) {
		super(model, model.getName(), model.getDescription(), model.getValue());

		this.totalOpenBalance = model.getTotalOpenBalance();

		this.patientNumber = model.getBH_PatientID();
		this.dateOfBirth = DateUtil.parseDateOnly(model.getBH_Birthday());
		this.phone = model.getBH_Phone();
		this.gender = model.getbh_gender();
		this.email = model.getBH_EMail();
		this.nationalId = model.getNationalID();
		this.occupation = model.getbh_occupation();
		this.nextOfKinName = model.getNextOfKin_Name();
		this.nextOfKinContact = model.getNextOfKin_Contact();
		this.localPatientNumber = model.getBH_Local_PatientID();
		this.isApproximateDateOfBirth = model.isBH_IsApproximateDateOfBirth();
		this.isCustomer = model.isCustomer();
		this.isVendor = model.isVendor();
		setNeedAdditionalVisitInformation(model.isBH_NeedAdditionalVisitInfo());
		setLocked(model.isBH_Locked());
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

	public List<PayerInformationField> getPayerInformationFieldList() {
		return payerInformationFieldList;
	}

	public void setPayerInformationFieldList(List<PayerInformationField> payerInformationFieldList) {
		this.payerInformationFieldList = payerInformationFieldList;
	}

	public BusinessPartnerGroup getBusinessPartnerGroup() {
		return businessPartnerGroup;
	}

	public void setBusinessPartnerGroup(BusinessPartnerGroup businessPartnerGroup) {
		this.businessPartnerGroup = businessPartnerGroup;
	}

	@JsonProperty("isCustomer")
	public Boolean getCustomer() {
		return isCustomer;
	}

	@JsonProperty("isCustomer")
	public void setCustomer(Boolean customer) {
		isCustomer = customer;
	}

	@JsonProperty("isVendor")
	public Boolean getVendor() {
		return isVendor;
	}

	@JsonProperty("isVendor")
	public void setVendor(Boolean vendor) {
		isVendor = vendor;
	}

	public boolean isNeedAdditionalVisitInformation() {
		return needAdditionalVisitInformation;
	}

	public void setNeedAdditionalVisitInformation(boolean needAdditionalVisitInformation) {
		this.needAdditionalVisitInformation = needAdditionalVisitInformation;
	}

	@JsonProperty("isLocked")
	public boolean isLocked() {
		return isLocked;
	}

	@JsonProperty("isLocked")
	public void setLocked(boolean locked) {
		isLocked = locked;
	}
}
