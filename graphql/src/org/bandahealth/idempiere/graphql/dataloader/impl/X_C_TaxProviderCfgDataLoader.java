package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_TaxProviderCfg;

/**
 * Data Loader for C_TaxProviderCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxProviderCfgDataLoader extends PODataLoader<X_C_TaxProviderCfg> {
	public static String DATALOADER_C_TaxProviderCfg_BY_ID = "C_TaxProviderCfgByIdDataLoader";
	public static String DATALOADER_C_TaxProviderCfg_BY_UUID = "C_TaxProviderCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_TaxProviderCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxProviderCfg_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxProviderCfg_BY_UUID;
	}
}
