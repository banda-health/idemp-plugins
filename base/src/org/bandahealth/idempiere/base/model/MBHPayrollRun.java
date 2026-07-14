package org.bandahealth.idempiere.base.model;

import org.bandahealth.idempiere.base.payroll.PayrollAssignment;
import org.bandahealth.idempiere.base.payroll.PayrollBreakdown;
import org.bandahealth.idempiere.base.payroll.PayrollCalculator;
import org.bandahealth.idempiere.base.payroll.PayrollComponent;
import org.bandahealth.idempiere.base.payroll.PayrollEarnings;
import org.bandahealth.idempiere.base.payroll.PayrollLineItem;
import org.compiere.model.Query;
import org.compiere.util.DB;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class MBHPayrollRun extends X_BH_Payroll_Run {

	public MBHPayrollRun(Properties ctx, int BH_Payroll_Run_ID, String trxName) {
		super(ctx, BH_Payroll_Run_ID, trxName);
	}

	public MBHPayrollRun(Properties ctx, int BH_Payroll_Run_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Run_ID, trxName, virtualColumns);
	}

	public MBHPayrollRun(Properties ctx, String BH_Payroll_Run_UU, String trxName) {
		super(ctx, BH_Payroll_Run_UU, trxName);
	}

	public MBHPayrollRun(Properties ctx, String BH_Payroll_Run_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Run_UU, trxName, virtualColumns);
	}

	public MBHPayrollRun(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public Timestamp getPeriodStart() {
		return Timestamp.valueOf(LocalDate.of(getBH_PayrollYear(), getBH_PayrollMonth(), 1).atStartOfDay());
	}

	public Timestamp getPeriodEnd() {
		return Timestamp.valueOf(LocalDate.of(getBH_PayrollYear(), getBH_PayrollMonth(), 1)
				.plusMonths(1).minusDays(1).atStartOfDay());
	}

	/** Recompute all lines from live employee data + the resolved catalogue. Draft-state only. */
	public int generateLines(List<MBHPayrollComponent> effectiveCatalogue) {
		// wipe: items first (FK), then lines
		DB.executeUpdateEx("DELETE FROM BH_Payroll_Run_Line_Item WHERE BH_Payroll_Run_Line_ID IN "
				+ "(SELECT BH_Payroll_Run_Line_ID FROM BH_Payroll_Run_Line WHERE BH_Payroll_Run_ID=?)",
				new Object[]{get_ID()}, get_TrxName());
		DB.executeUpdateEx("DELETE FROM BH_Payroll_Run_Line WHERE BH_Payroll_Run_ID=?",
				new Object[]{get_ID()}, get_TrxName());

		List<PayrollComponent> specs = effectiveCatalogue.stream()
				.map(component -> component.toSpec(get_TrxName())).collect(Collectors.toList());
		List<MHREmployee_BH> employees = new Query(getCtx(), MHREmployee_BH.Table_Name,
				MHREmployee_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MHREmployee_BH.COLUMNNAME_StartDate
						+ "<=? AND (" + MHREmployee_BH.COLUMNNAME_EndDate + " IS NULL OR "
						+ MHREmployee_BH.COLUMNNAME_EndDate + ">=?)", get_TrxName())
				.setParameters(getAD_Client_ID(), getPeriodEnd(), getPeriodStart())
				.setOnlyActiveRecords(true)
				.setOrderBy(MHREmployee_BH.COLUMNNAME_Name)
				.list();
		for (MHREmployee_BH employee : employees) {
			PayrollEarnings earnings = new PayrollEarnings(employee.getBH_BasicSalary(),
					employee.getBH_HouseAllowance(), employee.getBH_TransportAllowance());
			List<PayrollAssignment> assignments = MBHEmployeeComponent.resolveAssignments(getCtx(),
					employee.get_ID(), effectiveCatalogue, getPeriodStart(), getPeriodEnd(), get_TrxName());
			PayrollBreakdown breakdown = PayrollCalculator.calculate(earnings, specs, assignments);

			MBHPayrollRunLine line = new MBHPayrollRunLine(getCtx(), 0, get_TrxName());
			line.setBH_Payroll_Run_ID(get_ID());
			line.setHR_Employee_ID(employee.get_ID());
			line.setBH_EmployeeName(employee.getName());
			line.setBH_KRA_PIN(employee.getBH_KRA_PIN());
			// NSSF number is core's SSCode (Social Security Code) — no separate BH_ column on HR_Employee.
			line.setBH_NSSF_Number(employee.getSSCode());
			line.setBH_SHIF_Number(employee.getBH_SHIF_Number());
			line.setBH_BasicSalary(earnings.basicSalary);
			line.setBH_HouseAllowance(earnings.houseAllowance);
			line.setBH_TransportAllowance(earnings.transportAllowance);
			line.setBH_GrossPay(breakdown.grossPay);
			line.setBH_TaxablePay(breakdown.taxablePay);
			line.setBH_PAYE_Amount(breakdown.payeAmount);
			line.setBH_TotalDeductions(breakdown.totalDeductions);
			line.setBH_NetPay(breakdown.netPay);
			line.setBH_CostToEmployer(breakdown.costToEmployer);
			line.saveEx();

			for (PayrollLineItem item : breakdown.items) {
				MBHPayrollRunLineItem lineItem = new MBHPayrollRunLineItem(getCtx(), 0, get_TrxName());
				lineItem.setBH_Payroll_Run_Line_ID(line.get_ID());
				lineItem.setValue(item.code);
				lineItem.setName(item.name);
				lineItem.setBH_Category(item.category);
				lineItem.setBH_IsTaxDeductible(item.taxDeductible);
				lineItem.setBH_EmployeeAmount(item.employeeAmount);
				lineItem.setBH_EmployerAmount(item.employerAmount);
				lineItem.saveEx();
			}
		}
		return employees.size();
	}
}
