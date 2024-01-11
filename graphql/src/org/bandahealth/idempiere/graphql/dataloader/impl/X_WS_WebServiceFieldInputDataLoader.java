package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebServiceFieldInput;

/**
 * Data Loader for WS_WebServiceFieldInput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceFieldInputDataLoader extends PODataLoader<X_WS_WebServiceFieldInput> {
	public static String WS_WebServiceFieldInput_BY_ID_DATA_LOADER = "WS_WebServiceFieldInputByIdDataLoader";
	public static String WS_WebServiceFieldInput_BY_UUID_DATA_LOADER = "WS_WebServiceFieldInputByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebServiceFieldInput.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return WS_WebServiceFieldInput_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return WS_WebServiceFieldInput_BY_UUID_DATA_LOADER;
	}
}
