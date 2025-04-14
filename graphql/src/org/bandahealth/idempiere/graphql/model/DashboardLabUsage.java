package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

public class DashboardLabUsage {
	private Integer conceptId;
	private String name;
	private BigDecimal current;
	private BigDecimal previous;

	public Integer getConceptId() {
		return conceptId;
	}

	public void setConceptId(Integer conceptId) {
		this.conceptId = conceptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
