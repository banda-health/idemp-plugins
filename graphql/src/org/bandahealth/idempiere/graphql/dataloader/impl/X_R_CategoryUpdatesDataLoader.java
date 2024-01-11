package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_CategoryUpdates;

/**
 * Data Loader for R_CategoryUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_CategoryUpdatesDataLoader extends PODataLoader<X_R_CategoryUpdates> {
	public static String R_CategoryUpdates_BY_ID_DATA_LOADER = "R_CategoryUpdatesByIdDataLoader";
	public static String R_CategoryUpdates_BY_UUID_DATA_LOADER = "R_CategoryUpdatesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_CategoryUpdates.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_CategoryUpdates_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_CategoryUpdates_BY_UUID_DATA_LOADER;
	}
}
