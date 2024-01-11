package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_RequestUpdates;

/**
 * Data Loader for R_RequestUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestUpdatesDataLoader extends PODataLoader<X_R_RequestUpdates> {
	public static String R_RequestUpdates_BY_ID_DATA_LOADER = "R_RequestUpdatesByIdDataLoader";
	public static String R_RequestUpdates_BY_UUID_DATA_LOADER = "R_RequestUpdatesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_RequestUpdates.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_RequestUpdates_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_RequestUpdates_BY_UUID_DATA_LOADER;
	}
}
