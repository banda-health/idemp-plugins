package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Stateless net-pay preview computed from the resolved catalogue. Maps to the GraphQL type
 * {@code BH_PayrollPreviewResult}; getters are PascalCase to match the schema field names.
 * Nothing is persisted.
 */
public class PayrollPreviewResult {
	private BigDecimal BH_GrossPay;
	private BigDecimal BH_TaxablePay;
	private BigDecimal BH_PAYE_Amount;
	private BigDecimal BH_TotalDeductions;
	private BigDecimal BH_NetPay;
	private BigDecimal BH_CostToEmployer;
	private List<PayrollPreviewItem> Items;

	public BigDecimal getBH_GrossPay() {
		return BH_GrossPay;
	}

	public void setBH_GrossPay(BigDecimal bh_GrossPay) {
		this.BH_GrossPay = bh_GrossPay;
	}

	public BigDecimal getBH_TaxablePay() {
		return BH_TaxablePay;
	}

	public void setBH_TaxablePay(BigDecimal bh_TaxablePay) {
		this.BH_TaxablePay = bh_TaxablePay;
	}

	public BigDecimal getBH_PAYE_Amount() {
		return BH_PAYE_Amount;
	}

	public void setBH_PAYE_Amount(BigDecimal bh_PAYE_Amount) {
		this.BH_PAYE_Amount = bh_PAYE_Amount;
	}

	public BigDecimal getBH_TotalDeductions() {
		return BH_TotalDeductions;
	}

	public void setBH_TotalDeductions(BigDecimal bh_TotalDeductions) {
		this.BH_TotalDeductions = bh_TotalDeductions;
	}

	public BigDecimal getBH_NetPay() {
		return BH_NetPay;
	}

	public void setBH_NetPay(BigDecimal bh_NetPay) {
		this.BH_NetPay = bh_NetPay;
	}

	public BigDecimal getBH_CostToEmployer() {
		return BH_CostToEmployer;
	}

	public void setBH_CostToEmployer(BigDecimal bh_CostToEmployer) {
		this.BH_CostToEmployer = bh_CostToEmployer;
	}

	public List<PayrollPreviewItem> getItems() {
		return Items;
	}

	public void setItems(List<PayrollPreviewItem> items) {
		this.Items = items;
	}
}
