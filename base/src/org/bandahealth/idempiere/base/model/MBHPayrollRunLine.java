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

	/** True once the parent payroll run is locked (Processed='Y'). */
	private boolean isRunLocked() {
		MBHPayrollRun run = new MBHPayrollRun(getCtx(), getBH_Payroll_Run_ID(), get_TrxName());
		return run.isProcessed();
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		if (isRunLocked()) {
			log.saveError("Error", "Payroll run is locked; lines cannot be modified");
			return false;
		}
		return true;
	}

	@Override
	protected boolean beforeDelete() {
		if (isRunLocked()) {
			log.saveError("Error", "Payroll run is locked; lines cannot be deleted");
			return false;
		}
		return true;
	}
}
