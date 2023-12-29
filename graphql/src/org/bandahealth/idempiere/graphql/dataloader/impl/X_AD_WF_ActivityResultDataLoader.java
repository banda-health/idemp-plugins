package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_ActivityResult;

/**
 * Data Loader for AD_WF_ActivityResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ActivityResultDataLoader extends PODataLoader<X_AD_WF_ActivityResult> {
	public static String AD_WF_ActivityResult_BY_ID_DATA_LOADER = "AD_WF_ActivityResultByIdDataLoader";
	public static String AD_WF_ActivityResult_BY_UUID_DATA_LOADER = "AD_WF_ActivityResultByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_ActivityResult.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WF_ActivityResult_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WF_ActivityResult_BY_UUID_DATA_LOADER;
	}
}
