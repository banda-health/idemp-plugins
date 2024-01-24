package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MValRule;

/**
 * Data Loader for AD_Val_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Val_RuleDataLoader extends PODataLoader<MValRule> {
	public static String DATALOADER_AD_Val_Rule_BY_ID = "AD_Val_RuleByIdDataLoader";
	public static String DATALOADER_AD_Val_Rule_BY_UUID = "AD_Val_RuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MValRule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Val_Rule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Val_Rule_BY_UUID;
	}
}
