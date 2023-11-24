package org.bandahealth.idempiere.rest.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHVisit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.rest.service.db.EntityMetadataDBService;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;

@JsonInclude(value = Include.NON_NULL)
public class Visit extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Boolean newVisit;
	@JsonIgnore
	private String patientTypeValue;
	private PatientType patientType;
	@JsonIgnore
	private String referralValue;
	private Referral referral;
	private OrderStatus status;
	@JsonIgnore
	private Integer patientId;
	private BusinessPartner patient;
	@JsonIgnore
	private Integer clinicianId;
	private User clinician;
	private String documentNumber;
	@JsonIgnore
	private String processStageValue;
	private ProcessStage processStage;
	private String referredFromTo;
	private Timestamp visitDate;
	private List<Encounter> encounters = new ArrayList<>();
	private List<Payment> payments = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	private List<Invoice> invoices = new ArrayList<>();
	private VoidedReason voidedReason;

	public Visit() {
	}

	public Visit(MBHVisit model) {
		super(model, null, model.getDescription(), null);

		setNewVisit(model.isBH_NewVisit());
		setPatientTypeValue(model.getBH_PatientType());
		setReferralValue(model.getbh_referral());
		setPatientId(model.getPatient_ID());
		setClinicianId(model.getBH_Clinician_User_ID());
		setProcessStageValue(model.getBH_Process_Stage());
		setDocumentNumber(model.getDocumentNo());
		setVisitDate(model.getBH_VisitDate());
		setReferredFromTo(model.getBH_ReferredFromTo());
	}

	@XmlElement
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public BusinessPartner getPatient() {
		return patient;
	}

	public void setPatient(BusinessPartner patient) {
		this.patient = patient;
	}

	@XmlElement
	public ProcessStage getProcessStage() {
		return processStage;
	}

	public void setProcessStage(ProcessStage processStage) {
		this.processStage = processStage;
	}

	public Timestamp getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Timestamp visitDate) {
		this.visitDate = visitDate;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public VoidedReason getVoidedReason() {
		return voidedReason;
	}

	public void setVoidedReason(VoidedReason voidedReason) {
		this.voidedReason = voidedReason;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public List<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public Boolean isNewVisit() {
		return newVisit;
	}

	public void setNewVisit(Boolean newVisit) {
		this.newVisit = newVisit;
	}

	public PatientType getPatientType() {
		return patientType;
	}

	public void setPatientType(PatientType patientType) {
		this.patientType = patientType;
	}

	public Referral getReferral() {
		return referral;
	}

	public void setReferral(Referral referral) {
		this.referral = referral;
	}

	public User getClinician() {
		return clinician;
	}

	public void setClinician(User clinician) {
		this.clinician = clinician;
	}

	public String getReferredFromTo() {
		return referredFromTo;
	}

	public void setReferredFromTo(String referredFromTo) {
		this.referredFromTo = referredFromTo;
	}

	@JsonIgnore
	public Integer getPatientId() {
		return patientId;
	}

	@JsonIgnore
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	@JsonIgnore
	public Integer getClinicianId() {
		return clinicianId;
	}

	@JsonIgnore
	public void setClinicianId(Integer clinicianId) {
		this.clinicianId = clinicianId;
	}

	@JsonIgnore
	public String getProcessStageValue() {
		return processStageValue;
	}

	@JsonIgnore
	public void setProcessStageValue(String processStageValue) {
		this.processStageValue = processStageValue;
	}

	@JsonIgnore
	public String getReferralValue() {
		return referralValue;
	}

	@JsonIgnore
	public void setReferralValue(String referralValue) {
		this.referralValue = referralValue;
	}

	@JsonIgnore
	public String getPatientTypeValue() {
		return patientTypeValue;
	}

	@JsonIgnore
	public void setPatientTypeValue(String patientTypeValue) {
		this.patientTypeValue = patientTypeValue;
	}
}
