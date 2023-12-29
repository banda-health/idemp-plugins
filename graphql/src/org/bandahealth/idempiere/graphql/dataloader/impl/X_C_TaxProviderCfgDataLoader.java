package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_TaxProviderCfg;

/**
 * Data Loader for C_TaxProviderCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxProviderCfgDataLoader extends PODataLoader<X_C_TaxProviderCfg> {
	public static String C_TaxProviderCfg_BY_ID_DATA_LOADER = "C_TaxProviderCfgByIdDataLoader";
	public static String C_TaxProviderCfg_BY_UUID_DATA_LOADER = "C_TaxProviderCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_TaxProviderCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxProviderCfg_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxProviderCfg_BY_UUID_DATA_LOADER;
	}
}
