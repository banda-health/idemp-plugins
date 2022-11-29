package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MUser;
import org.compiere.model.X_C_BPartner;

public class MUser_BH extends MUser {
	public static final int USERID_SYSTEM = 100;

	public static String COLUMNNAME_BH_HasAcceptedTermsOfUse = "BH_HasAcceptedTermsOfUse";
	public static String COLUMNNAME_BH_TOS_DATE_ACCEPTED = "BH_TOS_DATE_ACCEPTED";
	
	public MUser_BH(Properties ctx, int AD_User_ID, String trxName) {
		super(ctx, AD_User_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MUser_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MUser_BH(X_C_BPartner partner) {
		super(partner);
		// TODO Auto-generated constructor stub
	}

	public Object getBH_HasAcceptedTermsOfUse() {
		return get_Value(COLUMNNAME_BH_HasAcceptedTermsOfUse);
	}

	public void setBH_HasAcceptedTermsOfUse(Object BH_HasAcceptedTermsOfUse) {
		set_Value(COLUMNNAME_BH_HasAcceptedTermsOfUse, BH_HasAcceptedTermsOfUse);
	}
	
	public void setBH_TOSDateAccepted(Timestamp date) {
		set_Value(COLUMNNAME_BH_TOS_DATE_ACCEPTED, date);
	}
}
