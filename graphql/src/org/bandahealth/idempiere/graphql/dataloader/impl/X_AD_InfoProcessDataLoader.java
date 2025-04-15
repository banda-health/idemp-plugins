package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_InfoProcess;

/**
 * Data Loader for AD_InfoProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_InfoProcessDataLoader extends PODataLoader<X_AD_InfoProcess> {
	public static String DATALOADER_AD_InfoProcess_BY_ID = "AD_InfoProcessByIdDataLoader";
	public static String DATALOADER_AD_InfoProcess_BY_UUID = "AD_InfoProcessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_InfoProcess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_InfoProcess_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_InfoProcess_BY_UUID;
	}
}
