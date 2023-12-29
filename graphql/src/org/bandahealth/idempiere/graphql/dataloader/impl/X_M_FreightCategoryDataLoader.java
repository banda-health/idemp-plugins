package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFreightCategory;

/**
 * Data Loader for M_FreightCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_FreightCategoryDataLoader extends PODataLoader<MFreightCategory> {
	public static String M_FreightCategory_BY_ID_DATA_LOADER = "M_FreightCategoryByIdDataLoader";
	public static String M_FreightCategory_BY_UUID_DATA_LOADER = "M_FreightCategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFreightCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_FreightCategory_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_FreightCategory_BY_UUID_DATA_LOADER;
	}
}
