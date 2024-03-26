package org.bandahealth.idempiere.base.model;

import org.compiere.model.MAttributeSetInstance;

import java.sql.ResultSet;
import java.util.Properties;

public class MAttributeSetInstance_BH extends MAttributeSetInstance {

	public static final int ATTRIBUTESETINSTANCEID_JUNK_LOT = 0;

	/**
	 * Column name BH_GuaranteeDateString
	 */
	public static final String COLUMNNAME_BH_GuaranteeDateString = "BH_GuaranteeDateString";

	/**
	 * Column name bh_update_reason
	 */
	public static final String COLUMNNAME_bh_update_reason = "bh_update_reason";

	public MAttributeSetInstance_BH(Properties ctx, String M_AttributeSetInstance_UU, String trxName) {
		super(ctx, M_AttributeSetInstance_UU, trxName);
	}

	public MAttributeSetInstance_BH(Properties ctx, int M_AttributeSetInstance_ID, String trxName) {
		super(ctx, M_AttributeSetInstance_ID, trxName);
	}

	public MAttributeSetInstance_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MAttributeSetInstance_BH(Properties ctx, int M_AttributeSetInstance_ID, int M_AttributeSet_ID,
			String trxName) {
		super(ctx, M_AttributeSetInstance_ID, M_AttributeSet_ID, trxName);
	}

	/**
	 * Set Guarantee Date String.
	 *
	 * @param BH_GuaranteeDateString String date when guarantee expires
	 */
	public void setBH_GuaranteeDateString(String BH_GuaranteeDateString) {
		throw new IllegalArgumentException("BH_GuaranteeDateString is virtual column");
	}

	/**
	 * Get Guarantee Date String.
	 *
	 * @return String date when guarantee expires
	 */
	public String getBH_GuaranteeDateString() {
		return (String) get_Value(COLUMNNAME_BH_GuaranteeDateString);
	}

	/**
	 * Set bh_update_reason.
	 *
	 * @param bh_update_reason bh_update_reason
	 */
	public void setbh_update_reason(String bh_update_reason) {

		set_Value(COLUMNNAME_bh_update_reason, bh_update_reason);
	}

	/**
	 * Get bh_update_reason.
	 *
	 * @return bh_update_reason
	 */
	public String getbh_update_reason() {
		return (String) get_Value(COLUMNNAME_bh_update_reason);
	}
}
