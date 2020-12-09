package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MUIButton extends X_BH_UIButton {

	public MUIButton(Properties ctx, int BH_UIButton_ID, String trxName) {
		super(ctx, BH_UIButton_ID, trxName);
	}

	public MUIButton(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
