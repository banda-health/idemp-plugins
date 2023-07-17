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
	private OrderStatus status;
	private BusinessPartner patient;
	private String documentNumber;
	private ProcessStage processStage;
	private Timestamp visitDate;

	private List<Encounter> encounters = new ArrayList<>();
	private List<EncounterDiagnosis> encounterDiagnosis = new ArrayList<>();

	private List<Payment> payments = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	private VoidedReason voidedReason;

	public Visit() {
	}

	public Visit(MBHVisit model) {
		super(model, null, model.getDescription(), null);

		this.processStage = new ProcessStage(model.getBH_Process_Stage());
		this.visitDate = model.getBH_VisitDate();
		this.documentNumber = model.getDocumentNo();
	}

	public Visit getVisitQueue(String created, String uuid, Patient patient, OrderStatus status) {
		setCreated(created);
		setUuid(uuid);
		setPatient(patient);
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

	public void setPatient(Patient patient) {
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

	public List<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public List<EncounterDiagnosis> getEncounterDiagnosis() {
		return encounterDiagnosis;
	}

	public void setEncounterDiagnosis(List<EncounterDiagnosis> encounterDiagnosis) {
		this.encounterDiagnosis = encounterDiagnosis;
	}

	public void setPatient(BusinessPartner patient) {
		this.patient = patient;
	}

}
