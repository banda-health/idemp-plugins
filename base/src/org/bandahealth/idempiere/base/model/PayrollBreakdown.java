package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Every figure computed for one employee for one period. Totals are typed (they map to
 * BH_Payroll_Run_Line columns); per-component figures are the items list (they map to
 * BH_Payroll_Run_Line_Item rows). All amounts 2dp KES.
 */
public class PayrollBreakdown {
	public BigDecimal grossPay;
	public BigDecimal taxablePay;
	public BigDecimal grossTax;              // band tax before relief ("Tax Before Relief" on payslips)
	public BigDecimal totalRelief;
	public BigDecimal payeAmount;            // grossTax - totalRelief, floored at zero
	public BigDecimal totalDeductions;       // PAYE + every employee-side deduction item
	public BigDecimal netPay;
	public BigDecimal costToEmployer;        // gross + every employer-side item amount
	public final List<PayrollLineItem> items = new ArrayList<>();

	/** The computed item for a component code, or null (e.g. unassigned EMPLOYEE_AMOUNT components). */
	public PayrollLineItem item(String code) {
		for (PayrollLineItem item : items) {
			if (item.code.equals(code)) {
				return item;
			}
		}
		return null;
	}
}
