package org.bandahealth.idempiere.base.model;

import org.compiere.model.X_C_ChargeType;

import java.sql.ResultSet;
import java.util.Properties;

public class MChargeType_BH extends X_C_ChargeType {

	/* Default Expense Category Charge Type Name (added by default in MBandaSetup.java) */
	public static final String CHARGETYPENAME_DEFAULT_EXPENSE_CATEGORY = "Default Expense Category - DO NOT CHANGE";
	/* Non-Patient Payment Charge Type Name (added by default in MBandaSetup.java) */
	public static final String CHARGETYPENAME_NON_PATIENT_PAYMENT = "Non-Patient Payment - DO NOT CHANGE";
	/* Default Income Category Charge Type */
	public static final String CHARGETYPENAME_DEFAULT_INCOME_CATEGORY = "Default Income Category - DO NOT CHANGE";

	public MChargeType_BH(Properties ctx, int C_ChargeType_ID, String trxName) {
		super(ctx, C_ChargeType_ID, trxName);
	}

	public MChargeType_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
