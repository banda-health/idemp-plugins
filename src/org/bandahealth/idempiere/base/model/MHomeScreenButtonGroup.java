package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MHomeScreenButtonGroup extends X_BH_HmScrn_ButtonGroup {

	public MHomeScreenButtonGroup(Properties ctx, int BH_HomeScreen_Button_ID, String trxName) {
		super(ctx, BH_HomeScreen_Button_ID, trxName);
	}

	public MHomeScreenButtonGroup(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
