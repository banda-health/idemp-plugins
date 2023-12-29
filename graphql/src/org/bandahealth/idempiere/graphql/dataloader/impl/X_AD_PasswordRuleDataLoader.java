package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPasswordRule;

/**
 * Data Loader for AD_PasswordRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PasswordRuleDataLoader extends PODataLoader<MPasswordRule> {
	public static String AD_PasswordRule_BY_ID_DATA_LOADER = "AD_PasswordRuleByIdDataLoader";
	public static String AD_PasswordRule_BY_UUID_DATA_LOADER = "AD_PasswordRuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPasswordRule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PasswordRule_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PasswordRule_BY_UUID_DATA_LOADER;
	}
}
