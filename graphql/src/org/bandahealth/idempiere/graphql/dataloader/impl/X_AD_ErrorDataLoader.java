package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Error;

/**
 * Data Loader for AD_Error - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ErrorDataLoader extends PODataLoader<X_AD_Error> {
	public static String AD_Error_BY_ID_DATA_LOADER = "AD_ErrorByIdDataLoader";
	public static String AD_Error_BY_UUID_DATA_LOADER = "AD_ErrorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Error.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Error_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Error_BY_UUID_DATA_LOADER;
	}
}
