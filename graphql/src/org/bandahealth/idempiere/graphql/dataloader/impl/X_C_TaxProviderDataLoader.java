package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxProvider;

/**
 * Data Loader for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxProviderDataLoader extends PODataLoader<MTaxProvider> {
	public static String DATALOADER_C_TaxProvider_BY_ID = "C_TaxProviderByIdDataLoader";
	public static String DATALOADER_C_TaxProvider_BY_UUID = "C_TaxProviderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxProvider.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxProvider_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxProvider_BY_UUID;
	}
}
