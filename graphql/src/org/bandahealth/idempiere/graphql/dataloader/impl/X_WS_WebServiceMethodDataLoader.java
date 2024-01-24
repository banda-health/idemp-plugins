package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebServiceMethod;

/**
 * Data Loader for WS_WebServiceMethod - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceMethodDataLoader extends PODataLoader<X_WS_WebServiceMethod> {
	public static String DATALOADER_WS_WebServiceMethod_BY_ID = "WS_WebServiceMethodByIdDataLoader";
	public static String DATALOADER_WS_WebServiceMethod_BY_UUID = "WS_WebServiceMethodByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebServiceMethod.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_WS_WebServiceMethod_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_WS_WebServiceMethod_BY_UUID;
	}
}
