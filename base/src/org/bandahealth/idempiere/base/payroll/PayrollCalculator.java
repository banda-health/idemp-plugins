package org.bandahealth.idempiere.base.payroll;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Component-driven Kenyan payroll engine (GO-3624). Pure math — no PO/DB access.
 * Single source of truth for preview, draft lines, and period locking.
 *
 * Statutory rules are data (PayrollComponent rows), not code: post-TLAA-2024 tax
 * treatment is the per-component taxDeductible flag + cap. Verified against a real
 * 2026 payslip: deductions carry cents (2dp HALF_UP); progressive bands run on
 * taxable income rounded to the whole shilling; relief subtracts after band tax.
 */
public class PayrollCalculator {

	private static final BigDecimal HUNDRED = new BigDecimal("100");

	public static PayrollBreakdown calculate(PayrollEarnings earnings, List<PayrollComponent> components,
			List<PayrollAssignment> assignments) {
		PayrollBreakdown r = new PayrollBreakdown();
		BigDecimal gross = earnings.basicSalary.add(earnings.houseAllowance).add(earnings.transportAllowance);
		r.grossPay = r2(gross);
		boolean hasPay = gross.signum() > 0;

		Map<String, BigDecimal> amountByCode = new HashMap<>();
		for (PayrollAssignment assignment : assignments) {
			amountByCode.put(assignment.code, assignment.amount);
		}

		List<PayrollComponent> ordered = new ArrayList<>(components);
		ordered.sort(Comparator.comparingInt(component -> component.seqNo));

		// Pass 1: every deduction/contribution except PAYE (BANDS) and reliefs — no pay, no items.
		PayrollComponent payeComponent = null;
		BigDecimal deductibleFromTaxable = BigDecimal.ZERO;
		BigDecimal totalEmployeeDeductions = BigDecimal.ZERO;
		BigDecimal totalEmployerAmount = BigDecimal.ZERO;
		List<PayrollComponent> reliefs = new ArrayList<>();
		for (PayrollComponent component : ordered) {
			if (PayrollComponent.METHOD_BANDS.equals(component.method)) {
				payeComponent = component;
				continue;
			}
			if (PayrollComponent.CATEGORY_RELIEF.equals(component.category)) {
				reliefs.add(component);
				continue;
			}
			if (PayrollComponent.CATEGORY_EARNING.equals(component.category) || !hasPay) {
				continue;
			}
			BigDecimal employeeAmount;
			BigDecimal employerAmount;
			if (PayrollComponent.CATEGORY_EMPLOYER_CONTRIBUTION.equals(component.category)) {
				employeeAmount = BigDecimal.ZERO;
				employerAmount = r2(baseAmount(component, component.rate, gross, amountByCode));
			} else {
				BigDecimal raw = baseAmount(component, component.rate, gross, amountByCode);
				if (raw == null) {
					continue; // EMPLOYEE_AMOUNT component with no assignment for this employee
				}
				if (component.floor != null && raw.compareTo(component.floor) < 0) {
					raw = component.floor;
				}
				if (component.cap != null && raw.compareTo(component.cap) > 0) {
					raw = component.cap;
				}
				employeeAmount = r2(raw);
				employerAmount = component.employerRate == null ? zero()
						: r2(baseAmount(component, component.employerRate, gross, amountByCode));
			}
			r.items.add(new PayrollLineItem(component.code, component.name, component.category,
					component.taxDeductible, employeeAmount, employerAmount));
			totalEmployeeDeductions = totalEmployeeDeductions.add(employeeAmount);
			totalEmployerAmount = totalEmployerAmount.add(employerAmount);
			if (component.taxDeductible) {
				BigDecimal deductible = component.taxDeductibleCap == null ? employeeAmount
						: employeeAmount.min(component.taxDeductibleCap);
				deductibleFromTaxable = deductibleFromTaxable.add(deductible);
			}
		}

		r.taxablePay = r2(gross.subtract(deductibleFromTaxable).max(BigDecimal.ZERO));

		// PAYE: bands run on taxable rounded to the whole shilling (verified payslip behaviour),
		// relief subtracts after band tax, floored at zero.
		BigDecimal bandable = r.taxablePay.setScale(0, RoundingMode.HALF_UP);
		r.grossTax = payeComponent == null || !hasPay ? zero() : r2(bandTax(payeComponent.bands, bandable));
		BigDecimal relief = BigDecimal.ZERO;
		for (PayrollComponent component : reliefs) {
			if (hasPay && component.rate != null) {
				relief = relief.add(component.rate);
			}
		}
		r.totalRelief = r2(relief);
		r.payeAmount = r.grossTax.subtract(r.totalRelief).max(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
		if (payeComponent != null && hasPay) {
			r.items.add(new PayrollLineItem(payeComponent.code, payeComponent.name, payeComponent.category,
					false, r.payeAmount, zero()));
		}

		r.totalDeductions = r2(totalEmployeeDeductions.add(r.payeAmount));
		r.netPay = r.grossPay.subtract(r.totalDeductions);
		r.costToEmployer = r.grossPay.add(r2(totalEmployerAmount));
		return r;
	}

	/** The method-specific amount for one side of a component; null = component does not apply. */
	private static BigDecimal baseAmount(PayrollComponent component, BigDecimal rate, BigDecimal gross,
			Map<String, BigDecimal> amountByCode) {
		switch (component.method) {
			case PayrollComponent.METHOD_PERCENT_OF_GROSS:
				return pct(rate, gross);
			case PayrollComponent.METHOD_TIERED:
				BigDecimal tier1Base = gross.min(component.tier1Limit);
				BigDecimal tier2Base = gross.min(component.tier2Limit).subtract(component.tier1Limit)
						.max(BigDecimal.ZERO);
				return pct(rate, tier1Base).add(pct(rate, tier2Base));
			case PayrollComponent.METHOD_FIXED:
				return rate;
			case PayrollComponent.METHOD_EMPLOYEE_AMOUNT:
				return amountByCode.get(component.code);
			default:
				return BigDecimal.ZERO;
		}
	}

	private static BigDecimal bandTax(List<PayeBand> bands, BigDecimal taxable) {
		BigDecimal tax = BigDecimal.ZERO;
		BigDecimal lower = BigDecimal.ZERO;
		for (PayeBand band : bands) {
			BigDecimal upper = band.upperLimit == null ? taxable : band.upperLimit.min(taxable);
			if (upper.compareTo(lower) > 0) {
				tax = tax.add(pct(band.ratePercent, upper.subtract(lower)));
			}
			if (band.upperLimit == null || taxable.compareTo(band.upperLimit) <= 0) {
				break;
			}
			lower = band.upperLimit;
		}
		return tax;
	}

	private static BigDecimal pct(BigDecimal ratePercent, BigDecimal base) {
		return ratePercent.multiply(base).divide(HUNDRED);
	}

	private static BigDecimal r2(BigDecimal v) {
		return v.setScale(2, RoundingMode.HALF_UP);
	}

	private static BigDecimal zero() {
		return BigDecimal.ZERO.setScale(2);
	}
}
