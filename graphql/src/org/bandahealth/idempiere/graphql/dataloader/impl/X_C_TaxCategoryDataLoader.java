package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxCategory;

/**
 * Data Loader for C_TaxCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxCategoryDataLoader extends PODataLoader<MTaxCategory> {
	public static String C_TaxCategory_BY_ID_DATA_LOADER = "C_TaxCategoryByIdDataLoader";
	public static String C_TaxCategory_BY_UUID_DATA_LOADER = "C_TaxCategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxCategory_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxCategory_BY_UUID_DATA_LOADER;
	}
}
