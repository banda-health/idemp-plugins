package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAlertRule;

/**
 * Data Loader for AD_AlertRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertRuleDataLoader extends PODataLoader<MAlertRule> {
	public static String AD_AlertRule_BY_ID_DATA_LOADER = "AD_AlertRuleByIdDataLoader";
	public static String AD_AlertRule_BY_UUID_DATA_LOADER = "AD_AlertRuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAlertRule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_AlertRule_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_AlertRule_BY_UUID_DATA_LOADER;
	}
}
