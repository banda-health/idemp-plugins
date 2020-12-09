package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MDashboardButtonGroup extends X_BH_DbrdBtnGrp {

	public MDashboardButtonGroup(Properties ctx, int BH_HomeScreen_Button_ID, String trxName) {
		super(ctx, BH_HomeScreen_Button_ID, trxName);
	}

	public MDashboardButtonGroup(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
