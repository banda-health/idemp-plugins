package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDashboardContent;

/**
 * Data Loader for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardContentDataLoader extends PODataLoader<MDashboardContent> {
	public static String PA_DashboardContent_BY_ID_DATA_LOADER = "PA_DashboardContentByIdDataLoader";
	public static String PA_DashboardContent_BY_UUID_DATA_LOADER = "PA_DashboardContentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDashboardContent.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_DashboardContent_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_DashboardContent_BY_UUID_DATA_LOADER;
	}
}
