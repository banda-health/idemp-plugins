package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class EncounterDiagnostic extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private int conceptId;
	private Concept concept;
	private String status;
	private int lineNo;
	@JsonIgnore
	private int encounterId;
	private String value;
	@JsonIgnore
	private int visitId;

	public EncounterDiagnostic() {
	}

	public EncounterDiagnostic(MBHEncounterDiagnostic entity) {
		super(entity);

		setConceptId(entity.getBH_Concept_ID());
		setStatus(entity.getBH_Diagnostic_Status());
		setLineNo(entity.getLineNo());
		setEncounterId(entity.getBH_Encounter_ID());
		setValue(entity.getBH_Value());
	}

	public int getConceptId() {
		return conceptId;
	}

	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public int getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
}
