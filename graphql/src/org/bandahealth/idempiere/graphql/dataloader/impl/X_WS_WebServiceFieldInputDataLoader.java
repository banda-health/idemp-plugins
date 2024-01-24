package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebServiceFieldInput;

/**
 * Data Loader for WS_WebServiceFieldInput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceFieldInputDataLoader extends PODataLoader<X_WS_WebServiceFieldInput> {
	public static String DATALOADER_WS_WebServiceFieldInput_BY_ID = "WS_WebServiceFieldInputByIdDataLoader";
	public static String DATALOADER_WS_WebServiceFieldInput_BY_UUID = "WS_WebServiceFieldInputByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebServiceFieldInput.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_WS_WebServiceFieldInput_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_WS_WebServiceFieldInput_BY_UUID;
	}
}
