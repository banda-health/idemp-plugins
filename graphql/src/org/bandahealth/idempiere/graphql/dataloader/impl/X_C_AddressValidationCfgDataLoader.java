package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_AddressValidationCfg;

/**
 * Data Loader for C_AddressValidationCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AddressValidationCfgDataLoader extends PODataLoader<X_C_AddressValidationCfg> {
	public static String DATALOADER_C_AddressValidationCfg_BY_ID = "C_AddressValidationCfgByIdDataLoader";
	public static String DATALOADER_C_AddressValidationCfg_BY_UUID = "C_AddressValidationCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_AddressValidationCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_AddressValidationCfg_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_AddressValidationCfg_BY_UUID;
	}
}
