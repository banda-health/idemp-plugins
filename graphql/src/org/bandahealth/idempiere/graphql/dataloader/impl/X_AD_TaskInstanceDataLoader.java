package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_TaskInstance;

/**
 * Data Loader for AD_TaskInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TaskInstanceDataLoader extends PODataLoader<X_AD_TaskInstance> {
	public static String AD_TaskInstance_BY_ID_DATA_LOADER = "AD_TaskInstanceByIdDataLoader";
	public static String AD_TaskInstance_BY_UUID_DATA_LOADER = "AD_TaskInstanceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_TaskInstance.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_TaskInstance_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_TaskInstance_BY_UUID_DATA_LOADER;
	}
}
