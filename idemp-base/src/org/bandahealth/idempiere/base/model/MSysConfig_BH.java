package org.bandahealth.idempiere.base.model;

import org.compiere.model.MSysConfig;

import java.sql.ResultSet;
import java.util.Properties;

public class MSysConfig_BH extends MSysConfig {

	public static final String DEFAULT_BASIC_COA_PATH = "DEFAULT_BASIC_COA_PATH";
	public static final String DEFAULT_INTERMEDIATE_COA_PATH = "DEFAULT_INTERMEDIATE_COA_PATH";
	public static final String DEFAULT_ADVANCED_COA_PATH = "DEFAULT_ADVANCED_COA_PATH";
	public static final String DEFAULT_INITIAL_COA_PATH = "DEFAULT_INITIAL_COA_PATH";
	public static final String CLIENT_IDS_FOR_SYNCHRONOUS_SALES_ORDER_PROCESSING =
			"CLIENT_IDS_FOR_SYNCHRONOUS_SALES_ORDER_PROCESSING";
	public static final String AUTOCOMPLETE_MOST_RECENT_VISITS_FIRST = "AUTOCOMPLETE_MOST_RECENT_VISITS_FIRST";

	public MSysConfig_BH(Properties ctx, int AD_SysConfig_ID, String trxName) {
		super(ctx, AD_SysConfig_ID, trxName);
	}

	public MSysConfig_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
