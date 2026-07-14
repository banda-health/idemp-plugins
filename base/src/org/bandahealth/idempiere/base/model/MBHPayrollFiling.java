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

	/** True once the parent payroll run is locked (Processed='Y'). */
	private boolean isRunLocked() {
		MBHPayrollRun run = new MBHPayrollRun(getCtx(), getBH_Payroll_Run_ID(), get_TrxName());
		return run.isProcessed();
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		if (!isRunLocked()) {
			return true;
		}
		// Locked run: no new filings, and existing filings may only record payment.
		if (newRecord) {
			log.saveError("Error", "Payroll run is locked; filings cannot be added");
			return false;
		}
		for (int i = 0; i < get_ColumnCount(); i++) {
			if (!is_ValueChanged(i)) {
				continue;
			}
			String columnName = get_ColumnName(i);
			if (COLUMNNAME_BH_IsPaid.equals(columnName) || COLUMNNAME_BH_PaidDate.equals(columnName)
					|| COLUMNNAME_BH_PaymentReference.equals(columnName)
					|| "Updated".equals(columnName) || "UpdatedBy".equals(columnName)) {
				continue;
			}
			log.saveError("Error", "Payroll run is locked; only payment fields may change");
			return false;
		}
		return true;
	}

	@Override
	protected boolean beforeDelete() {
		if (isRunLocked()) {
			log.saveError("Error", "Payroll run is locked; filings cannot be deleted");
			return false;
		}
		return true;
	}
}
