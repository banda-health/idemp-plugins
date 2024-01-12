package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebServiceTypeAccess;

/**
 * Data Loader for WS_WebServiceTypeAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceTypeAccessDataLoader extends PODataLoader<X_WS_WebServiceTypeAccess> {
	public static String WS_WebServiceTypeAccess_BY_ID_DATA_LOADER = "WS_WebServiceTypeAccessByIdDataLoader";
	public static String WS_WebServiceTypeAccess_BY_UUID_DATA_LOADER = "WS_WebServiceTypeAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebServiceTypeAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return WS_WebServiceTypeAccess_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return WS_WebServiceTypeAccess_BY_UUID_DATA_LOADER;
	}
}
