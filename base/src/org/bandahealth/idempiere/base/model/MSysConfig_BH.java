package org.bandahealth.idempiere.base.model;

import org.compiere.model.MSysConfig;
import org.compiere.model.Query;

import java.sql.ResultSet;
import java.util.Properties;

public class MSysConfig_BH extends MSysConfig {

	public static final String DEFAULT_BASIC_COA_PATH = "DEFAULT_BASIC_COA_PATH";
	public static final String DEFAULT_INTERMEDIATE_COA_PATH = "DEFAULT_INTERMEDIATE_COA_PATH";
	public static final String DEFAULT_ADVANCED_COA_PATH = "DEFAULT_ADVANCED_COA_PATH";
	public static final String DEFAULT_INITIAL_COA_PATH = "DEFAULT_INITIAL_COA_PATH";
	public static final String AUTOCOMPLETE_MOST_RECENT_VISITS_FIRST = "AUTOCOMPLETE_MOST_RECENT_VISITS_FIRST";
	public static final String NEW_FEATURE_ROLLOUT_ALLOW_FOR_CLIENTS = "NEW_FEATURE_ROLLOUT_ALLOW_FOR_CLIENTS";

	public MSysConfig_BH(Properties ctx, int AD_SysConfig_ID, String trxName) {
		super(ctx, AD_SysConfig_ID, trxName);
	}

	public MSysConfig_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public static MSysConfig_BH getByNameForSystem(Properties ctx, String name, String trxName) {
		MSysConfig_BH systemConfigurator = new Query(ctx, MSysConfig_BH.Table_Name,
				MSysConfig_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MSysConfig_BH.COLUMNNAME_AD_Org_ID + "=? AND " +
						MSysConfig_BH.COLUMNNAME_IsActive + "=? AND " + MSysConfig_BH.COLUMNNAME_Name + "=?",
				trxName).setParameters(0, 0, true, name).first();
		return systemConfigurator;
	}
}
