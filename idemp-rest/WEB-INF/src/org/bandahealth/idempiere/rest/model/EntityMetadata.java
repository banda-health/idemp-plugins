package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "entityMetadata")
@JsonInclude(value = Include.NON_NULL)
public class EntityMetadata {

	private List<PatientType> patientTypes;
	private List<NHIFType> nhifTypes;
	private List<NHIFRelationship> nhifRelationships;
	private List<Referral> referrals;
	private List<BaseEntity> productCategoryTypes;
	private List<ProcessStage> processStageList;
	private List<ReferenceList> documentStatuses;

	public EntityMetadata() {
		patientTypes = new ArrayList<>();
		nhifTypes = new ArrayList<>();
		nhifRelationships = new ArrayList<>();
		referrals = new ArrayList<>();
		productCategoryTypes = new ArrayList<>();
		processStageList = new ArrayList<>();
		documentStatuses = new ArrayList<>();
	}

	public List<PatientType> getPatientTypes() {
		return patientTypes;
	}

	public void setPatientTypes(List<PatientType> patientTypes) {
		this.patientTypes = patientTypes;
	}

	public List<NHIFType> getNhifTypes() {
		return nhifTypes;
	}

	public void setNhifTypes(List<NHIFType> nhifTypes) {
		this.nhifTypes = nhifTypes;
	}

	public List<NHIFRelationship> getNhifRelationships() {
		return nhifRelationships;
	}

	public void setNhifRelationships(List<NHIFRelationship> nhifRelationships) {
		this.nhifRelationships = nhifRelationships;
	}

	public List<Referral> getReferrals() {
		return referrals;
	}

	public void setReferrals(List<Referral> referrals) {
		this.referrals = referrals;
	}

	public List<BaseEntity> getProductCategoryTypes() {
		return productCategoryTypes;
	}

	public void setProductCategoryTypes(List<BaseEntity> productCategoryTypes) {
		this.productCategoryTypes = productCategoryTypes;
	}
	
	public List<ProcessStage> getProcessStageList() {
		return processStageList;
	}

	public void setProcessStageList(List<ProcessStage> processStageList) {
		this.processStageList = processStageList;
	}

	public List<ReferenceList> getDocumentStatuses() {
		return documentStatuses;
	}

	public void setDocumentStatuses(List<ReferenceList> documentStatuses) {
		this.documentStatuses = documentStatuses;
	}

	public void addPatientType(PatientType entity) {
		patientTypes.add(entity);
	}

	public void addNHIFType(NHIFType entity) {
		nhifTypes.add(entity);
	}

	public void addNHIFRelationship(NHIFRelationship entity) {
		nhifRelationships.add(entity);
	}

	public void addReferral(Referral entity) {
		referrals.add(entity);
	}

	public void addProductCategoryType(BaseEntity entity) {
		productCategoryTypes.add(entity);
	}

	public void addProcessStageList(ProcessStage entity) {
		processStageList.add(entity);
	}
}
