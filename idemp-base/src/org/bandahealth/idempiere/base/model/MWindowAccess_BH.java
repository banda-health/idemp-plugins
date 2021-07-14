package org.bandahealth.idempiere.base.model;

import org.compiere.model.MWindow;
import org.compiere.model.MWindowAccess;

import java.sql.ResultSet;
import java.util.Properties;

public class MWindowAccess_BH extends MWindowAccess {
	/** Column name BH_CanDeactivate */
	public static final String COLUMNNAME_BH_CanDeactivate = "BH_CanDeactivate";

	public MWindowAccess_BH(Properties ctx, int ignored, String trxName) {
		super(ctx, ignored, trxName);
	}

	public MWindowAccess_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MWindowAccess_BH(MWindow parent, int AD_Role_ID) {
		super(parent, AD_Role_ID);
	}

	/** Set Can Deactivate.
	 @param BH_CanDeactivate Can Deactivate	  */
	public void setBH_CanDeactivate (boolean BH_CanDeactivate)
	{
		set_Value (COLUMNNAME_BH_CanDeactivate, Boolean.valueOf(BH_CanDeactivate));
	}

	/** Get Can Deactivate.
	 @return Can Deactivate	  */
	public boolean isBH_CanDeactivate ()
	{
		Object oo = get_Value(COLUMNNAME_BH_CanDeactivate);
		if (oo != null)
		{
			if (oo instanceof Boolean)
				return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}
}
