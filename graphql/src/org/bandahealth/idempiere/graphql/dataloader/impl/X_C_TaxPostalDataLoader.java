package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxPostal;

/**
 * Data Loader for C_TaxPostal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxPostalDataLoader extends PODataLoader<MTaxPostal> {
	public static String C_TaxPostal_BY_ID_DATA_LOADER = "C_TaxPostalByIdDataLoader";
	public static String C_TaxPostal_BY_UUID_DATA_LOADER = "C_TaxPostalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxPostal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxPostal_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxPostal_BY_UUID_DATA_LOADER;
	}
}
