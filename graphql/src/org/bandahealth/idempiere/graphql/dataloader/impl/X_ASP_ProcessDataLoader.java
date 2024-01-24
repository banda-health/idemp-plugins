package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Process;

/**
 * Data Loader for ASP_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_ProcessDataLoader extends PODataLoader<X_ASP_Process> {
	public static String DATALOADER_ASP_Process_BY_ID = "ASP_ProcessByIdDataLoader";
	public static String DATALOADER_ASP_Process_BY_UUID = "ASP_ProcessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Process.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Process_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Process_BY_UUID;
	}
}
