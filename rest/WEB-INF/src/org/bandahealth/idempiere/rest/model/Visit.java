package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MOrder_BH;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "visit")
@JsonInclude(value = Include.NON_NULL)
public class Visit extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Boolean newVisit;
	private String clinicalNotes;
	private String labNotes;
	private PatientType patientType;
	private Referral referral;
	private OrderStatus status;
	private BusinessPartner patient;
	private String documentNumber;
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
	private List<Payment> payments = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	private VoidedReason voidedReason;

	public Visit() {
	}

	public Visit(MBHVisit model) {
		super(model, null, model.getDescription(), null);

		this.newVisit = model.isBH_NewVisit();
		this.clinicalNotes = model.getBH_ClinicalNotes();
		this.labNotes = model.getBH_LabNotes();
		this.patientType = new PatientType(model.getBH_PatientType());
		this.referral = new Referral(model.getbh_referral());
		this.chiefComplaint = model.getBH_ChiefComplaint();
		this.temperature = model.getBH_Temperature();
		this.pulse = model.getBH_Pulse();
		this.respiratoryRate = model.getBH_RespiratoryRate();
		this.height = model.getBH_Height();
		this.weight = model.getBH_Weight();
		this.processStage = new ProcessStage(model.getBH_Process_Stage());
		this.referredFromTo = model.getBH_ReferredFromTo();
		this.visitDate = model.getBH_VisitDate();
		this.primaryUnCodedDiagnosis = model.getbh_primaryuncodeddiagnosis();
		this.secondaryUnCodedDiagnosis = model.getbh_secondaryuncodeddiagnosis();
		this.systolicBloodPressure = model.getbh_systolic_blood_pressure();
		this.diastolicBloodPressure = model.getbh_diastolic_blood_pressure();
		setOxygenSaturation(model.getBH_OxygenSaturation());
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
	public Boolean isNewVisit() {
		return newVisit;
	}

	public void setNewVisit(Boolean newVisit) {
		this.newVisit = newVisit;
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

	public BusinessPartner getPatient() {
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
}
