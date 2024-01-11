package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestCategory;

/**
 * Data Loader for R_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_CategoryDataLoader extends PODataLoader<MRequestCategory> {
	public static String R_Category_BY_ID_DATA_LOADER = "R_CategoryByIdDataLoader";
	public static String R_Category_BY_UUID_DATA_LOADER = "R_CategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_Category_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_Category_BY_UUID_DATA_LOADER;
	}
}
