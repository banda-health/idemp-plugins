package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_C_TaxType;

/**
 * Data Loader for C_TaxType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxTypeDataLoader extends PODataLoader<X_C_TaxType> {
	public static String DATALOADER_C_TaxType_BY_ID = "C_TaxTypeByIdDataLoader";
	public static String DATALOADER_C_TaxType_BY_UUID = "C_TaxTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_TaxType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxType_BY_UUID;
	}
}
