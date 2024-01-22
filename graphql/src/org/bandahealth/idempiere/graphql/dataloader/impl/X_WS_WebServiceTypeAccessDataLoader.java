package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebServiceTypeAccess;

/**
 * Data Loader for WS_WebServiceTypeAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceTypeAccessDataLoader extends PODataLoader<X_WS_WebServiceTypeAccess> {
	public static String DATALOADER_WS_WebServiceTypeAccess_BY_ID = "WS_WebServiceTypeAccessByIdDataLoader";
	public static String DATALOADER_WS_WebServiceTypeAccess_BY_UUID = "WS_WebServiceTypeAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebServiceTypeAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_WS_WebServiceTypeAccess_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_WS_WebServiceTypeAccess_BY_UUID;
	}
}
