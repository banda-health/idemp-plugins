package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

public class DashboardFinancialOpenBalance {

	private String name;
	private BigDecimal totalOpenBalance;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTotalOpenBalance() {
		return totalOpenBalance;
	}

	public void setTotalOpenBalance(BigDecimal totalOpenBalance) {
		this.totalOpenBalance = totalOpenBalance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
