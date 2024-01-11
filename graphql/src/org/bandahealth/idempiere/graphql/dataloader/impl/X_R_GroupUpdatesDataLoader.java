package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_GroupUpdates;

/**
 * Data Loader for R_GroupUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_GroupUpdatesDataLoader extends PODataLoader<X_R_GroupUpdates> {
	public static String R_GroupUpdates_BY_ID_DATA_LOADER = "R_GroupUpdatesByIdDataLoader";
	public static String R_GroupUpdates_BY_UUID_DATA_LOADER = "R_GroupUpdatesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_GroupUpdates.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_GroupUpdates_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_GroupUpdates_BY_UUID_DATA_LOADER;
	}
}
