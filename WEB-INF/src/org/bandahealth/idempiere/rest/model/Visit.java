package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "visit")
@JsonInclude(value = Include.NON_NULL)
public class Visit extends Order {

	private static final long serialVersionUID = 1L;
	private Boolean newVisit;
	private String visitNotes;
	private PatientType patientType;
	private Referral referral;
	private OrderStatus status;
	private Patient patient;

	public Visit() {
		setIsSalesOrderTransaction(true);
	}

	public Visit(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, Patient patient,
			String dateOrdered, BigDecimal grandTotal, Boolean newVisit, String visitNotes, String diagnosis,
			PatientType patientType, Referral referral, List<OrderLine> orderLines, List<Payment> payments,
			String documentStatus, OrderStatus status) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, grandTotal, true, diagnosis,
				orderLines, payments, documentStatus);

		this.newVisit = newVisit;
		this.visitNotes = visitNotes;
		this.patientType = patientType;
		this.referral = referral;
		this.patient = patient;
		this.status = status;

		setIsSalesOrderTransaction(true);
	}

	public Visit(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, Patient patient,
			PatientType patientType, String dateOrdered, BigDecimal grandTotal, String documentStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, grandTotal, true, null, null,
				null, documentStatus);

		this.patientType = patientType;
		this.patient = patient;

		setIsSalesOrderTransaction(true);
	}

	public Visit getVisitQueue(String created, String uuid, Patient patient, OrderStatus status) {
		setCreated(created);
		setUuid(uuid);
		setPatient(patient);
		setStatus(status);

		return this;
	}

	@XmlElement
	public Boolean isNewVisit() {
		return newVisit;
	}

	public void setNewVisit(Boolean newVisit) {
		this.newVisit = newVisit;
	}

	@XmlElement
	public String getDiagnosis() {
		return super.getDescription();
	}

	public void setDiagnosis(String diagnosis) {
		super.setDescription(diagnosis);
	}

	@XmlElement
	public String getVisitNotes() {
		return visitNotes;
	}

	public void setVisitNotes(String visitNotes) {
		this.visitNotes = visitNotes;
	}

	@XmlElement
	public PatientType getPatientType() {
		return patientType;
	}

	public void setPatientType(PatientType patientType) {
		this.patientType = patientType;
	}

	@XmlElement
	public Referral getReferral() {
		return referral;
	}

	public void setReferral(Referral referral) {
		this.referral = referral;
	}

	@XmlElement
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
