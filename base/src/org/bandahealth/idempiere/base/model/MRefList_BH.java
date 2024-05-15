package org.bandahealth.idempiere.base.model;

import org.compiere.model.MRefList;

import java.sql.ResultSet;
import java.util.Properties;

public class MRefList_BH extends MRefList {
	/**
	 * Column name BH_Add_All
	 */
	public static final String COLUMNNAME_BH_Add_All = "BH_Add_All";

	/**
	 * Column name BH_Update_Existing
	 */
	public static final String COLUMNNAME_BH_Update_Existing = "BH_Update_Existing";

	public MRefList_BH(Properties ctx, MRefList copy) {
		super(ctx, copy);
	}

	public MRefList_BH(Properties ctx, MRefList copy, String trxName) {
		super(ctx, copy, trxName);
	}

	public MRefList_BH(Properties ctx, String AD_Ref_List_UU, String trxName) {
		super(ctx, AD_Ref_List_UU, trxName);
	}

	public MRefList_BH(Properties ctx, int AD_Ref_List_ID, String trxName) {
		super(ctx, AD_Ref_List_ID, trxName);
	}

	public MRefList_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Set Add All Access.
	 *
	 * @param BH_Add_All Add All Access
	 */
	public void setBH_Add_All(String BH_Add_All) {
		set_Value(COLUMNNAME_BH_Add_All, BH_Add_All);
	}

	/**
	 * Get Add All Access.
	 *
	 * @return Add All Access
	 */
	public String getBH_Add_All() {
		return (String) get_Value(COLUMNNAME_BH_Add_All);
	}

	/**
	 * Set Update Existing.
	 *
	 * @param BH_Update_Existing Update Existing
	 */
	public void setBH_Update_Existing(String BH_Update_Existing) {
		set_Value(COLUMNNAME_BH_Update_Existing, BH_Update_Existing);
	}

	/**
	 * Get Update Existing.
	 *
	 * @return Update Existing
	 */
	public String getBH_Update_Existing() {
		return (String) get_Value(COLUMNNAME_BH_Update_Existing);
	}
}
