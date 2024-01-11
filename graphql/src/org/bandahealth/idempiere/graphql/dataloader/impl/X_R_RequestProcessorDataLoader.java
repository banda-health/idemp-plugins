package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestProcessor;

/**
 * Data Loader for R_RequestProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestProcessorDataLoader extends PODataLoader<MRequestProcessor> {
	public static String R_RequestProcessor_BY_ID_DATA_LOADER = "R_RequestProcessorByIdDataLoader";
	public static String R_RequestProcessor_BY_UUID_DATA_LOADER = "R_RequestProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_RequestProcessor_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_RequestProcessor_BY_UUID_DATA_LOADER;
	}
}
