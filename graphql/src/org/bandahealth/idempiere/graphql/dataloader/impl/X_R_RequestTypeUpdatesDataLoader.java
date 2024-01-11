package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_RequestTypeUpdates;

/**
 * Data Loader for R_RequestTypeUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestTypeUpdatesDataLoader extends PODataLoader<X_R_RequestTypeUpdates> {
	public static String R_RequestTypeUpdates_BY_ID_DATA_LOADER = "R_RequestTypeUpdatesByIdDataLoader";
	public static String R_RequestTypeUpdates_BY_UUID_DATA_LOADER = "R_RequestTypeUpdatesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_RequestTypeUpdates.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_RequestTypeUpdates_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_RequestTypeUpdates_BY_UUID_DATA_LOADER;
	}
}
