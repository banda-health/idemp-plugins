package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_C_TaxGroup;

/**
 * Data Loader for C_TaxGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxGroupDataLoader extends PODataLoader<X_C_TaxGroup> {
	public static String C_TaxGroup_BY_ID_DATA_LOADER = "C_TaxGroupByIdDataLoader";
	public static String C_TaxGroup_BY_UUID_DATA_LOADER = "C_TaxGroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_TaxGroup.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxGroup_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxGroup_BY_UUID_DATA_LOADER;
	}
}
