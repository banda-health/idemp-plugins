package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayrollRunLineItem extends X_BH_Payroll_Run_Line_Item {

	public MBHPayrollRunLineItem(Properties ctx, int BH_Payroll_Run_Line_Item_ID, String trxName) {
		super(ctx, BH_Payroll_Run_Line_Item_ID, trxName);
	}

	public MBHPayrollRunLineItem(Properties ctx, int BH_Payroll_Run_Line_Item_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Run_Line_Item_ID, trxName, virtualColumns);
	}

	public MBHPayrollRunLineItem(Properties ctx, String BH_Payroll_Run_Line_Item_UU, String trxName) {
		super(ctx, BH_Payroll_Run_Line_Item_UU, trxName);
	}

	public MBHPayrollRunLineItem(Properties ctx, String BH_Payroll_Run_Line_Item_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Run_Line_Item_UU, trxName, virtualColumns);
	}

	public MBHPayrollRunLineItem(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
