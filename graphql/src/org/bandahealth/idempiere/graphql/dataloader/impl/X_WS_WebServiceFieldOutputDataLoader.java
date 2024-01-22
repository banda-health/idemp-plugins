package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_WS_WebServiceFieldOutput;

/**
 * Data Loader for WS_WebServiceFieldOutput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceFieldOutputDataLoader extends PODataLoader<X_WS_WebServiceFieldOutput> {
	public static String DATALOADER_WS_WebServiceFieldOutput_BY_ID = "WS_WebServiceFieldOutputByIdDataLoader";
	public static String DATALOADER_WS_WebServiceFieldOutput_BY_UUID = "WS_WebServiceFieldOutputByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_WS_WebServiceFieldOutput.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_WS_WebServiceFieldOutput_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_WS_WebServiceFieldOutput_BY_UUID;
	}
}
