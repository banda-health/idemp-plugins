package org.bandahealth.idempiere.base.model;

import org.compiere.model.MBPGroup;

import java.sql.ResultSet;
import java.util.Properties;

public class MBPGroup_BH extends MBPGroup {
	public static final String NAME_Patients = "Patients - DO NOT CHANGE";
	public static final String NAME_Donors = "Donors - DO NOT CHANGE";
	public static final String NAME_FFS_Insurance = "FFS Insurance - DO NOT CHANGE";
	/**
	 * Column name BH_SubType
	 */
	public static final String COLUMNNAME_BH_SubType = "BH_SubType";

	/**
	 * Column name BH_Locked
	 */
	public static final String COLUMNNAME_BH_Locked = "BH_Locked";

	public MBPGroup_BH(Properties ctx, int C_BP_Group_ID, String trxName) {
		super(ctx, C_BP_Group_ID, trxName);
	}

	public MBPGroup_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

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

	/**
	 * Set Sub Type.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	public void setBH_SubType(String BH_SubType) {

		set_Value(COLUMNNAME_BH_SubType, BH_SubType);
	}

	/**
	 * Get Sub Type.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	public String getBH_SubType() {
		return (String) get_Value(COLUMNNAME_BH_SubType);
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
}
