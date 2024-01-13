package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebServiceType;

/**
 * Data Loader for WS_WebServiceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceTypeDataLoader extends PODataLoader<X_WS_WebServiceType> {
	public static String DATALOADER_WS_WebServiceType_BY_ID = "WS_WebServiceTypeByIdDataLoader";
	public static String DATALOADER_WS_WebServiceType_BY_UUID = "WS_WebServiceTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebServiceType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_WS_WebServiceType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_WS_WebServiceType_BY_UUID;
	}
}
