package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRule;

/**
 * Data Loader for AD_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_RuleDataLoader extends PODataLoader<MRule> {
	public static String DATALOADER_AD_Rule_BY_ID = "AD_RuleByIdDataLoader";
	public static String DATALOADER_AD_Rule_BY_UUID = "AD_RuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Rule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Rule_BY_UUID;
	}
}
