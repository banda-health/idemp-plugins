package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Error;

/**
 * Data Loader for AD_Error - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ErrorDataLoader extends PODataLoader<X_AD_Error> {
	public static String DATALOADER_AD_Error_BY_ID = "AD_ErrorByIdDataLoader";
	public static String DATALOADER_AD_Error_BY_UUID = "AD_ErrorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Error.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Error_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Error_BY_UUID;
	}
}
