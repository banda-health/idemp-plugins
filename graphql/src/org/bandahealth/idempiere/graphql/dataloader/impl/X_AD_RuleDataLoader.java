package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRule;

/**
 * Data Loader for AD_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RuleDataLoader extends PODataLoader<MRule> {
	public static String AD_Rule_BY_ID_DATA_LOADER = "AD_RuleByIdDataLoader";
	public static String AD_Rule_BY_UUID_DATA_LOADER = "AD_RuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Rule_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Rule_BY_UUID_DATA_LOADER;
	}
}
