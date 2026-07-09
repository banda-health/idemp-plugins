package org.bandahealth.idempiere.base.payroll;

import java.math.BigDecimal;

/** Monthly earnings input for one employee. */
public class PayrollEarnings {
	public final BigDecimal basicSalary;
	public final BigDecimal houseAllowance;
	public final BigDecimal transportAllowance;

	public PayrollEarnings(BigDecimal basicSalary, BigDecimal houseAllowance, BigDecimal transportAllowance) {
		this.basicSalary = basicSalary == null ? BigDecimal.ZERO : basicSalary;
		this.houseAllowance = houseAllowance == null ? BigDecimal.ZERO : houseAllowance;
		this.transportAllowance = transportAllowance == null ? BigDecimal.ZERO : transportAllowance;
	}
}
