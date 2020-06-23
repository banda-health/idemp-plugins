package org.bandahealth.idempiere.base.model;

import org.compiere.model.MCharge;

import java.sql.ResultSet;
import java.util.Properties;

public class MCharge_BH extends MCharge {

	private static final long serialVersionUID = 1L;

	/**
	 * Column name C_ElementValue_ID
	 */
	public static final String COLUMNNAME_C_ElementValue_ID = "C_ElementValue_ID";

	/**
	 * Has C_ElementValue_ID.
	 *
	 * @return boolean for whether C_ElementValue_ID exists
	 */
	public boolean hasC_ElementValue_ID() {
		Object C_ElementValue_ID = get_Value(COLUMNNAME_C_ElementValue_ID);
		return C_ElementValue_ID != null;
	}

	/**
	 * Get C_ElementValue_ID.
	 *
	 * @return Element Value ID
	 */
	public int getC_ElementValue_ID() {
		if (!hasC_ElementValue_ID()) {
			return -1;
		}
		return (int) get_Value(COLUMNNAME_C_ElementValue_ID);
	}

	/**
	 * Set C_ElementValue_ID.
	 *
	 * @param c_elementValue_id Element Value ID
	 */
	public void setC_ElementValue_ID(int c_elementValue_id) {
		set_Value(COLUMNNAME_C_ElementValue_ID, c_elementValue_id);
	}

	/**
	 * Column name C_ElementValue_ID
	 */
	public static final String COLUMNNAME_BH_Locked = "BH_Locked";

	/**
	 * Get BH_Locked.
	 *
	 * @return BH Locked
	 */
	public boolean getBH_Locked() {
		return (boolean) get_Value(COLUMNNAME_BH_Locked);
	}

	/**
	 * Set BH_Locked
	 *
	 * @param bh_locked BH Locked
	 */
	public void setBH_Locked(boolean bh_locked) {
		set_Value(COLUMNNAME_BH_Locked, bh_locked);
	}

	public MCharge_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MCharge_BH(Properties ctx, int C_BPartner_ID, String trxName) {
		super(ctx, C_BPartner_ID, trxName);
	}
}
