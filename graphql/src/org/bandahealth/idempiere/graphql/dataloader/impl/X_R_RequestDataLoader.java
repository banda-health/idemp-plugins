package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequest;

/**
 * Data Loader for R_Request - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestDataLoader extends PODataLoader<MRequest> {
	public static String R_Request_BY_ID_DATA_LOADER = "R_RequestByIdDataLoader";
	public static String R_Request_BY_UUID_DATA_LOADER = "R_RequestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_Request_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_Request_BY_UUID_DATA_LOADER;
	}
}
