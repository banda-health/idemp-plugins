package org.bandahealth.idempiere.base.model;

import org.compiere.model.MAttributeSet;

import java.sql.ResultSet;
import java.util.Properties;

public class MAttributeSet_BH extends MAttributeSet {
	/**
	 * Column name BH_Locked
	 */
	public static final String COLUMNNAME_BH_Locked = "BH_Locked";
    /** Column name M_AttributeSet_Type */
    public static final String COLUMNNAME_M_AttributeSet_Type = "M_AttributeSet_Type";	

	public MAttributeSet_BH(Properties ctx, int M_AttributeSet_ID, String trxName) {
		super(ctx, M_AttributeSet_ID, trxName);
	}

	public MAttributeSet_BH(Properties ctx, ResultSet rs, String trxName) {
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
	 *                  read from this field)
	 */
	public void setBH_Locked(boolean BH_Locked) {
		set_Value(COLUMNNAME_BH_Locked, Boolean.valueOf(BH_Locked));
	}

	/** M_AttributeSet_Type AD_Reference_ID=200115 */
	public static final int M_ATTRIBUTESET_TYPE_AD_Reference_ID=200115;
	/** Material Management System = MMS */
	public static final String M_ATTRIBUTESET_TYPE_MaterialManagementSystem = "MMS";
	/** Set AttributeSet Type.
		@param M_AttributeSet_Type AttributeSet Type	  */
	public void setM_AttributeSet_Type (String M_AttributeSet_Type)
	{

		set_Value (COLUMNNAME_M_AttributeSet_Type, M_AttributeSet_Type);
	}

	/** Get AttributeSet Type.
		@return AttributeSet Type	  */
	public String getM_AttributeSet_Type () 
	{
		return (String)get_Value(COLUMNNAME_M_AttributeSet_Type);
	}
	
}
