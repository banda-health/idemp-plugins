package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

// Per-code effective resolution (getEffectiveAll) and calculator-spec conversion (toSpec)
// are added with their tests in the settings-resolution task.
public class MBHPayrollComponent extends X_BH_Payroll_Component {

	public MBHPayrollComponent(Properties ctx, int BH_Payroll_Component_ID, String trxName) {
		super(ctx, BH_Payroll_Component_ID, trxName);
	}

	public MBHPayrollComponent(Properties ctx, int BH_Payroll_Component_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Component_ID, trxName, virtualColumns);
	}

	public MBHPayrollComponent(Properties ctx, String BH_Payroll_Component_UU, String trxName) {
		super(ctx, BH_Payroll_Component_UU, trxName);
	}

	public MBHPayrollComponent(Properties ctx, String BH_Payroll_Component_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Component_UU, trxName, virtualColumns);
	}

	public MBHPayrollComponent(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
