package org.bandahealth.idempiere.base.model;

import org.compiere.model.MSerNoCtl;

import java.sql.ResultSet;
import java.util.Properties;

public class MSerNoCtl_BH extends MSerNoCtl {
	/**
	 * Column name BH_Locked
	 */
	public static final String COLUMNNAME_BH_Locked = "BH_Locked";

	public MSerNoCtl_BH(Properties ctx, int M_SerNoCtl_ID, String trxName) {
		super(ctx, M_SerNoCtl_ID, trxName);
	}

	public MSerNoCtl_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from
	 * this field)
	 */
	public boolean isBH_Locked() {
		Object oo = get_Value(COLUMNNAME_BH_Locked);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/**
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to
	 *                   read from this field)
	 */
	public void setBH_Locked(boolean BH_Locked) {
		set_Value(COLUMNNAME_BH_Locked, Boolean.valueOf(BH_Locked));
	}
}
