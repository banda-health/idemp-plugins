package org.bandahealth.idempiere.base.payroll;

import java.math.BigDecimal;

/** One progressive PAYE band. upperLimit == null means the top (unbounded) band. */
public class PayeBand {
	public final BigDecimal upperLimit;
	public final BigDecimal ratePercent;

	public PayeBand(BigDecimal upperLimit, BigDecimal ratePercent) {
		this.upperLimit = upperLimit;
		this.ratePercent = ratePercent;
	}
}
