package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Process_Para;

/**
 * Data Loader for ASP_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_ASP_Process_ParaDataLoader extends PODataLoader<X_ASP_Process_Para> {
	public static String DATALOADER_ASP_Process_Para_BY_ID = "ASP_Process_ParaByIdDataLoader";
	public static String DATALOADER_ASP_Process_Para_BY_UUID = "ASP_Process_ParaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Process_Para.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Process_Para_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Process_Para_BY_UUID;
	}
}
