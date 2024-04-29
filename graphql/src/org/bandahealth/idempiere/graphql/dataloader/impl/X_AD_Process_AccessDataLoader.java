package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProcessAccess;

/**
 * Data Loader for AD_Process_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Process_AccessDataLoader extends PODataLoader<MProcessAccess> {
	public static String DATALOADER_AD_Process_Access_BY_ID = "AD_Process_AccessByIdDataLoader";
	public static String DATALOADER_AD_Process_Access_BY_UUID = "AD_Process_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProcessAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Process_Access_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Process_Access_BY_UUID;
	}
}
