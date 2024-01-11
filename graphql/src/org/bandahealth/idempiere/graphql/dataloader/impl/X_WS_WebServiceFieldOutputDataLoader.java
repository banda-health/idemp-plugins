package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebServiceFieldOutput;

/**
 * Data Loader for WS_WebServiceFieldOutput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceFieldOutputDataLoader extends PODataLoader<X_WS_WebServiceFieldOutput> {
	public static String WS_WebServiceFieldOutput_BY_ID_DATA_LOADER = "WS_WebServiceFieldOutputByIdDataLoader";
	public static String WS_WebServiceFieldOutput_BY_UUID_DATA_LOADER = "WS_WebServiceFieldOutputByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebServiceFieldOutput.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return WS_WebServiceFieldOutput_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return WS_WebServiceFieldOutput_BY_UUID_DATA_LOADER;
	}
}
