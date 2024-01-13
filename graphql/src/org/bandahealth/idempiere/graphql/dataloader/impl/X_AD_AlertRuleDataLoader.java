package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAlertRule;

/**
 * Data Loader for AD_AlertRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertRuleDataLoader extends PODataLoader<MAlertRule> {
	public static String DATALOADER_AD_AlertRule_BY_ID = "AD_AlertRuleByIdDataLoader";
	public static String DATALOADER_AD_AlertRule_BY_UUID = "AD_AlertRuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAlertRule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_AlertRule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_AlertRule_BY_UUID;
	}
}
