package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestType;

/**
 * Data Loader for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestTypeDataLoader extends PODataLoader<MRequestType> {
	public static String R_RequestType_BY_ID_DATA_LOADER = "R_RequestTypeByIdDataLoader";
	public static String R_RequestType_BY_UUID_DATA_LOADER = "R_RequestTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_RequestType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_RequestType_BY_UUID_DATA_LOADER;
	}
}
