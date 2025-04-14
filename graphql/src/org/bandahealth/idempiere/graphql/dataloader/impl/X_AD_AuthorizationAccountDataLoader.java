package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAuthorizationAccount;

/**
 * Data Loader for AD_AuthorizationAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AuthorizationAccountDataLoader extends PODataLoader<MAuthorizationAccount> {
	public static String DATALOADER_AD_AuthorizationAccount_BY_ID = "AD_AuthorizationAccountByIdDataLoader";
	public static String DATALOADER_AD_AuthorizationAccount_BY_UUID = "AD_AuthorizationAccountByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAuthorizationAccount.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_AuthorizationAccount_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_AuthorizationAccount_BY_UUID;
	}
}
