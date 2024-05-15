package org.bandahealth.idempiere.base.model;

import org.compiere.model.X_AD_FieldGroup;

import java.sql.ResultSet;
import java.util.Properties;

public class MFieldGroup_BH extends X_AD_FieldGroup {
	/**
	 * Column name BH_Abbreviation
	 */
	public static final String COLUMNNAME_BH_Abbreviation = "BH_Abbreviation";

	public MFieldGroup_BH(Properties ctx, String AD_FieldGroup_UU, String trxName) {
		super(ctx, AD_FieldGroup_UU, trxName);
	}

	public MFieldGroup_BH(Properties ctx, int AD_FieldGroup_ID, String trxName) {
		super(ctx, AD_FieldGroup_ID, trxName);
	}

	public MFieldGroup_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
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
