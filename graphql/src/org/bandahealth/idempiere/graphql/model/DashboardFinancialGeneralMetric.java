package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

public class DashboardFinancialGeneralMetric {

	private BigDecimal revenueSales;
	private BigDecimal totalExpenses;
	private BigDecimal netProfit;
	private BigDecimal totalOwed;
	private BigDecimal inventoryValue;
	private BigDecimal totalCharges;
	private BigDecimal costOfGoodsSold;
	private BigDecimal grossProfit;
	private BigDecimal grossProfitMargin;
	
	public BigDecimal getRevenueSales() {
		return revenueSales;
	}
	public void setRevenueSales(BigDecimal revenueSales) {
		this.revenueSales = revenueSales;
	}
	public BigDecimal getTotalExpenses() {
		return totalExpenses;
	}
	public void setTotalExpenses(BigDecimal totalExpenses) {
		this.totalExpenses = totalExpenses;
	}
	public BigDecimal getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(BigDecimal netProfit) {
		this.netProfit = netProfit;
	}
	public BigDecimal getTotalOwed() {
		return totalOwed;
	}
	public void setTotalOwed(BigDecimal totalOwed) {
		this.totalOwed = totalOwed;
	}
	public BigDecimal getInventoryValue() {
		return inventoryValue;
	}
	public void setInventoryValue(BigDecimal inventoryValue) {
		this.inventoryValue = inventoryValue;
	}
	public BigDecimal getTotalCharges() {
		return totalCharges;
	}
	public void setTotalCharges(BigDecimal totalCharges) {
		this.totalCharges = totalCharges;
	}
	public BigDecimal getCostOfGoodsSold() {
		return costOfGoodsSold;
	}
	public void setCostOfGoodsSold(BigDecimal costOfGoodsSold) {
		this.costOfGoodsSold = costOfGoodsSold;
	}
	public BigDecimal getGrossProfit() {
		return grossProfit;
	}
	public void setGrossProfit(BigDecimal grossProfit) {
		this.grossProfit = grossProfit;
	}
	public BigDecimal getGrossProfitMargin() {
		return grossProfitMargin;
	}
	public void setGrossProfitMargin(BigDecimal grossProfitMargin) {
		this.grossProfitMargin = grossProfitMargin;
	}
}
