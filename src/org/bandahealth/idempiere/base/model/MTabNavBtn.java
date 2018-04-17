package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MTabNavBtn extends X_BH_TabNavBtn {

	public MTabNavBtn(Properties ctx, int BH_HomeScreen_Button_ID, String trxName) {
		super(ctx, BH_HomeScreen_Button_ID, trxName);
	}

	public MTabNavBtn(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
