package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestProcessorRoute;

/**
 * Data Loader for R_RequestProcessor_Route - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestProcessor_RouteDataLoader extends PODataLoader<MRequestProcessorRoute> {
	public static String DATALOADER_R_RequestProcessor_Route_BY_ID = "R_RequestProcessor_RouteByIdDataLoader";
	public static String DATALOADER_R_RequestProcessor_Route_BY_UUID = "R_RequestProcessor_RouteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestProcessorRoute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_RequestProcessor_Route_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_RequestProcessor_Route_BY_UUID;
	}
}
