package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MTabNavBtnTab extends X_BH_TabNavBtn_Tab {

	public MTabNavBtnTab(Properties ctx, int BH_HomeScreen_Button_ID, String trxName) {
		super(ctx, BH_HomeScreen_Button_ID, trxName);
	}

	public MTabNavBtnTab(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
