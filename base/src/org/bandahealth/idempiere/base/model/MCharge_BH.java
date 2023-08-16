package org.bandahealth.idempiere.base.model;

import org.compiere.model.MCharge;

import java.sql.ResultSet;
import java.util.Properties;

public class MCharge_BH extends MCharge {
	/**
	 * Column name C_ElementValue_ID
	 */
	public static final String COLUMNNAME_BH_Locked = "BH_Locked";
	/**
	 * Insurance = I
	 */
	public static final String BH_SUBTYPE_Insurance = "I";
	/**
	 * Waiver = W
	 */
	public static final String BH_SUBTYPE_Waiver = "W";
	/**
	 * Donation = D
	 */
	public static final String BH_SUBTYPE_Donation = "D";
	private static final long serialVersionUID = 1L;

	public MCharge_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MCharge_BH(Properties ctx, int C_BPartner_ID, String trxName) {
		super(ctx, C_BPartner_ID, trxName);
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
	 *                  read from this field)
	 */
	public void setBH_Locked(boolean BH_Locked) {
		set_Value(COLUMNNAME_BH_Locked, Boolean.valueOf(BH_Locked));
	}
}
