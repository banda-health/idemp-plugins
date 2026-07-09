package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayrollSettings extends X_BH_Payroll_Settings {

	public MBHPayrollSettings(Properties ctx, int BH_Payroll_Settings_ID, String trxName) {
		super(ctx, BH_Payroll_Settings_ID, trxName);
	}

	public MBHPayrollSettings(Properties ctx, int BH_Payroll_Settings_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Settings_ID, trxName, virtualColumns);
	}

	public MBHPayrollSettings(Properties ctx, String BH_Payroll_Settings_UU, String trxName) {
		super(ctx, BH_Payroll_Settings_UU, trxName);
	}

	public MBHPayrollSettings(Properties ctx, String BH_Payroll_Settings_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Settings_UU, trxName, virtualColumns);
	}

	public MBHPayrollSettings(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
