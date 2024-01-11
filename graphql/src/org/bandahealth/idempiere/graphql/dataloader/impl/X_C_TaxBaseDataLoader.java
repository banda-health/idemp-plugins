package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_C_TaxBase;

/**
 * Data Loader for C_TaxBase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxBaseDataLoader extends PODataLoader<X_C_TaxBase> {
	public static String C_TaxBase_BY_ID_DATA_LOADER = "C_TaxBaseByIdDataLoader";
	public static String C_TaxBase_BY_UUID_DATA_LOADER = "C_TaxBaseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_TaxBase.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxBase_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxBase_BY_UUID_DATA_LOADER;
	}
}
