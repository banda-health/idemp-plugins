package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayrollRunLine extends X_BH_Payroll_Run_Line {

	public MBHPayrollRunLine(Properties ctx, int BH_Payroll_Run_Line_ID, String trxName) {
		super(ctx, BH_Payroll_Run_Line_ID, trxName);
	}

	public MBHPayrollRunLine(Properties ctx, int BH_Payroll_Run_Line_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Run_Line_ID, trxName, virtualColumns);
	}

	public MBHPayrollRunLine(Properties ctx, String BH_Payroll_Run_Line_UU, String trxName) {
		super(ctx, BH_Payroll_Run_Line_UU, trxName);
	}

	public MBHPayrollRunLine(Properties ctx, String BH_Payroll_Run_Line_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Run_Line_UU, trxName, virtualColumns);
	}

	public MBHPayrollRunLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
