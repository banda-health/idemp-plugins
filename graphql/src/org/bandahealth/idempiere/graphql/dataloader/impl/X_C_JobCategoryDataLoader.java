package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_JobCategory;

/**
 * Data Loader for C_JobCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_JobCategoryDataLoader extends PODataLoader<X_C_JobCategory> {
	public static String C_JobCategory_BY_ID_DATA_LOADER = "C_JobCategoryByIdDataLoader";
	public static String C_JobCategory_BY_UUID_DATA_LOADER = "C_JobCategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_JobCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_JobCategory_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_JobCategory_BY_UUID_DATA_LOADER;
	}
}
