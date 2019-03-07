package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MDashboardButtonGroupButton extends X_BH_DbrdBtnGrp_Btn {
	
	/** Column name Included_Role_ID */
    public static final String COLUMNNAME_Included_Role_ID = "Included_Role_ID";

	/** Get IncludedRole.
	*/
	public int getIncludedRole_ID() {
		return (Integer) get_Value(COLUMNNAME_Included_Role_ID);
	}

	public MDashboardButtonGroupButton(Properties ctx, int BH_HomeScreen_Button_ID, String trxName) {
		super(ctx, BH_HomeScreen_Button_ID, trxName);
	}

	public MDashboardButtonGroupButton(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
