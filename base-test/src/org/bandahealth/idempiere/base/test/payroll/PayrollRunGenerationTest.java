package org.bandahealth.idempiere.base.test.payroll;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLineItem;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.bandahealth.idempiere.base.payroll.ComponentSnapshotJson;
import org.bandahealth.idempiere.base.payroll.PayeBand;
import org.bandahealth.idempiere.base.payroll.PayrollComponent;
import org.compiere.model.MBPartner;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.greaterThan;

public class PayrollRunGenerationTest extends ChuBoePopulateFactoryVO {

	private static Timestamp ts(String date) {
		return Timestamp.valueOf(date + " 00:00:00");
	}

	@IPopulateAnnotation.CanRun
	public void runLinesComputeFromLiveData() {
		int clientId = Env.getAD_Client_ID(Env.getCtx());
		int departmentId = new Query(Env.getCtx(), X_HR_Department.Table_Name,
				"AD_Client_ID=? AND Name=?", get_TrxName()).setParameters(clientId, "Standard").firstId();
		int jobId = new Query(Env.getCtx(), X_HR_Job.Table_Name,
				"AD_Client_ID=? AND Name=?", get_TrxName()).setParameters(clientId, "Standard").firstId();

		// active employee: basic 45,000 + house 12,000 + transport 6,000 — the calculator's nurse
		// vector (gross 63,000, PAYE 9,346.25, net 47,196.25) so the expected figures are known-good.
		MBPartner activePartner = new MBPartner(Env.getCtx(), 0, get_TrxName());
		activePartner.setName(getScenarioName() + "-active");
		activePartner.setIsEmployee(true);
		activePartner.saveEx();
		MHREmployee_BH activeEmployee = new MHREmployee_BH(Env.getCtx(), 0, get_TrxName());
		activeEmployee.setC_BPartner_ID(activePartner.get_ID());
		activeEmployee.setName(getScenarioName() + "-active");
		activeEmployee.setHR_Department_ID(departmentId);
		activeEmployee.setHR_Job_ID(jobId);
		activeEmployee.setStartDate(ts("2026-01-01"));
		activeEmployee.setBH_BasicSalary(new BigDecimal("45000"));
		activeEmployee.setBH_HouseAllowance(new BigDecimal("12000"));
		activeEmployee.setBH_TransportAllowance(new BigDecimal("6000"));
		activeEmployee.saveEx();

		// deactivated employee: same window, same salary — must NOT produce a line.
		MBPartner deactivatedPartner = new MBPartner(Env.getCtx(), 0, get_TrxName());
		deactivatedPartner.setName(getScenarioName() + "-deactivated");
		deactivatedPartner.setIsEmployee(true);
		deactivatedPartner.saveEx();
		MHREmployee_BH deactivatedEmployee = new MHREmployee_BH(Env.getCtx(), 0, get_TrxName());
		deactivatedEmployee.setC_BPartner_ID(deactivatedPartner.get_ID());
		deactivatedEmployee.setName(getScenarioName() + "-deactivated");
		deactivatedEmployee.setHR_Department_ID(departmentId);
		deactivatedEmployee.setHR_Job_ID(jobId);
		deactivatedEmployee.setStartDate(ts("2026-01-01"));
		deactivatedEmployee.setBH_BasicSalary(new BigDecimal("45000"));
		deactivatedEmployee.setBH_HouseAllowance(new BigDecimal("12000"));
		deactivatedEmployee.setBH_TransportAllowance(new BigDecimal("6000"));
		deactivatedEmployee.setIsActive(false);
		deactivatedEmployee.saveEx();

		MBHPayrollRun run = new MBHPayrollRun(Env.getCtx(), 0, get_TrxName());
		run.setBH_PayrollMonth(7);
		run.setBH_PayrollYear(2026);
		run.saveEx();

		try {
			List<MBHPayrollComponent> catalogue = MBHPayrollComponent.getEffectiveAll(Env.getCtx(),
					clientId, run.getPeriodEnd(), get_TrxName());
			int lineCount = run.generateLines(catalogue);
			assertThat("one line per ACTIVE employee", lineCount, is(1));

			MBHPayrollRunLine line = new Query(Env.getCtx(), MBHPayrollRunLine.Table_Name,
					"BH_Payroll_Run_ID=?", get_TrxName()).setParameters(run.get_ID()).first();
			assertThat("line exists for the active employee", line, is(notNullValue()));
			assertThat(line.getBH_GrossPay(), comparesEqualTo(new BigDecimal("63000")));
			assertThat(line.getBH_PAYE_Amount(), comparesEqualTo(new BigDecimal("9346.25")));
			assertThat(line.getBH_NetPay(), comparesEqualTo(new BigDecimal("47196.25")));

			int itemCount = new Query(Env.getCtx(), MBHPayrollRunLineItem.Table_Name,
					"BH_Payroll_Run_Line_ID=?", get_TrxName()).setParameters(line.get_ID()).count();
			// NSSF+SHIF+HLEVY+NITA+PAYE. PERSONAL_RELIEF is CATEGORY_RELIEF: PayrollCalculator only
			// folds it into r.payeAmount (the relief-after-band-tax step) and never adds it to
			// r.items, so it does not become a line item (verified in PayrollCalculator source).
			assertThat("NSSF+SHIF+HLEVY+NITA+PAYE items", itemCount, is(5));

			// SeqNo must preserve the calculator's render order (components sorted by seqNo,
			// PAYE appended last) — a consumer ordering payslip lines by SeqNo must not see
			// DB-arbitrary tiebreak order. The effective NSSF row as-of 2026-07-31 is the
			// Year-4 override (migration seq=7 -> seqno=70), which sorts AFTER SHIF(20)/
			// HLEVY(30)/NITA(40) — confirmed against the actual seeded catalogue, not assumed.
			List<MBHPayrollRunLineItem> orderedItems = new Query(Env.getCtx(), MBHPayrollRunLineItem.Table_Name,
					"BH_Payroll_Run_Line_ID=?", get_TrxName()).setParameters(line.get_ID())
					.setOrderBy(MBHPayrollRunLineItem.COLUMNNAME_SeqNo).list();
			List<String> orderedCodes = orderedItems.stream().map(MBHPayrollRunLineItem::getValue)
					.collect(Collectors.toList());
			assertThat("items ordered by SeqNo follow calculator render order", orderedCodes,
					is(Arrays.asList("SHIF", "HLEVY", "NITA", "NSSF", "PAYE")));
			int previousSeqNo = 0;
			for (MBHPayrollRunLineItem orderedItem : orderedItems) {
				assertThat("SeqNo is non-zero and strictly increasing", orderedItem.getSeqNo(),
						greaterThan(previousSeqNo));
				previousSeqNo = orderedItem.getSeqNo();
			}

			assertThat("regeneration is idempotent", run.generateLines(catalogue), is(1));
			int itemCountAfterRegeneration = new Query(Env.getCtx(), MBHPayrollRunLineItem.Table_Name,
					"BH_Payroll_Run_Line_ID IN (SELECT BH_Payroll_Run_Line_ID FROM BH_Payroll_Run_Line "
							+ "WHERE BH_Payroll_Run_ID=?)", get_TrxName())
					.setParameters(run.get_ID()).count();
			assertThat("regeneration does not duplicate items", itemCountAfterRegeneration, is(5));

			List<PayrollComponent> specs = catalogue.stream()
					.map(component -> component.toSpec(get_TrxName())).collect(Collectors.toList());
			String snapshot = ComponentSnapshotJson.toJson(specs);
			assertThat("snapshot carries the NSSF component", snapshot, containsString("\"value\":\"NSSF\""));
		} finally {
			DB.executeUpdateEx("DELETE FROM BH_Payroll_Run_Line_Item WHERE BH_Payroll_Run_Line_ID IN "
					+ "(SELECT BH_Payroll_Run_Line_ID FROM BH_Payroll_Run_Line WHERE BH_Payroll_Run_ID=?)",
					new Object[]{run.get_ID()}, get_TrxName());
			DB.executeUpdateEx("DELETE FROM BH_Payroll_Run_Line WHERE BH_Payroll_Run_ID=?",
					new Object[]{run.get_ID()}, get_TrxName());
			run.deleteEx(true);
			deactivatedEmployee.deleteEx(true);
			deactivatedPartner.deleteEx(true);
			activeEmployee.deleteEx(true);
			activePartner.deleteEx(true);
		}
	}

	@IPopulateAnnotation.CanRun
	public void componentSnapshotJsonIsDeterministic() {
		List<PayeBand> bands = Collections.singletonList(new PayeBand(new BigDecimal("24000"), new BigDecimal("10")));
		PayrollComponent component = new PayrollComponent("NSSF", "NSSF \"Contribution\" \\ Levy",
				PayrollComponent.CATEGORY_STATUTORY_DEDUCTION, PayrollComponent.METHOD_TIERED,
				new BigDecimal("6"), null, null, new BigDecimal("9000"), new BigDecimal("108000"),
				new BigDecimal("6"), true, null, 10, bands);

		String json = ComponentSnapshotJson.toJson(Collections.singletonList(component));

		assertThat("contains the code field", json, containsString("\"value\":\"NSSF\""));
		String expected = "[{\"value\":\"NSSF\",\"name\":\"NSSF \\\"Contribution\\\" \\\\ Levy\",\"category\":\"STAT_DED\","
				+ "\"method\":\"TIERED\",\"rate\":6,\"floor\":null,\"cap\":null,\"tier1Limit\":9000,\"tier2Limit\":108000,"
				+ "\"employerRate\":6,\"taxDeductible\":true,\"taxDeductibleCap\":null,\"seqNo\":10,"
				+ "\"bands\":[{\"upperLimit\":24000,\"rate\":10}]}]";
		assertThat("exact deterministic JSON for a one-component list", json, is(expected));

		String jsonAgain = ComponentSnapshotJson.toJson(Collections.singletonList(component));
		assertThat("stable across calls (parse-roundtrip stable)", jsonAgain, is(json));
	}
}
