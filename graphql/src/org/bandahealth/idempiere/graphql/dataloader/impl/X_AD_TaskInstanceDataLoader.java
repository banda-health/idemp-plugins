package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_TaskInstance;

/**
 * Data Loader for AD_TaskInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_TaskInstanceDataLoader extends PODataLoader<X_AD_TaskInstance> {
	public static String DATALOADER_AD_TaskInstance_BY_ID = "AD_TaskInstanceByIdDataLoader";
	public static String DATALOADER_AD_TaskInstance_BY_UUID = "AD_TaskInstanceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_TaskInstance.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TaskInstance_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TaskInstance_BY_UUID;
	}
}
