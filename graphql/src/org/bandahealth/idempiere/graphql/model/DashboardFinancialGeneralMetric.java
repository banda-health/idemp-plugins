package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

public class DashboardFinancialGeneralMetric {

	private BigDecimal totalIncome;
	private BigDecimal totalExpenses;
	private BigDecimal profitLoss;
	private BigDecimal unpaidAmount;
	private BigDecimal inventoryValue;
	private BigDecimal totalRevenue;
	private BigDecimal costOfGoodsSold;
	private BigDecimal grossProfit;
	private BigDecimal grossProfitMargin;
	
	public BigDecimal getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}
	public BigDecimal getTotalExpenses() {
		return totalExpenses;
	}
	public void setTotalExpenses(BigDecimal totalExpenses) {
		this.totalExpenses = totalExpenses;
	}
	public BigDecimal getProfitLoss() {
		return profitLoss;
	}
	public void setProfitLoss(BigDecimal profitLoss) {
		this.profitLoss = profitLoss;
	}
	public BigDecimal getUnpaidAmount() {
		return unpaidAmount;
	}
	public void setUnpaidAmount(BigDecimal unpaidAmount) {
		this.unpaidAmount = unpaidAmount;
	}
	public BigDecimal getInventoryValue() {
		return inventoryValue;
	}
	public void setInventoryValue(BigDecimal inventoryValue) {
		this.inventoryValue = inventoryValue;
	}
	public BigDecimal getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
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
