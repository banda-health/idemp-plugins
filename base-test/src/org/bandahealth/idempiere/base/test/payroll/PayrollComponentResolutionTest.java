package org.bandahealth.idempiere.base.test.payroll;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.payroll.PayrollComponent;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class PayrollComponentResolutionTest extends ChuBoePopulateFactoryVO {

	// A client id with no component rows: keeps the no-override cases independent of
	// whatever the override test (or a prior run) does against the login client.
	private static final int CLINIC_WITHOUT_OVERRIDES = 999999999;

	private static Timestamp ts(String date) {
		return Timestamp.valueOf(date + " 00:00:00");
	}

	private Map<String, MBHPayrollComponent> resolveByCode(int clientId, String asOf) {
		return MBHPayrollComponent.getEffectiveAll(Env.getCtx(), clientId, ts(asOf), get_TrxName()).stream()
				.collect(Collectors.toMap(MBHPayrollComponent::getValue, Function.identity()));
	}

	@IPopulateAnnotation.CanRun
	public void seededCatalogueResolves() {
		Map<String, MBHPayrollComponent> byCode = resolveByCode(CLINIC_WITHOUT_OVERRIDES, "2026-07-01");
		assertThat("one component per seeded code (two NSSF regimes collapse)", byCode.size(), is(9));
		for (MBHPayrollComponent component : byCode.values()) {
			assertThat("no overrides, so every row is the System row: " + component.getValue(),
					component.getAD_Client_ID(), is(0));
		}
		assertThat("NSSF resolves to the Year-4 regime at 2026-07-01",
				byCode.get("NSSF").getBH_Tier1_Limit(), comparesEqualTo(new BigDecimal("9000")));
	}

	@IPopulateAnnotation.CanRun
	public void clinicOverrideWinsPerCode() {
		int clinicId = Env.getAD_Client_ID(Env.getCtx());
		// a new PO takes AD_Client_ID from the login context, i.e. clinicId
		MBHPayrollComponent override = new MBHPayrollComponent(Env.getCtx(), 0, get_TrxName());
		override.setAD_Org_ID(0);
		override.setValue("SHIF");
		override.setName("SHIF (clinic override)");
		override.setBH_Category(PayrollComponent.CATEGORY_STATUTORY_DEDUCTION);
		override.setBH_CalcMethod(PayrollComponent.METHOD_PERCENT_OF_GROSS);
		override.setBH_Rate(new BigDecimal("3"));
		override.setBH_IsTaxDeductible(true);
		override.setSeqNo(20);
		override.setValidFrom(ts("2026-01-01"));
		override.saveEx();
		try {
			Map<String, MBHPayrollComponent> byCode = resolveByCode(clinicId, "2026-07-01");
			assertThat("SHIF resolves to the clinic row", byCode.get("SHIF").getAD_Client_ID(), is(clinicId));
			assertThat("clinic SHIF rate wins", byCode.get("SHIF").getBH_Rate(), comparesEqualTo(new BigDecimal("3")));
			assertThat("NSSF still resolves to System", byCode.get("NSSF").getAD_Client_ID(), is(0));
			assertThat("HLEVY still resolves to System", byCode.get("HLEVY").getAD_Client_ID(), is(0));
			assertThat("PAYE still resolves to System", byCode.get("PAYE").getAD_Client_ID(), is(0));
		} finally {
			override.deleteEx(true);
		}
	}

	@IPopulateAnnotation.CanRun
	public void earlierRegimeSelectedByDate() {
		Map<String, MBHPayrollComponent> byCode = resolveByCode(CLINIC_WITHOUT_OVERRIDES, "2025-06-01");
		assertThat("NSSF resolves to the Year-3 regime before 2026-02-01",
				byCode.get("NSSF").getBH_Tier1_Limit(), comparesEqualTo(new BigDecimal("8000")));
	}

	@IPopulateAnnotation.CanRun
	public void toSpecLoadsBands() {
		Map<String, MBHPayrollComponent> byCode = resolveByCode(CLINIC_WITHOUT_OVERRIDES, "2026-07-01");
		PayrollComponent paye = byCode.get("PAYE").toSpec(get_TrxName());
		assertThat("PAYE uses the BANDS method", paye.method, is(PayrollComponent.METHOD_BANDS));
		assertThat("five seeded bands", paye.bands.size(), is(5));
		List<BigDecimal> rates = paye.bands.stream().map(band -> band.ratePercent).collect(Collectors.toList());
		assertThat("bands come back in seqno order", rates.toString(), is("[10, 25, 30, 32.5, 35]"));
		assertThat("first band upper limit", paye.bands.get(0).upperLimit, comparesEqualTo(new BigDecimal("24000")));
		assertThat("top band upper limit stays null (no ZERO coercion)", paye.bands.get(4).upperLimit,
				is(nullValue()));
	}
}
