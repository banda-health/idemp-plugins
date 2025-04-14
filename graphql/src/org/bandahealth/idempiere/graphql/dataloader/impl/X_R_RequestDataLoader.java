package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequest;

/**
 * Data Loader for R_Request - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_RequestDataLoader extends PODataLoader<MRequest> {
	public static String DATALOADER_R_Request_BY_ID = "R_RequestByIdDataLoader";
	public static String DATALOADER_R_Request_BY_UUID = "R_RequestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_Request_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_Request_BY_UUID;
	}
}
