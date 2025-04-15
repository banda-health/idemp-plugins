package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStorageProvider;

/**
 * Data Loader for AD_StorageProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_StorageProviderDataLoader extends PODataLoader<MStorageProvider> {
	public static String DATALOADER_AD_StorageProvider_BY_ID = "AD_StorageProviderByIdDataLoader";
	public static String DATALOADER_AD_StorageProvider_BY_UUID = "AD_StorageProviderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStorageProvider.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_StorageProvider_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_StorageProvider_BY_UUID;
	}
}
