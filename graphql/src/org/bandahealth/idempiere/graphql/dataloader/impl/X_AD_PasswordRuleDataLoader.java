package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPasswordRule;

/**
 * Data Loader for AD_PasswordRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PasswordRuleDataLoader extends PODataLoader<MPasswordRule> {
	public static String DATALOADER_AD_PasswordRule_BY_ID = "AD_PasswordRuleByIdDataLoader";
	public static String DATALOADER_AD_PasswordRule_BY_UUID = "AD_PasswordRuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPasswordRule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PasswordRule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PasswordRule_BY_UUID;
	}
}
