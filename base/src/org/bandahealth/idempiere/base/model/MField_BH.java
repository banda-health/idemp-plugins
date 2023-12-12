package org.bandahealth.idempiere.base.model;

import org.compiere.model.MField;

import java.sql.ResultSet;
import java.util.Properties;

public class MField_BH extends MField {
	public MField_BH(Properties ctx, int AD_Field_ID, String trxName) {
		super(ctx, AD_Field_ID, trxName);
	}

	public MField_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Column name BH_Abbreviation
	 */
	public static final String COLUMNNAME_BH_Abbreviation = "BH_Abbreviation";

	/**
	 * Set BH_Abbreviation.
	 *
	 * @param BH_Abbreviation An abbreviation for a given name
	 */
	public void setBH_Abbreviation(String BH_Abbreviation) {
		set_Value(COLUMNNAME_BH_Abbreviation, BH_Abbreviation);
	}

	/**
	 * Get BH_Abbreviation.
	 *
	 * @return An abbreviation for a given name
	 */
	public String getBH_Abbreviation() {
		return (String) get_Value(COLUMNNAME_BH_Abbreviation);
	}
}
