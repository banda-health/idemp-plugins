package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStatusCategory;

/**
 * Data Loader for R_StatusCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_StatusCategoryDataLoader extends PODataLoader<MStatusCategory> {
	public static String R_StatusCategory_BY_ID_DATA_LOADER = "R_StatusCategoryByIdDataLoader";
	public static String R_StatusCategory_BY_UUID_DATA_LOADER = "R_StatusCategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStatusCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_StatusCategory_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_StatusCategory_BY_UUID_DATA_LOADER;
	}
}
