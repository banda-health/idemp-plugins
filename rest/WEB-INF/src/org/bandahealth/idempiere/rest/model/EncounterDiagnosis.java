package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class EncounterDiagnosis extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private int conceptId;
	private Concept concept;
	private String uncodedDiagnosis;
	private int lineNo;
	@JsonIgnore
	private int encounterId;

	public EncounterDiagnosis() {
	}

	public EncounterDiagnosis(MBHEncounterDiagnosis entity) {
		super(entity);

		this.uncodedDiagnosis = entity.getBH_Uncoded_Diagnosis();
		this.lineNo = entity.getLineNo();
		this.encounterId = entity.getBH_Encounter_ID();
		setConceptId(entity.getBH_Concept_ID());
	}

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public int getConceptId() {
		return conceptId;
	}

	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}

	public String getUncodedDiagnosis() {
		return uncodedDiagnosis;
	}

	public void setUncodedDiagnosis(String uncodedDiagnosis) {
		this.uncodedDiagnosis = uncodedDiagnosis;
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
}
