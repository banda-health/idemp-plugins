package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxProvider;

/**
 * Data Loader for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxProviderDataLoader extends PODataLoader<MTaxProvider> {
	public static String C_TaxProvider_BY_ID_DATA_LOADER = "C_TaxProviderByIdDataLoader";
	public static String C_TaxProvider_BY_UUID_DATA_LOADER = "C_TaxProviderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxProvider.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxProvider_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxProvider_BY_UUID_DATA_LOADER;
	}
}
