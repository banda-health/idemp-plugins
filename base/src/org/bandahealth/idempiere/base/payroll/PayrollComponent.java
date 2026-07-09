package org.bandahealth.idempiere.base.payroll;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * One resolved payroll component — the calculator's rate/deduction input row (GO-3624).
 * Statutory components (NSSF, SHIF, Housing Levy, NITA, PAYE, personal relief) are seeded
 * system-wide; voluntary ones (Sacco, pension, loans) are templates whose per-employee
 * amounts come from {@link PayrollAssignment}. A new statutory levy is a new component
 * row — never a schema change.
 */
public class PayrollComponent {

	/** Statutory deduction withheld from the employee (NSSF, SHIF, Housing Levy, PAYE). */
	public static final String CATEGORY_STATUTORY_DEDUCTION = "STAT_DED";
	/** Voluntary deduction withheld from the employee (Sacco, pension, loan). */
	public static final String CATEGORY_VOLUNTARY_DEDUCTION = "VOL_DED";
	/** Employer-only cost (NITA); no employee deduction. */
	public static final String CATEGORY_EMPLOYER_CONTRIBUTION = "EMPLOYER_CONTRIB";
	/** Reduces PAYE after band tax (monthly personal relief). */
	public static final String CATEGORY_RELIEF = "RELIEF";
	/** Reserved for custom allowances; v1 earnings are the three typed employee fields. */
	public static final String CATEGORY_EARNING = "EARNING";

	public static final String METHOD_PERCENT_OF_GROSS = "PERCENT_OF_GROSS";
	public static final String METHOD_FIXED = "FIXED";
	public static final String METHOD_TIERED = "TIERED";
	public static final String METHOD_BANDS = "BANDS";
	public static final String METHOD_EMPLOYEE_AMOUNT = "EMPLOYEE_AMOUNT";

	public final String code;
	public final String name;
	public final String category;
	public final String method;
	/** Percent for PERCENT_OF_GROSS/TIERED; the amount itself for FIXED. */
	public final BigDecimal rate;
	/** Minimum employee amount when there is pay (SHIF 300); null = none. */
	public final BigDecimal floor;
	/** Maximum employee amount; null = none. */
	public final BigDecimal cap;
	public final BigDecimal tier1Limit;
	public final BigDecimal tier2Limit;
	/** Employer-side percent (or amount for FIXED); null = no employer side. */
	public final BigDecimal employerRate;
	/** Employee amount reduces taxable income (NSSF/SHIF/Levy/pension — TLAA 2024). */
	public final boolean taxDeductible;
	/** Monthly ceiling on the deductible portion (registered pension: 30,000); null = uncapped. */
	public final BigDecimal taxDeductibleCap;
	public final int seqNo;
	/** Progressive bands, BANDS method only (PAYE). */
	public final List<PayeBand> bands;

	public PayrollComponent(String code, String name, String category, String method, BigDecimal rate,
			BigDecimal floor, BigDecimal cap, BigDecimal tier1Limit, BigDecimal tier2Limit,
			BigDecimal employerRate, boolean taxDeductible, BigDecimal taxDeductibleCap, int seqNo,
			List<PayeBand> bands) {
		this.code = code;
		this.name = name;
		this.category = category;
		this.method = method;
		this.rate = rate;
		this.floor = floor;
		this.cap = cap;
		this.tier1Limit = tier1Limit;
		this.tier2Limit = tier2Limit;
		this.employerRate = employerRate;
		this.taxDeductible = taxDeductible;
		this.taxDeductibleCap = taxDeductibleCap;
		this.seqNo = seqNo;
		this.bands = bands == null ? Collections.emptyList() : bands;
	}
}
