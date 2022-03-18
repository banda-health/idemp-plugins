package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MMenu;

public class MMenu_BH extends MMenu {
	
	public static final String COLUMNNAME_IconClassName = "IconClassName";
	
	public static final String COLUMNNAME_ShowOnUIMenu = "showonuimenu";

	public MMenu_BH(Properties ctx, int M_Menu_ID, String trxName) {
		super(ctx, M_Menu_ID, trxName);
	}

	public MMenu_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	public void setIconClassName(String name) {
		set_Value(COLUMNNAME_IconClassName, name);
	}

	public String getIconClassName() {
		return (String) get_Value(COLUMNNAME_IconClassName);
	}
	
	public boolean isShowOnUIMenu() {
		Object oo = get_Value(COLUMNNAME_ShowOnUIMenu);
		if (oo != null) {
			if (oo instanceof Boolean) {
				return ((Boolean) oo).booleanValue();
			}
			return "Y".equals(oo);
		}
		return false;
	}

	public void setShowOnUIMenu(boolean show) {
		set_Value(COLUMNNAME_ShowOnUIMenu, show);
	}
}
