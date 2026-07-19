package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;

public class MBHPayrollSettings extends X_BH_Payroll_Settings {

	/** The client's single settings row (UNIQUE (AD_Client_ID)), or null if none exists yet. */
	public static MBHPayrollSettings getByClientId(Properties ctx, int clientId, String trxName) {
		return new Query(ctx, Table_Name, COLUMNNAME_AD_Client_ID + "=?", trxName)
				.setParameters(clientId)
				.setOnlyActiveRecords(true)
				.first();
	}

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
