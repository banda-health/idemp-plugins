package org.bandahealth.idempiere.base.model;

import org.compiere.model.MClient;

import java.sql.ResultSet;
import java.util.Properties;

public class MClient_BH extends MClient {
	private static final long serialVersionUID = 1L;
	public static final int CLIENTID_SYSTEM = 0;
	public static final int CLIENTID_CONFIG = 2;
	public static final int CLIENTID_LAST_SYSTEM = 999999;

	public MClient_BH(Properties ctx, int AD_Client_ID, boolean createNew, String trxName) {
		super(ctx, AD_Client_ID, createNew, trxName);
	}

	public MClient_BH(Properties ctx, int AD_Client_ID, String trxName) {
		super(ctx, AD_Client_ID, trxName);
	}

	public MClient_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MClient_BH(Properties ctx, String trxName) {
		super(ctx, trxName);
	}
}
