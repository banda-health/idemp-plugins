package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_JobCategory;

/**
 * Data Loader for C_JobCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_JobCategoryDataLoader extends PODataLoader<X_C_JobCategory> {
	public static String DATALOADER_C_JobCategory_BY_ID = "C_JobCategoryByIdDataLoader";
	public static String DATALOADER_C_JobCategory_BY_UUID = "C_JobCategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_JobCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_JobCategory_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_JobCategory_BY_UUID;
	}
}
