package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDashboardContentAccess;

/**
 * Data Loader for PA_DashboardContent_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardContent_AccessDataLoader extends PODataLoader<MDashboardContentAccess> {
	public static String DATALOADER_PA_DashboardContent_Access_BY_ID = "PA_DashboardContent_AccessByIdDataLoader";
	public static String DATALOADER_PA_DashboardContent_Access_BY_UUID = "PA_DashboardContent_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDashboardContentAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_DashboardContent_Access_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_DashboardContent_Access_BY_UUID;
	}
}
