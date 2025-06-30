package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class DashboardFinancialHistorical {

	private Timestamp bucketValue;
	private BigDecimal totalIncome;
	private BigDecimal totalExpenses;
	private BigDecimal profitLoss;

	public Timestamp getBucketValue() {
		return bucketValue;
	}

	public void setBucketValue(Timestamp bucketValue) {
		this.bucketValue = bucketValue;
	}

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
}
