package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAuthorizationCredential;

/**
 * Data Loader for AD_AuthorizationCredential - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationCredentialDataLoader extends PODataLoader<MAuthorizationCredential> {
	public static String DATALOADER_AD_AuthorizationCredential_BY_ID = "AD_AuthorizationCredentialByIdDataLoader";
	public static String DATALOADER_AD_AuthorizationCredential_BY_UUID = "AD_AuthorizationCredentialByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAuthorizationCredential.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_AuthorizationCredential_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_AuthorizationCredential_BY_UUID;
	}
}
