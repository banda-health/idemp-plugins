package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

public class DashboardInventoryGeneralMetrics {

	private BigDecimal inventoryTurnoverRate;
	private BigDecimal daysOnHand;
	private BigDecimal salesToStockRatio;
	private BigDecimal grossMargin;
	private BigDecimal returnOnInvestment;

	public BigDecimal getInventoryTurnoverRate() {
		return inventoryTurnoverRate;
	}

	public void setInventoryTurnoverRate(BigDecimal inventoryTurnoverRate) {
		this.inventoryTurnoverRate = inventoryTurnoverRate;
	}

	public BigDecimal getDaysOnHand() {
		return daysOnHand;
	}

	public void setDaysOnHand(BigDecimal daysOnHand) {
		this.daysOnHand = daysOnHand;
	}

	public BigDecimal getSalesToStockRatio() {
		return salesToStockRatio;
	}

	public void setSalesToStockRatio(BigDecimal salesToStockRatio) {
		this.salesToStockRatio = salesToStockRatio;
	}

	public BigDecimal getGrossMargin() {
		return grossMargin;
	}

	public void setGrossMargin(BigDecimal grossMargin) {
		this.grossMargin = grossMargin;
	}

	public BigDecimal getReturnOnInvestment() {
		return returnOnInvestment;
	}

	public void setReturnOnInvestment(BigDecimal returnOnInvestment) {
		this.returnOnInvestment = returnOnInvestment;
	}

}
