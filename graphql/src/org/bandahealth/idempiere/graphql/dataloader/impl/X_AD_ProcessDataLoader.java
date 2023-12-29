package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProcess_BH;

/**
 * Data Loader for AD_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ProcessDataLoader extends PODataLoader<MProcess_BH> {
	public static String AD_Process_BY_ID_DATA_LOADER = "AD_ProcessByIdDataLoader";
	public static String AD_Process_BY_UUID_DATA_LOADER = "AD_ProcessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProcess_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Process_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Process_BY_UUID_DATA_LOADER;
	}
}
