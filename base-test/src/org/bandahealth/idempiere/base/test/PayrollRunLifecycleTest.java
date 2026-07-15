package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayrollAudit;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MBHPayrollFiling;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PayrollRunLifecycleTest extends ChuBoePopulateFactoryVO {

	private static Timestamp ts(String date) {
		return Timestamp.valueOf(date + " 00:00:00");
	}

	@IPopulateAnnotation.CanRun
	public void lockUnlockLifecycle() throws Exception {
		int clientId = Env.getAD_Client_ID(Env.getCtx());
		int departmentId = new Query(Env.getCtx(), X_HR_Department.Table_Name,
				"AD_Client_ID=? AND Name=?", get_TrxName()).setParameters(clientId, "Standard").firstId();
		int jobId = new Query(Env.getCtx(), X_HR_Job.Table_Name,
				"AD_Client_ID=? AND Name=?", get_TrxName()).setParameters(clientId, "Standard").firstId();

		// nurse vector: basic 45,000 + house 12,000 + transport 6,000 (gross 63,000, PAYE 9,346.25).
		MBPartner partner = new MBPartner(Env.getCtx(), 0, get_TrxName());
		partner.setName(getScenarioName() + "-emp");
		partner.setIsEmployee(true);
		partner.saveEx();
		MHREmployee_BH employee = new MHREmployee_BH(Env.getCtx(), 0, get_TrxName());
		employee.setC_BPartner_ID(partner.get_ID());
		employee.setName(getScenarioName() + "-emp");
		employee.setHR_Department_ID(departmentId);
		employee.setHR_Job_ID(jobId);
		employee.setStartDate(ts("2026-01-01"));
		employee.setBH_BasicSalary(new BigDecimal("45000"));
		employee.setBH_HouseAllowance(new BigDecimal("12000"));
		employee.setBH_TransportAllowance(new BigDecimal("6000"));
		employee.saveEx();

		MBHPayrollRun run = new MBHPayrollRun(Env.getCtx(), 0, get_TrxName());
		run.setBH_PayrollMonth(6);
		run.setBH_PayrollYear(2026);
		run.saveEx();

		MBHPayrollRun run2 = null;
		try {
			List<MBHPayrollComponent> catalogue = MBHPayrollComponent.getEffectiveAll(Env.getCtx(),
					clientId, run.getPeriodEnd(), get_TrxName());
			run.generateLines(catalogue);

			// --- lock ---
			run.processIt(DocAction.ACTION_Complete);
			run.saveEx();
			assertThat("locked", run.getDocStatus(), is("CO"));
			assertThat("processed", run.isProcessed(), is(true));
			assertThat("snapshot stamped", run.getBH_Components_Snapshot(),
					containsString("\"value\":\"NSSF\""));

			MBHPayrollRunLine line = new Query(Env.getCtx(), MBHPayrollRunLine.Table_Name,
					"BH_Payroll_Run_ID=?", get_TrxName()).setParameters(run.get_ID()).first();
			assertThat("line exists", line, is(notNullValue()));
			assertThat("payslip number assigned", line.getBH_PayslipNumber(), is("PS-202606-001"));

			int filings = new Query(Env.getCtx(), MBHPayrollFiling.Table_Name,
					"BH_Payroll_Run_ID=?", get_TrxName()).setParameters(run.get_ID()).count();
			assertThat("five statutory filings", filings, is(5));

			int lockAudits = new Query(Env.getCtx(), MBHPayrollAudit.Table_Name,
					"BH_Payroll_Run_ID=? AND BH_ActionType=?", get_TrxName())
					.setParameters(run.get_ID(), "PERIOD_LOCK").count();
			assertThat("lock audited", lockAudits, is(1));

			// --- write-protection: locked lines reject writes ---
			line.setBH_NetPay(BigDecimal.ONE);
			assertThrows(AdempiereException.class, line::saveEx);

			// --- paid filing blocks unlock ---
			MBHPayrollFiling paye = new Query(Env.getCtx(), MBHPayrollFiling.Table_Name,
					"BH_Payroll_Run_ID=? AND BH_FilingType=?", get_TrxName())
					.setParameters(run.get_ID(), "PAYE").first();
			assertThat("PAYE filing exists", paye, is(notNullValue()));
			paye.setBH_IsPaid(true);
			paye.setBH_PaidDate(ts("2026-07-09"));
			paye.saveEx(); // allowed: payment-only change
			assertThat("paid filing blocks unlock",
					run.processIt(DocAction.ACTION_ReActivate), is(false));

			paye.setBH_IsPaid(false);
			paye.setBH_PaidDate(null);
			paye.saveEx();

			// --- unlock ---
			assertThat("unlock succeeds", run.processIt(DocAction.ACTION_ReActivate), is(true));
			run.saveEx();
			assertThat("draft again", run.getDocStatus(), is("DR"));
			assertThat("not processed", run.isProcessed(), is(false));
			assertThat("filings cleared", new Query(Env.getCtx(), MBHPayrollFiling.Table_Name,
					"BH_Payroll_Run_ID=?", get_TrxName()).setParameters(run.get_ID()).count(), is(0));
			int unlockAudits = new Query(Env.getCtx(), MBHPayrollAudit.Table_Name,
					"BH_Payroll_Run_ID=? AND BH_ActionType=?", get_TrxName())
					.setParameters(run.get_ID(), "PERIOD_UNLOCK").count();
			assertThat("unlock audited", unlockAudits, is(1));

			// re-lock run so a later period exists as the latest completed run
			run.processIt(DocAction.ACTION_Complete);
			run.saveEx();

			// --- later completed run makes 2026-06 no longer the latest ---
			run2 = new MBHPayrollRun(Env.getCtx(), 0, get_TrxName());
			run2.setBH_PayrollMonth(7);
			run2.setBH_PayrollYear(2026);
			run2.saveEx();
			List<MBHPayrollComponent> catalogue2 = MBHPayrollComponent.getEffectiveAll(Env.getCtx(),
					clientId, run2.getPeriodEnd(), get_TrxName());
			run2.generateLines(catalogue2);
			run2.processIt(DocAction.ACTION_Complete);
			run2.saveEx();

			assertThat("stale run cannot unlock past the latest",
					run.processIt(DocAction.ACTION_ReActivate), is(false));
		} finally {
			if (run2 != null) {
				try {
					run2.processIt(DocAction.ACTION_ReActivate);
					run2.saveEx();
				} catch (Exception ignored) {
				}
				cleanupRun(run2);
			}
			try {
				run.processIt(DocAction.ACTION_ReActivate);
				run.saveEx();
			} catch (Exception ignored) {
			}
			cleanupRun(run);
			employee.deleteEx(true);
			partner.deleteEx(true);
		}
	}

	@IPopulateAnnotation.CanRun
	public void completeWithZeroActiveEmployeesIsRefused() throws Exception {
		int clientId = Env.getAD_Client_ID(Env.getCtx());
		int activeEmployees = new Query(Env.getCtx(), MHREmployee_BH.Table_Name,
				"AD_Client_ID=?", get_TrxName()).setParameters(clientId).setOnlyActiveRecords(true).count();
		assertThat("precondition: client has no active employees", activeEmployees, is(0));

		MBHPayrollRun run = new MBHPayrollRun(Env.getCtx(), 0, get_TrxName());
		run.setBH_PayrollMonth(5);
		run.setBH_PayrollYear(2026);
		run.saveEx();
		try {
			assertThat("complete refused", run.processIt(DocAction.ACTION_Complete), is(false));
			assertThat("message names the cause", run.getProcessMsg(),
					containsString("No active employees"));
			assertThat("still a draft", run.getDocStatus(), is(DocAction.STATUS_Drafted));
			assertThat("not processed", run.isProcessed(), is(false));
			assertThat("no filings created", new Query(Env.getCtx(), MBHPayrollFiling.Table_Name,
					"BH_Payroll_Run_ID=?", get_TrxName()).setParameters(run.get_ID()).count(), is(0));
			assertThat("no lock audit written", new Query(Env.getCtx(), MBHPayrollAudit.Table_Name,
					"BH_Payroll_Run_ID=? AND BH_ActionType=?", get_TrxName())
					.setParameters(run.get_ID(), "PERIOD_LOCK").count(), is(0));
		} finally {
			cleanupRun(run);
		}
	}

	private void cleanupRun(MBHPayrollRun run) {
		DB.executeUpdateEx("DELETE FROM BH_Payroll_Filing WHERE BH_Payroll_Run_ID=?",
				new Object[]{run.get_ID()}, get_TrxName());
		DB.executeUpdateEx("DELETE FROM BH_Payroll_Audit WHERE BH_Payroll_Run_ID=?",
				new Object[]{run.get_ID()}, get_TrxName());
		DB.executeUpdateEx("DELETE FROM BH_Payroll_Run_Line_Item WHERE BH_Payroll_Run_Line_ID IN "
				+ "(SELECT BH_Payroll_Run_Line_ID FROM BH_Payroll_Run_Line WHERE BH_Payroll_Run_ID=?)",
				new Object[]{run.get_ID()}, get_TrxName());
		DB.executeUpdateEx("DELETE FROM BH_Payroll_Run_Line WHERE BH_Payroll_Run_ID=?",
				new Object[]{run.get_ID()}, get_TrxName());
		run.deleteEx(true);
	}
}
