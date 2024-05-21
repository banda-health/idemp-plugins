package org.bandahealth.idempiere.base.model;

import org.compiere.model.MUser;
import org.compiere.model.X_C_BPartner;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

public class MUser_BH extends MUser {
	public static final int USERID_SYSTEM = 100;

	public static String COLUMNNAME_BH_HasAcceptedTermsOfUse = "BH_HasAcceptedTermsOfUse";
	public static String COLUMNNAME_BH_TOS_DATE_ACCEPTED = "BH_TOS_DATE_ACCEPTED";

	public MUser_BH(Properties ctx, String AD_User_UU, String trxName) {
		super(ctx, AD_User_UU, trxName);
	}

	public MUser_BH(Properties ctx, int AD_User_ID, String trxName) {
		super(ctx, AD_User_ID, trxName);
	}

	public MUser_BH(X_C_BPartner partner) {
		super(partner);
	}

	public MUser_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MUser_BH(MUser copy) {
		super(copy);
	}

	public MUser_BH(Properties ctx, MUser copy) {
		super(ctx, copy);
	}

	public MUser_BH(Properties ctx, MUser copy, String trxName) {
		super(ctx, copy, trxName);
	}

	/**
	 * Set HasAcceptedTermsOfUse.
	 *
	 * @param BH_HasAcceptedTermsOfUse HasAcceptedTermsOfUse
	 */
	public void setBH_HasAcceptedTermsOfUse(boolean BH_HasAcceptedTermsOfUse) {
		set_Value(COLUMNNAME_BH_HasAcceptedTermsOfUse, Boolean.valueOf(BH_HasAcceptedTermsOfUse));
	}

	/**
	 * Get HasAcceptedTermsOfUse.
	 *
	 * @return HasAcceptedTermsOfUse
	 */
	public boolean isBH_HasAcceptedTermsOfUse() {
		Object oo = get_Value(COLUMNNAME_BH_HasAcceptedTermsOfUse);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/**
	 * Set BH_TOS_DATE_ACCEPTED.
	 *
	 * @param BH_TOS_DATE_ACCEPTED BH_TOS_DATE_ACCEPTED
	 */
	public void setBH_TOS_DATE_ACCEPTED(Timestamp BH_TOS_DATE_ACCEPTED) {
		set_Value(COLUMNNAME_BH_TOS_DATE_ACCEPTED, BH_TOS_DATE_ACCEPTED);
	}

	/**
	 * Get BH_TOS_DATE_ACCEPTED.
	 *
	 * @return BH_TOS_DATE_ACCEPTED
	 */
	public Timestamp getBH_TOS_DATE_ACCEPTED() {
		return (Timestamp) get_Value(COLUMNNAME_BH_TOS_DATE_ACCEPTED);
	}
}
