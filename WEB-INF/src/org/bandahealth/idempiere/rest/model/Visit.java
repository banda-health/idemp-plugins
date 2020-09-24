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
	private String chiefComplaint;
	private String temperature;
	private String pulse;
	private String respiratoryRate;
	private String bloodPressure;
	private String height;
	private String weight;
	private String diagnosisII;

	public Visit() {
		setIsSalesOrderTransaction(true);
	}

	public Visit(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, Patient patient,
			String dateOrdered, BigDecimal grandTotal, Boolean newVisit, String visitNotes, String diagnosis,
			PatientType patientType, Referral referral, List<OrderLine> orderLines, List<Payment> payments,
			String documentStatus, OrderStatus status, String chiefComplaint, String temperature, String pulse,
			String respiratoryRate, String bloodPressure, String height, String weight, String diagnosisII) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, grandTotal, true, diagnosis,
				orderLines, payments, documentStatus);

		this.newVisit = newVisit;
		this.visitNotes = visitNotes;
		this.patientType = patientType;
		this.referral = referral;
		this.patient = patient;
		this.status = status;
		this.chiefComplaint = chiefComplaint;
		this.temperature = temperature;
		this.pulse = pulse;
		this.respiratoryRate = respiratoryRate;
		this.bloodPressure = bloodPressure;
		this.height = height;
		this.weight = weight;
		this.diagnosisII = diagnosisII;

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

	@XmlElement
	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	@XmlElement
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	@XmlElement
	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	@XmlElement
	public String getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	@XmlElement
	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	@XmlElement
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@XmlElement
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@XmlElement
	public String getDiagnosisII() {
		return diagnosisII;
	}

	public void setDiagnosisII(String diagnosisII) {
		this.diagnosisII = diagnosisII;
	}

}
