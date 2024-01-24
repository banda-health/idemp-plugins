package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebService;

/**
 * Data Loader for WS_WebService - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceDataLoader extends PODataLoader<X_WS_WebService> {
	public static String DATALOADER_WS_WebService_BY_ID = "WS_WebServiceByIdDataLoader";
	public static String DATALOADER_WS_WebService_BY_UUID = "WS_WebServiceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebService.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_WS_WebService_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_WS_WebService_BY_UUID;
	}
}
