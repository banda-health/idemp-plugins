package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MValRule;

/**
 * Data Loader for AD_Val_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Val_RuleDataLoader extends PODataLoader<MValRule> {
	public static String AD_Val_Rule_BY_ID_DATA_LOADER = "AD_Val_RuleByIdDataLoader";
	public static String AD_Val_Rule_BY_UUID_DATA_LOADER = "AD_Val_RuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MValRule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Val_Rule_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Val_Rule_BY_UUID_DATA_LOADER;
	}
}
