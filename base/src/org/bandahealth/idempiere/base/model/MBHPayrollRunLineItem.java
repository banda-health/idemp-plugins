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

	/** True once the parent payroll run (via the owning line) is locked (Processed='Y'). */
	private boolean isRunLocked() {
		MBHPayrollRunLine line = new MBHPayrollRunLine(getCtx(), getBH_Payroll_Run_Line_ID(), get_TrxName());
		MBHPayrollRun run = new MBHPayrollRun(getCtx(), line.getBH_Payroll_Run_ID(), get_TrxName());
		return run.isProcessed();
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		if (isRunLocked()) {
			log.saveError("Error", "Payroll run is locked; line items cannot be modified");
			return false;
		}
		return true;
	}

	@Override
	protected boolean beforeDelete() {
		if (isRunLocked()) {
			log.saveError("Error", "Payroll run is locked; line items cannot be deleted");
			return false;
		}
		return true;
	}
}
