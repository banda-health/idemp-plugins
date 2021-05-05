package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHBPartnerInfo extends X_BH_BPartner_Info {
	public MBHBPartnerInfo(Properties ctx, int BH_BPartner_Info_ID, String trxName) {
		super(ctx, BH_BPartner_Info_ID, trxName);
	}

	public MBHBPartnerInfo(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
