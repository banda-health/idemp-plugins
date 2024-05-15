package org.bandahealth.idempiere.base.model;

import org.compiere.model.MField;
import org.compiere.model.MTab;

import java.sql.ResultSet;
import java.util.Properties;

public class MField_BH extends MField {

	/**
	 * Column name BH_Abbreviation
	 */
	public static final String COLUMNNAME_BH_Abbreviation = "BH_Abbreviation";

	public MField_BH(Properties ctx, String AD_Field_UU, String trxName) {
		super(ctx, AD_Field_UU, trxName);
	}

	public MField_BH(Properties ctx, int AD_Field_ID, String trxName) {
		super(ctx, AD_Field_ID, trxName);
	}

	public MField_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MField_BH(MTab parent) {
		super(parent);
	}

	public MField_BH(MTab parent, MField from) {
		super(parent, from);
	}

	public MField_BH(MField copy) {
		super(copy);
	}

	public MField_BH(Properties ctx, MField copy) {
		super(ctx, copy);
	}

	public MField_BH(Properties ctx, MField copy, String trxName) {
		super(ctx, copy, trxName);
	}

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
