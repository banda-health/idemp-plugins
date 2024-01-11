package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProcessAccess;

/**
 * Data Loader for AD_Process_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Process_AccessDataLoader extends PODataLoader<MProcessAccess> {
	public static String AD_Process_Access_BY_ID_DATA_LOADER = "AD_Process_AccessByIdDataLoader";
	public static String AD_Process_Access_BY_UUID_DATA_LOADER = "AD_Process_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProcessAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Process_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Process_Access_BY_UUID_DATA_LOADER;
	}
}
