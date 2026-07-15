package org.bandahealth.idempiere.base.model;

import org.compiere.util.DB;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayrollAudit extends X_BH_Payroll_Audit {

	public MBHPayrollAudit(Properties ctx, int BH_Payroll_Audit_ID, String trxName) {
		super(ctx, BH_Payroll_Audit_ID, trxName);
	}

	public MBHPayrollAudit(Properties ctx, int BH_Payroll_Audit_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Audit_ID, trxName, virtualColumns);
	}

	public MBHPayrollAudit(Properties ctx, String BH_Payroll_Audit_UU, String trxName) {
		super(ctx, BH_Payroll_Audit_UU, trxName);
	}

	public MBHPayrollAudit(Properties ctx, String BH_Payroll_Audit_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Audit_UU, trxName, virtualColumns);
	}

	public MBHPayrollAudit(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		if (!newRecord) {
			log.saveError("Error", "Payroll audit entries cannot be modified");
			return false;
		}
		// Core PO does not validate list membership on save (UI-only), and the frontend submits
		// audit events through the generated save mutation — enforce the vocabulary here.
		int listed = DB.getSQLValueEx(get_TrxName(),
				"SELECT COUNT(*) FROM AD_Ref_List l JOIN AD_Reference r ON r.AD_Reference_ID=l.AD_Reference_ID"
						+ " WHERE r.AD_Reference_UU=? AND l.Value=? AND l.IsActive='Y'",
				MReference_BH.PAYROLL_AUDIT_ACTION_AD_REFERENCE_UU, getBH_ActionType());
		if (listed == 0) {
			log.saveError("Error", "Unknown payroll audit action type: " + getBH_ActionType());
			return false;
		}
		return true;
	}

	@Override
	protected boolean beforeDelete() {
		log.saveError("Error", "Payroll audit entries cannot be deleted");
		return false;
	}
}
