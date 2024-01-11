package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_C_TaxType;

/**
 * Data Loader for C_TaxType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxTypeDataLoader extends PODataLoader<X_C_TaxType> {
	public static String C_TaxType_BY_ID_DATA_LOADER = "C_TaxTypeByIdDataLoader";
	public static String C_TaxType_BY_UUID_DATA_LOADER = "C_TaxTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_TaxType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxType_BY_UUID_DATA_LOADER;
	}
}
