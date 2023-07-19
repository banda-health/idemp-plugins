package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class EncounterDiagnosis extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private CodedDiagnosis codedDiagnosis;
	private String uncodedDiagnosis;
	private int lineNo;
	@JsonIgnore
	private int visitId;
	private String diagnosisType;

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

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public String getDiagnosisType() {
		return diagnosisType;
	}

	public void setDiagnosisType(String diagnosisType) {
		this.diagnosisType = diagnosisType;
	}
}
