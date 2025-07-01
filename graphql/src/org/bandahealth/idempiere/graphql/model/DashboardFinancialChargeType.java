package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

public class DashboardFinancialChargeType {

	private String name;
	private BigDecimal frequency;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getFrequency() {
		return frequency;
	}

	public void setFrequency(BigDecimal frequency) {
		this.frequency = frequency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
