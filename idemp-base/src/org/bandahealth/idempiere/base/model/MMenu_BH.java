package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MMenu;

public class MMenu_BH extends MMenu {

	public static final String MENUUUID_GREENLIGHT = "bb0670c5-0dc1-468a-8b85-a91b15407368";
	public static final String MENUUUID_GREENLIGHT_REPORT_DROPDOWN = "35ce7d6a-cf7d-4962-a748-75e27d0121bf";
	public static final String COLUMNNAME_IconClassName = "IconClassName";

	public MMenu_BH(Properties ctx, int M_Menu_ID, String trxName) {
		super(ctx, M_Menu_ID, trxName);
	}

	public MMenu_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public String getIconClassName() {
		return (String) get_Value(COLUMNNAME_IconClassName);
	}

	public void setIconClassName(String name) {
		set_Value(COLUMNNAME_IconClassName, name);
	}
}
