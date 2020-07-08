package org.bandahealth.idempiere.base.model;

import org.compiere.model.X_C_ChargeType;

import java.sql.ResultSet;
import java.util.Properties;

public class MChargeType_BH extends X_C_ChargeType {

	/* Default Charge Type Name */
	public static final String CHARGETYPENAME_DEFAULT_CATEGORY = "Default Category";

	public MChargeType_BH(Properties ctx, int C_ChargeType_ID, String trxName) {
		super(ctx, C_ChargeType_ID, trxName);
	}

	public MChargeType_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
