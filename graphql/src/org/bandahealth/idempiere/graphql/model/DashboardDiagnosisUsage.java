package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

public class DashboardDiagnosisUsage {
	private Integer conceptId;
	private String BH_Uncoded_Diagnosis;
	private BigDecimal current;
	private BigDecimal previous;
	private BigDecimal currentTotal;

	public Integer getConceptId() {
		return conceptId;
	}

	public void setConceptId(Integer conceptId) {
		this.conceptId = conceptId;
	}

	public String getBH_Uncoded_Diagnosis() {
		return BH_Uncoded_Diagnosis;
	}

	public void setBH_Uncoded_Diagnosis(String BH_Uncoded_Diagnosis) {
		this.BH_Uncoded_Diagnosis = BH_Uncoded_Diagnosis;
	}

	public BigDecimal getCurrent() {
		return current;
	}

	public void setCurrent(BigDecimal current) {
		this.current = current;
	}

	public BigDecimal getPrevious() {
		return previous;
	}

	public void setPrevious(BigDecimal previous) {
		this.previous = previous;
	}

	public BigDecimal getCurrentTotal() {
		return currentTotal;
	}

	public void setCurrentTotal(BigDecimal currentTotal) {
		this.currentTotal = currentTotal;
	}
}
