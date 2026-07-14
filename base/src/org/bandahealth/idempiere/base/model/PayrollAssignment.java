package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;

/**
 * Per-employee amount for an EMPLOYEE_AMOUNT component (Sacco, voluntary pension, loan).
 * An EMPLOYEE_AMOUNT component with no assignment for the employee produces no line item.
 */
public class PayrollAssignment {
	public final String code;
	public final BigDecimal amount;

	public PayrollAssignment(String code, BigDecimal amount) {
		this.code = code;
		this.amount = amount == null ? BigDecimal.ZERO : amount;
	}
}
