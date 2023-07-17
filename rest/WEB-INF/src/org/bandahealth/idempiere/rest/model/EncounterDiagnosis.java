package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class EncounterDiagnosis extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private CodedDiagnosis codedDiagnosis;
	private String uncodedDiagnosis;
	private int lineNo;
	private Visit visit;

	public EncounterDiagnosis() {
	}

	public CodedDiagnosis getCodedDiagnosis() {
		return codedDiagnosis;
	}

	public void setCodedDiagnosis(CodedDiagnosis codedDiagnosis) {
		this.codedDiagnosis = codedDiagnosis;
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

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}
}
