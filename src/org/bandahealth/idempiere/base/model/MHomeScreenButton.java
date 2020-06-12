package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MHomeScreenButton extends X_BH_HmScrn_ButtonGroupLine {

	/** Column name Included_Role_ID */
	public static final String COLUMNNAME_Included_Role_ID = "Included_Role_ID";

	/**
	 * Get IncludedRole.
	 */
	public int getIncludedRole_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_Included_Role_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	public MHomeScreenButton(Properties ctx, int BH_HomeScreen_Button_ID, String trxName) {
		super(ctx, BH_HomeScreen_Button_ID, trxName);
	}

	public MHomeScreenButton(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
