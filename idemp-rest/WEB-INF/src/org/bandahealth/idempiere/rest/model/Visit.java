package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MOrder_BH;

@XmlRootElement(name = "visit")
@JsonInclude(value = Include.NON_NULL)
public class Visit extends Order {

	private static final long serialVersionUID = 1L;
	private Boolean newVisit;
	private String clinicalNotes;
	private String labNotes;
	private PatientType patientType;
	private Referral referral;
	private OrderStatus status;
	private Patient patient;
	private String chiefComplaint;
	private String temperature;
	private String pulse;
	private String respiratoryRate;
	private String height;
	private String weight;
	private User clinician;
	private ProcessStage processStage;
	private String referredFromTo;
	private Timestamp visitDate;
	private CodedDiagnosis primaryCodedDiagnosis;
	private CodedDiagnosis secondaryCodedDiagnosis;
	private String primaryUnCodedDiagnosis;
	private String secondaryUnCodedDiagnosis;
	private Integer systolicBloodPressure;
	private Integer diastolicBloodPressure;
	private BigDecimal oxygenSaturation;

	public Visit() {
		setIsSalesOrderTransaction(true);
	}

	public Visit(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, Patient patient,
			String dateOrdered, BigDecimal grandTotal, Boolean newVisit, String clinicalNotes, String diagnosis,
			PatientType patientType, Referral referral, List<OrderLine> orderLines, List<Payment> payments,
			String documentStatus, OrderStatus status, String chiefComplaint, String temperature, String pulse,
			String respiratoryRate, String height, String weight,
			CodedDiagnosis secondaryCodedDiagnosis, CodedDiagnosis primaryCodedDiagnosis, User clinician,
			ProcessStage processStage, MOrder_BH order) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, grandTotal, true, diagnosis,
				orderLines, payments, documentStatus);

		this.newVisit = newVisit;
		this.clinicalNotes = clinicalNotes;
		this.labNotes = order.getBH_LabNotes();
		this.patientType = patientType;
		this.referral = referral;
		this.patient = patient;
		this.status = status;
		this.chiefComplaint = chiefComplaint;
		this.temperature = temperature;
		this.pulse = pulse;
		this.respiratoryRate = respiratoryRate;
		this.height = height;
		this.weight = weight;
		this.secondaryCodedDiagnosis = secondaryCodedDiagnosis;
		this.primaryCodedDiagnosis = primaryCodedDiagnosis;
		this.clinician = clinician;
		this.processStage = processStage;
		if (order != null) {
			this.referredFromTo = order.getBH_ReferredFromTo();
			this.visitDate = order.getBH_VisitDate();
			this.primaryUnCodedDiagnosis = order.getBH_PrimaryUnCodedDiagnosis();
			this.secondaryUnCodedDiagnosis = order.getBH_SecondaryUnCodedDiagnosis();
			this.systolicBloodPressure = order.getbh_systolic_blood_pressure();
			this.diastolicBloodPressure = order.getbh_diastolic_blood_pressure();
			setId(order.get_ID());
			setOxygenSaturation(order.getBH_OxygenSaturation());
		}

		setIsSalesOrderTransaction(true);
	}

	public Visit(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, Patient patient,
			PatientType patientType, String dateOrdered, BigDecimal grandTotal, String documentStatus,
			MOrder_BH order) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, grandTotal, true, null, null,
				null, documentStatus);

		this.patientType = patientType;
		this.patient = patient;

		setId(order.get_ID());
		setIsSalesOrderTransaction(true);
		if (order != null) {
			this.visitDate = order.getBH_VisitDate();
			setId(order.get_ID());
		}
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
	public String getClinicalNotes() {
		return clinicalNotes;
	}

	public void setClinicalNotes(String clinicalNotes) {
		this.clinicalNotes = clinicalNotes;
	}

	@XmlElement
	public String getLabNotes() {
		return labNotes;
	}

	public void setLabNotes(String labNotes) {
		this.labNotes = labNotes;
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
	public Integer getSystolicBloodPressure() {
		return systolicBloodPressure;
	}

	public void setSystolicBloodPressure(Integer systolicBloodPressure) {
		this.systolicBloodPressure = systolicBloodPressure;
	}

	@XmlElement
	public Integer getDiastolicBloodPressure() {
		return diastolicBloodPressure;
	}

	public void setDiastolicBloodPressure(Integer diastolicBloodPressure) {
		this.diastolicBloodPressure = diastolicBloodPressure;
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
	public User getClinician() {
		return clinician;
	}

	public void setClinician(User clinician) {
		this.clinician = clinician;
	}

	@XmlElement
	public ProcessStage getProcessStage() {
		return processStage;
	}

	public void setProcessStage(ProcessStage processStage) {
		this.processStage = processStage;
	}

	public String getReferredFromTo() {
		return referredFromTo;
	}

	public void setReferredFromTo(String referredFromTo) {
		this.referredFromTo = referredFromTo;
	}

	public Timestamp getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Timestamp visitDate) {
		this.visitDate = visitDate;
	}

	public CodedDiagnosis getPrimaryCodedDiagnosis() {
		return primaryCodedDiagnosis;
	}

	public void setPrimaryCodedDiagnosis(CodedDiagnosis primaryCodedDiagnosis) {
		this.primaryCodedDiagnosis = primaryCodedDiagnosis;
	}

	public CodedDiagnosis getSecondaryCodedDiagnosis() {
		return secondaryCodedDiagnosis;
	}

	public void setSecondaryCodedDiagnosis(CodedDiagnosis secondaryCodedDiagnosis) {
		this.secondaryCodedDiagnosis = secondaryCodedDiagnosis;
	}

	public String getPrimaryUnCodedDiagnosis() {
		return primaryUnCodedDiagnosis;
	}

	public void setPrimaryUnCodedDiagnosis(String primaryUnCodedDiagnosis) {
		this.primaryUnCodedDiagnosis = primaryUnCodedDiagnosis;
	}

	public String getSecondaryUnCodedDiagnosis() {
		return secondaryUnCodedDiagnosis;
	}

	public void setSecondaryUnCodedDiagnosis(String secondaryUnCodedDiagnosis) {
		this.secondaryUnCodedDiagnosis = secondaryUnCodedDiagnosis;
	}

	public BigDecimal getOxygenSaturation() {
		return oxygenSaturation;
	}

	public void setOxygenSaturation(BigDecimal oxygenSaturation) {
		this.oxygenSaturation = oxygenSaturation;
	}
}
