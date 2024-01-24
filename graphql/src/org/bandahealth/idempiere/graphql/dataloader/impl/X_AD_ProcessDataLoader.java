package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProcess_BH;

/**
 * Data Loader for AD_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ProcessDataLoader extends PODataLoader<MProcess_BH> {
	public static String DATALOADER_AD_Process_BY_ID = "AD_ProcessByIdDataLoader";
	public static String DATALOADER_AD_Process_BY_UUID = "AD_ProcessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProcess_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Process_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Process_BY_UUID;
	}
}
