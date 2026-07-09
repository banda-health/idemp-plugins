package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayrollFiling extends X_BH_Payroll_Filing {

	public MBHPayrollFiling(Properties ctx, int BH_Payroll_Filing_ID, String trxName) {
		super(ctx, BH_Payroll_Filing_ID, trxName);
	}

	public MBHPayrollFiling(Properties ctx, int BH_Payroll_Filing_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Filing_ID, trxName, virtualColumns);
	}

	public MBHPayrollFiling(Properties ctx, String BH_Payroll_Filing_UU, String trxName) {
		super(ctx, BH_Payroll_Filing_UU, trxName);
	}

	public MBHPayrollFiling(Properties ctx, String BH_Payroll_Filing_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Filing_UU, trxName, virtualColumns);
	}

	public MBHPayrollFiling(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
