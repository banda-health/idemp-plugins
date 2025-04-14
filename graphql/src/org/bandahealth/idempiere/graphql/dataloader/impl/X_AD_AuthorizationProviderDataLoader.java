package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAuthorizationProvider;

/**
 * Data Loader for AD_AuthorizationProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AuthorizationProviderDataLoader extends PODataLoader<MAuthorizationProvider> {
	public static String DATALOADER_AD_AuthorizationProvider_BY_ID = "AD_AuthorizationProviderByIdDataLoader";
	public static String DATALOADER_AD_AuthorizationProvider_BY_UUID = "AD_AuthorizationProviderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAuthorizationProvider.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_AuthorizationProvider_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_AuthorizationProvider_BY_UUID;
	}
}
