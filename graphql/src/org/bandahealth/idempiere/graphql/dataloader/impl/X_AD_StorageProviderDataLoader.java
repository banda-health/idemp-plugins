package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStorageProvider;

/**
 * Data Loader for AD_StorageProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_StorageProviderDataLoader extends PODataLoader<MStorageProvider> {
	public static String AD_StorageProvider_BY_ID_DATA_LOADER = "AD_StorageProviderByIdDataLoader";
	public static String AD_StorageProvider_BY_UUID_DATA_LOADER = "AD_StorageProviderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStorageProvider.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_StorageProvider_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_StorageProvider_BY_UUID_DATA_LOADER;
	}
}
