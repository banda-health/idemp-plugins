package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProcessPara;

/**
 * Data Loader for AD_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Process_ParaDataLoader extends PODataLoader<MProcessPara> {
	public static String DATALOADER_AD_Process_Para_BY_ID = "AD_Process_ParaByIdDataLoader";
	public static String DATALOADER_AD_Process_Para_BY_UUID = "AD_Process_ParaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProcessPara.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Process_Para_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Process_Para_BY_UUID;
	}
}
