package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestProcessorRoute;

/**
 * Data Loader for R_RequestProcessor_Route - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestProcessor_RouteDataLoader extends PODataLoader<MRequestProcessorRoute> {
	public static String R_RequestProcessor_Route_BY_ID_DATA_LOADER = "R_RequestProcessor_RouteByIdDataLoader";
	public static String R_RequestProcessor_Route_BY_UUID_DATA_LOADER = "R_RequestProcessor_RouteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestProcessorRoute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_RequestProcessor_Route_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_RequestProcessor_Route_BY_UUID_DATA_LOADER;
	}
}
