package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxCategory;

/**
 * Data Loader for C_TaxCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxCategoryDataLoader extends PODataLoader<MTaxCategory> {
	public static String DATALOADER_C_TaxCategory_BY_ID = "C_TaxCategoryByIdDataLoader";
	public static String DATALOADER_C_TaxCategory_BY_UUID = "C_TaxCategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxCategory_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxCategory_BY_UUID;
	}
}
