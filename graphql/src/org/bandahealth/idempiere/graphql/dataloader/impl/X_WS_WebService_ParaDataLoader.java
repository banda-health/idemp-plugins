package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebService_Para;

/**
 * Data Loader for WS_WebService_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebService_ParaDataLoader extends PODataLoader<X_WS_WebService_Para> {
	public static String WS_WebService_Para_BY_ID_DATA_LOADER = "WS_WebService_ParaByIdDataLoader";
	public static String WS_WebService_Para_BY_UUID_DATA_LOADER = "WS_WebService_ParaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebService_Para.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return WS_WebService_Para_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return WS_WebService_Para_BY_UUID_DATA_LOADER;
	}
}
