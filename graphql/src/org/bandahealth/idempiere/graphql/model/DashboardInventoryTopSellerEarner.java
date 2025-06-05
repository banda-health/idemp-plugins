package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

public class DashboardInventoryTopSellerEarner {

	private String name;
	private BigDecimal quantitySold;
	private BigDecimal valueGoodsSold;
	private BigDecimal incomeGenerated;
	private BigDecimal marginEarned;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(BigDecimal quantitySold) {
		this.quantitySold = quantitySold;
	}

	public BigDecimal getValueGoodsSold() {
		return valueGoodsSold;
	}

	public void setValueGoodsSold(BigDecimal valueGoodsSold) {
		this.valueGoodsSold = valueGoodsSold;
	}

	public BigDecimal getIncomeGenerated() {
		return incomeGenerated;
	}

	public void setIncomeGenerated(BigDecimal incomeGenerated) {
		this.incomeGenerated = incomeGenerated;
	}

	public BigDecimal getMarginEarned() {
		return marginEarned;
	}

	public void setMarginEarned(BigDecimal marginEarned) {
		this.marginEarned = marginEarned;
	}

}
