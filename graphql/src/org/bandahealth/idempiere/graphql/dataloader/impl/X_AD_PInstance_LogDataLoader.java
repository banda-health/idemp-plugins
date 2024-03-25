package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PInstance_Log;

/**
 * Data Loader for AD_PInstance_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PInstance_LogDataLoader extends PODataLoader<X_AD_PInstance_Log> {
	public static String DATALOADER_AD_PInstance_Log_BY_ID = "AD_PInstance_LogByIdDataLoader";
	public static String DATALOADER_AD_PInstance_Log_BY_UUID = "AD_PInstance_LogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PInstance_Log.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PInstance_Log_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PInstance_Log_BY_UUID;
	}
}
