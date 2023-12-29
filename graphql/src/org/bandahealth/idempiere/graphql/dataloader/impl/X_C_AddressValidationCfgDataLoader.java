package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_AddressValidationCfg;

/**
 * Data Loader for C_AddressValidationCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AddressValidationCfgDataLoader extends PODataLoader<X_C_AddressValidationCfg> {
	public static String C_AddressValidationCfg_BY_ID_DATA_LOADER = "C_AddressValidationCfgByIdDataLoader";
	public static String C_AddressValidationCfg_BY_UUID_DATA_LOADER = "C_AddressValidationCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_AddressValidationCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AddressValidationCfg_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AddressValidationCfg_BY_UUID_DATA_LOADER;
	}
}
