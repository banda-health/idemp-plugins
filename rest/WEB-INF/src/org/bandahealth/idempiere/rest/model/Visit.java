package org.bandahealth.idempiere.rest.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.bandahealth.idempiere.base.model.MBHVisit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Visit extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Boolean newVisit;
	private PatientType patientType;
	private Referral referral;
	private OrderStatus status;
	private BusinessPartner patient;
	private User clinician;
	private String documentNumber;
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

		this.processStage = new ProcessStage(model.getBH_Process_Stage());
		this.visitDate = model.getBH_VisitDate();
		this.documentNumber = model.getDocumentNo();
	}

	public Visit getVisitQueue(String created, String uuid, BusinessPartner businessPartner, OrderStatus status) {
		setCreated(created);
		setUuid(uuid);
		setPatient(businessPartner);
		setStatus(status);

		return this;
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
}
