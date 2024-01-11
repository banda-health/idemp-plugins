package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebServiceMethod;

/**
 * Data Loader for WS_WebServiceMethod - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceMethodDataLoader extends PODataLoader<X_WS_WebServiceMethod> {
	public static String WS_WebServiceMethod_BY_ID_DATA_LOADER = "WS_WebServiceMethodByIdDataLoader";
	public static String WS_WebServiceMethod_BY_UUID_DATA_LOADER = "WS_WebServiceMethodByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebServiceMethod.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return WS_WebServiceMethod_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return WS_WebServiceMethod_BY_UUID_DATA_LOADER;
	}
}
