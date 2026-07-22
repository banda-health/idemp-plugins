package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.PayeBand;
import org.bandahealth.idempiere.base.model.PayrollAssignment;
import org.bandahealth.idempiere.base.model.PayrollBreakdown;
import org.bandahealth.idempiere.base.model.PayrollCalculator;
import org.bandahealth.idempiere.base.model.PayrollComponent;
import org.bandahealth.idempiere.base.model.PayrollEarnings;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class PayrollCalculatorTest extends ChuBoePopulateFactoryVO {

	/**
	 * The 2026 component catalogue (mirrors the migration seed in Task 4):
	 * post-TLAA-2024 tax treatment as per-component deductibility flags,
	 * NSSF Year 4 limits effective 1 Feb 2026, voluntary templates included.
	 */
	private List<PayrollComponent> components2026() {
		List<PayeBand> bands = Arrays.asList(
				new PayeBand(new BigDecimal("24000"), new BigDecimal("10")),
				new PayeBand(new BigDecimal("32333"), new BigDecimal("25")),
				new PayeBand(new BigDecimal("500000"), new BigDecimal("30")),
				new PayeBand(new BigDecimal("800000"), new BigDecimal("32.5")),
				new PayeBand(null, new BigDecimal("35")));
		return Arrays.asList(
				new PayrollComponent("NSSF", "NSSF", PayrollComponent.CATEGORY_STATUTORY_DEDUCTION,
						PayrollComponent.METHOD_TIERED, kes("6"), null, null, kes("9000"), kes("108000"),
						kes("6"), true, null, 10, null),
				new PayrollComponent("SHIF", "SHIF", PayrollComponent.CATEGORY_STATUTORY_DEDUCTION,
						PayrollComponent.METHOD_PERCENT_OF_GROSS, kes("2.75"), kes("300"), null, null, null,
						null, true, null, 20, null),
				new PayrollComponent("HLEVY", "Housing Levy", PayrollComponent.CATEGORY_STATUTORY_DEDUCTION,
						PayrollComponent.METHOD_PERCENT_OF_GROSS, kes("1.5"), null, null, null, null,
						kes("1.5"), true, null, 30, null),
				new PayrollComponent("NITA", "NITA Levy", PayrollComponent.CATEGORY_EMPLOYER_CONTRIBUTION,
						PayrollComponent.METHOD_FIXED, kes("50"), null, null, null, null,
						null, false, null, 40, null),
				new PayrollComponent("PERSONAL_RELIEF", "Monthly Personal Relief", PayrollComponent.CATEGORY_RELIEF,
						PayrollComponent.METHOD_FIXED, kes("2400"), null, null, null, null,
						null, false, null, 50, null),
				new PayrollComponent("PAYE", "PAYE (income tax)", PayrollComponent.CATEGORY_STATUTORY_DEDUCTION,
						PayrollComponent.METHOD_BANDS, null, null, null, null, null,
						null, false, null, 60, bands),
				new PayrollComponent("SACCO", "Sacco", PayrollComponent.CATEGORY_VOLUNTARY_DEDUCTION,
						PayrollComponent.METHOD_EMPLOYEE_AMOUNT, null, null, null, null, null,
						null, false, null, 70, null),
				new PayrollComponent("PENSION", "Voluntary Pension", PayrollComponent.CATEGORY_VOLUNTARY_DEDUCTION,
						PayrollComponent.METHOD_EMPLOYEE_AMOUNT, null, null, null, null, null,
						null, true, kes("30000"), 80, null),
				new PayrollComponent("LOAN", "Loan Repayment", PayrollComponent.CATEGORY_VOLUNTARY_DEDUCTION,
						PayrollComponent.METHOD_EMPLOYEE_AMOUNT, null, null, null, null, null,
						null, false, null, 90, null));
	}

	private static BigDecimal kes(String v) {
		return new BigDecimal(v);
	}

	private static List<PayrollAssignment> none() {
		return Collections.emptyList();
	}

	@IPopulateAnnotation.CanRun
	public void nursePlainCase() {
		// basic 45,000 + house 12,000 + transport 6,000 = gross 63,000
		PayrollBreakdown r = PayrollCalculator.calculate(
				new PayrollEarnings(kes("45000"), kes("12000"), kes("6000")), components2026(), none());
		assertThat("gross", r.grossPay, comparesEqualTo(kes("63000")));
		assertThat("NSSF = 6%*9,000 + 6%*54,000", r.item("NSSF").employeeAmount, comparesEqualTo(kes("3780")));
		assertThat("SHIF = 2.75% of 63,000 (cents kept)", r.item("SHIF").employeeAmount,
				comparesEqualTo(kes("1732.50")));
		assertThat("levy = 1.5% of 63,000", r.item("HLEVY").employeeAmount, comparesEqualTo(kes("945")));
		assertThat("taxable = 63,000 - 3,780 - 1,732.50 - 945", r.taxablePay, comparesEqualTo(kes("56542.50")));
		// bands on whole-shilling taxable 56,543: 2,400 + 2,083.25 + 30%*24,210 = 11,746.25
		assertThat("tax before relief", r.grossTax, comparesEqualTo(kes("11746.25")));
		assertThat("PAYE after relief", r.payeAmount, comparesEqualTo(kes("9346.25")));
		assertThat("total deductions", r.totalDeductions, comparesEqualTo(kes("15803.75")));
		assertThat("net", r.netPay, comparesEqualTo(kes("47196.25")));
		assertThat("employer NSSF mirrors employee", r.item("NSSF").employerAmount, comparesEqualTo(kes("3780")));
		assertThat("NITA employer-only", r.item("NITA").employerAmount, comparesEqualTo(kes("50")));
		assertThat("NITA has no employee side", r.item("NITA").employeeAmount, comparesEqualTo(kes("0")));
		assertThat("cost to employer = 63,000+3,780+945+50", r.costToEmployer, comparesEqualTo(kes("67775")));
		assertThat("unassigned EMPLOYEE_AMOUNT component produces no item", r.item("SACCO"), is(nullValue()));
	}

	@IPopulateAnnotation.CanRun
	public void shifMinimumApplies() {
		// gross 9,000: SHIF raw 247.50 < 300 floor
		PayrollBreakdown r = PayrollCalculator.calculate(
				new PayrollEarnings(kes("9000"), BigDecimal.ZERO, BigDecimal.ZERO), components2026(), none());
		assertThat("SHIF floored to component minimum", r.item("SHIF").employeeAmount, comparesEqualTo(kes("300")));
	}

	@IPopulateAnnotation.CanRun
	public void nssfCapReached() {
		// gross 120,000 > UEL 108,000: 540 + 6%*99,000 = 6,480 (Year 4 max, both sides)
		PayrollBreakdown r = PayrollCalculator.calculate(
				new PayrollEarnings(kes("100000"), kes("14000"), kes("6000")), components2026(), none());
		assertThat("NSSF capped", r.item("NSSF").employeeAmount, comparesEqualTo(kes("6480")));
		assertThat("employer matches at cap", r.item("NSSF").employerAmount, comparesEqualTo(kes("6480")));
	}

	@IPopulateAnnotation.CanRun
	public void personalReliefFloorsPayeAtZero() {
		// gross 16,000: NSSF 960, SHIF 440, levy 240 → taxable 14,360, tax 1,436 < relief 2,400 → PAYE 0
		PayrollBreakdown r = PayrollCalculator.calculate(
				new PayrollEarnings(kes("16000"), BigDecimal.ZERO, BigDecimal.ZERO), components2026(), none());
		assertThat("SHIF = max(440, 300)", r.item("SHIF").employeeAmount, comparesEqualTo(kes("440")));
		assertThat("taxable after deductible components", r.taxablePay, comparesEqualTo(kes("14360")));
		assertThat("PAYE floored at zero", r.payeAmount, comparesEqualTo(kes("0")));
		assertThat("net", r.netPay, comparesEqualTo(kes("14360"))); // 16,000 - (960+440+240)
	}

	@IPopulateAnnotation.CanRun
	public void bandsRunOnWholeShillingTaxable() {
		// gross 26,740: NSSF 1,604.40, SHIF 735.35, levy 401.10 → taxable 23,999.15.
		// Bands run on 23,999 (whole-shilling, verified payslip behaviour) → 10% only.
		PayrollBreakdown r = PayrollCalculator.calculate(
				new PayrollEarnings(kes("26740"), BigDecimal.ZERO, BigDecimal.ZERO), components2026(), none());
		assertThat("taxable keeps cents", r.taxablePay, comparesEqualTo(kes("23999.15")));
		assertThat("band tax on rounded taxable stays in first band", r.grossTax, comparesEqualTo(kes("2399.90")));
	}

	@IPopulateAnnotation.CanRun
	public void zeroSalary() {
		PayrollBreakdown r = PayrollCalculator.calculate(
				new PayrollEarnings(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO), components2026(),
				Arrays.asList(new PayrollAssignment("SACCO", kes("5000"))));
		assertThat("gross", r.grossPay, comparesEqualTo(kes("0")));
		assertThat("no pay, no items (even assigned ones)", r.items.isEmpty(), is(true));
		assertThat("PAYE", r.payeAmount, comparesEqualTo(kes("0")));
		assertThat("net", r.netPay, comparesEqualTo(kes("0")));
		assertThat("cost to employer", r.costToEmployer, comparesEqualTo(kes("0")));
	}

	@IPopulateAnnotation.CanRun
	public void saccoIsNotDeductibleButPensionIs() {
		// Same gross, same amount — once as Sacco (taxable untouched), once as pension (taxable reduced)
		PayrollEarnings earnings = new PayrollEarnings(kes("100000"), BigDecimal.ZERO, BigDecimal.ZERO);
		PayrollBreakdown sacco = PayrollCalculator.calculate(earnings, components2026(),
				Arrays.asList(new PayrollAssignment("SACCO", kes("5000"))));
		PayrollBreakdown pension = PayrollCalculator.calculate(earnings, components2026(),
				Arrays.asList(new PayrollAssignment("PENSION", kes("5000"))));
		assertThat("sacco leaves taxable alone", sacco.taxablePay, comparesEqualTo(kes("89750")));
		assertThat("pension reduces taxable by its amount", pension.taxablePay, comparesEqualTo(kes("84750")));
		assertThat("both reduce net by the same deduction", sacco.item("SACCO").employeeAmount,
				comparesEqualTo(pension.item("PENSION").employeeAmount));
	}

	@IPopulateAnnotation.CanRun
	public void pensionDeductibleCapKicksIn() {
		// gross 100,000, pension 35,000: only 30,000 reduces taxable; all 35,000 leaves net
		PayrollBreakdown r = PayrollCalculator.calculate(
				new PayrollEarnings(kes("100000"), BigDecimal.ZERO, BigDecimal.ZERO), components2026(),
				Arrays.asList(new PayrollAssignment("PENSION", kes("35000"))));
		// NSSF 6,000 + SHIF 2,750 + levy 1,500 + capped pension 30,000 off taxable
		assertThat("taxable = 100,000 - 6,000 - 2,750 - 1,500 - 30,000", r.taxablePay,
				comparesEqualTo(kes("59750")));
		assertThat("full pension amount still deducted from pay", r.item("PENSION").employeeAmount,
				comparesEqualTo(kes("35000")));
		// bands on 59,750: 2,400 + 2,083.25 + 30%*27,417 = 12,708.35 → PAYE 10,308.35
		assertThat("PAYE", r.payeAmount, comparesEqualTo(kes("10308.35")));
		assertThat("net", r.netPay, comparesEqualTo(kes("44441.65")));
	}

	/**
	 * Real payslip vector (SIM Kenya, June 2026, verified line by line): proves the
	 * component flags reproduce production payroll output to the cent — Sacco outside
	 * taxable, pension inside, bands on whole-shilling taxable, relief after band tax.
	 */
	@IPopulateAnnotation.CanRun
	public void reproducesRealJune2026Payslip() {
		PayrollBreakdown r = PayrollCalculator.calculate(
				new PayrollEarnings(kes("242969"), kes("48594"), kes("5500")), components2026(),
				Arrays.asList(new PayrollAssignment("SACCO", kes("51675")),
						new PayrollAssignment("PENSION", kes("3000"))));
		assertThat("gross", r.grossPay, comparesEqualTo(kes("297063")));
		assertThat("NSSF at Year-4 cap", r.item("NSSF").employeeAmount, comparesEqualTo(kes("6480")));
		assertThat("SHIF 2.75%", r.item("SHIF").employeeAmount, comparesEqualTo(kes("8169.23")));
		assertThat("Housing Levy 1.5%", r.item("HLEVY").employeeAmount, comparesEqualTo(kes("4455.95")));
		assertThat("taxable = gross - NSSF - SHIF - levy - pension (Sacco excluded)", r.taxablePay,
				comparesEqualTo(kes("274957.82")));
		assertThat("tax before relief", r.grossTax, comparesEqualTo(kes("77270.75")));
		assertThat("PAYE", r.payeAmount, comparesEqualTo(kes("74870.75")));
		assertThat("net pay", r.netPay, comparesEqualTo(kes("148412.07")));
		assertThat("payslip has a PAYE line item", r.item("PAYE"), is(notNullValue()));
	}
}
