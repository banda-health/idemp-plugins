package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestProcessor;

/**
 * Data Loader for R_RequestProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestProcessorDataLoader extends PODataLoader<MRequestProcessor> {
	public static String DATALOADER_R_RequestProcessor_BY_ID = "R_RequestProcessorByIdDataLoader";
	public static String DATALOADER_R_RequestProcessor_BY_UUID = "R_RequestProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_RequestProcessor_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_RequestProcessor_BY_UUID;
	}
}
