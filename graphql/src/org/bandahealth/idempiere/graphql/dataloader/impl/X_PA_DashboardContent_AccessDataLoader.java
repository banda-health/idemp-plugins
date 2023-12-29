package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDashboardContentAccess;

/**
 * Data Loader for PA_DashboardContent_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardContent_AccessDataLoader extends PODataLoader<MDashboardContentAccess> {
	public static String PA_DashboardContent_Access_BY_ID_DATA_LOADER = "PA_DashboardContent_AccessByIdDataLoader";
	public static String PA_DashboardContent_Access_BY_UUID_DATA_LOADER = "PA_DashboardContent_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDashboardContentAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_DashboardContent_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_DashboardContent_Access_BY_UUID_DATA_LOADER;
	}
}
