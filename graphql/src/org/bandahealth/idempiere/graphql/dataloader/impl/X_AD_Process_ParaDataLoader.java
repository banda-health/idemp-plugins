package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProcessPara;

/**
 * Data Loader for AD_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Process_ParaDataLoader extends PODataLoader<MProcessPara> {
	public static String AD_Process_Para_BY_ID_DATA_LOADER = "AD_Process_ParaByIdDataLoader";
	public static String AD_Process_Para_BY_UUID_DATA_LOADER = "AD_Process_ParaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProcessPara.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Process_Para_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Process_Para_BY_UUID_DATA_LOADER;
	}
}
