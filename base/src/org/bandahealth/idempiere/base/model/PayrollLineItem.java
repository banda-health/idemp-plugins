package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;

/**
 * One computed payslip line — the persistence shape for BH_Payroll_Run_Line_Item.
 * Component identity is snapshotted (code/name/category) so locked payslips are
 * immune to later component edits.
 */
public class PayrollLineItem {
	public final String code;
	public final String name;
	public final String category;
	public final boolean taxDeductible;
	public final BigDecimal employeeAmount;
	public final BigDecimal employerAmount;

	public PayrollLineItem(String code, String name, String category, boolean taxDeductible,
			BigDecimal employeeAmount, BigDecimal employerAmount) {
		this.code = code;
		this.name = name;
		this.category = category;
		this.taxDeductible = taxDeductible;
		this.employeeAmount = employeeAmount;
		this.employerAmount = employerAmount;
	}
}
