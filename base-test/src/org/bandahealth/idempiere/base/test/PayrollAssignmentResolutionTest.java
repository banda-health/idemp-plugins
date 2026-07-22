package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBHEmployeeComponent;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.bandahealth.idempiere.base.model.PayrollAssignment;
import org.bandahealth.idempiere.base.model.PayrollComponent;
import org.compiere.model.MBPartner;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class PayrollAssignmentResolutionTest extends ChuBoePopulateFactoryVO {

	private static Timestamp ts(String date) {
		return Timestamp.valueOf(date + " 00:00:00");
	}

	@IPopulateAnnotation.CanRun
	public void assignmentsResolveByValueAndHonorWindows() {
		int clientId = Env.getAD_Client_ID(Env.getCtx());
		Timestamp periodStart = ts("2026-07-01");
		Timestamp periodEnd = ts("2026-07-31");

		// employee scaffold: bpartner + hr_employee on the Standard dept/job
		MBPartner businessPartner = new MBPartner(Env.getCtx(), 0, get_TrxName());
		businessPartner.setName(getScenarioName());
		businessPartner.setIsEmployee(true);
		businessPartner.saveEx();
		MHREmployee_BH employee = new MHREmployee_BH(Env.getCtx(), 0, get_TrxName());
		employee.setC_BPartner_ID(businessPartner.get_ID());
		employee.setName(getScenarioName());
		employee.setHR_Department_ID(new Query(Env.getCtx(), X_HR_Department.Table_Name,
				"AD_Client_ID=? AND Name=?", get_TrxName()).setParameters(clientId, "Standard").firstId());
		employee.setHR_Job_ID(new Query(Env.getCtx(), X_HR_Job.Table_Name,
				"AD_Client_ID=? AND Name=?", get_TrxName()).setParameters(clientId, "Standard").firstId());
		employee.setStartDate(ts("2026-01-01"));
		employee.saveEx();

		MBHPayrollComponent systemSacco = new Query(Env.getCtx(), MBHPayrollComponent.Table_Name,
				"AD_Client_ID=0 AND Value=?", get_TrxName()).setParameters("SACCO").first();
		MBHPayrollComponent systemLoan = new Query(Env.getCtx(), MBHPayrollComponent.Table_Name,
				"AD_Client_ID=0 AND Value=?", get_TrxName()).setParameters("LOAN").first();

		// assignment FK → the SYSTEM SACCO row (will be superseded by the clinic override below)
		MBHEmployeeComponent sacco = new MBHEmployeeComponent(Env.getCtx(), 0, get_TrxName());
		sacco.setHR_Employee_ID(employee.get_ID());
		sacco.setBH_Payroll_Component_ID(systemSacco.get_ID());
		sacco.setBH_Amount(new BigDecimal("2500"));
		sacco.setValidFrom(ts("2026-01-01"));
		sacco.saveEx();

		// expired assignment: must be excluded by the validity window
		MBHEmployeeComponent expired = new MBHEmployeeComponent(Env.getCtx(), 0, get_TrxName());
		expired.setHR_Employee_ID(employee.get_ID());
		expired.setBH_Payroll_Component_ID(systemSacco.get_ID());
		expired.setBH_Amount(new BigDecimal("999"));
		expired.setValidFrom(ts("2025-01-01"));
		expired.setValidTo(ts("2025-12-31"));
		expired.saveEx();

		// LOAN assignment + clinic disable override: must be skipped
		MBHEmployeeComponent loan = new MBHEmployeeComponent(Env.getCtx(), 0, get_TrxName());
		loan.setHR_Employee_ID(employee.get_ID());
		loan.setBH_Payroll_Component_ID(systemLoan.get_ID());
		loan.setBH_Amount(new BigDecimal("1000"));
		loan.setValidFrom(ts("2026-01-01"));
		loan.saveEx();

		MBHPayrollComponent saccoOverride = new MBHPayrollComponent(Env.getCtx(), 0, get_TrxName());
		saccoOverride.setAD_Org_ID(0);
		saccoOverride.setValue("SACCO");
		saccoOverride.setName("Sacco (clinic)");
		saccoOverride.setBH_Category(PayrollComponent.CATEGORY_VOLUNTARY_DEDUCTION);
		saccoOverride.setBH_CalcMethod(PayrollComponent.METHOD_EMPLOYEE_AMOUNT);
		saccoOverride.setSeqNo(70);
		saccoOverride.setValidFrom(ts("2026-01-01"));
		saccoOverride.saveEx();

		MBHPayrollComponent loanDisable = new MBHPayrollComponent(Env.getCtx(), 0, get_TrxName());
		loanDisable.setAD_Org_ID(0);
		loanDisable.setValue("LOAN");
		loanDisable.setName("Loan (disabled)");
		loanDisable.setBH_Category(PayrollComponent.CATEGORY_VOLUNTARY_DEDUCTION);
		loanDisable.setBH_CalcMethod(PayrollComponent.METHOD_EMPLOYEE_AMOUNT);
		loanDisable.setSeqNo(90);
		loanDisable.setValidFrom(ts("2026-01-01"));
		loanDisable.setIsActive(false);
		loanDisable.saveEx();

		try {
			List<MBHPayrollComponent> catalogue =
					MBHPayrollComponent.getEffectiveAll(Env.getCtx(), clientId, periodEnd, get_TrxName());
			List<PayrollAssignment> resolved = MBHEmployeeComponent.resolveAssignments(Env.getCtx(),
					employee.get_ID(), catalogue, periodStart, periodEnd, get_TrxName());

			List<String> codes = resolved.stream().map(a -> a.code).collect(Collectors.toList());
			assertThat("only the live SACCO assignment resolves", codes.toString(), is("[SACCO]"));
			assertThat("amount carried from the assignment", resolved.get(0).amount,
					comparesEqualTo(new BigDecimal("2500")));
		} finally {
			sacco.deleteEx(true);
			expired.deleteEx(true);
			loan.deleteEx(true);
			saccoOverride.deleteEx(true);
			loanDisable.deleteEx(true);
			employee.deleteEx(true);
			businessPartner.deleteEx(true);
		}
	}
}
