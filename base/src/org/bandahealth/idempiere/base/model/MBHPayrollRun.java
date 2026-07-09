package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

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
}
