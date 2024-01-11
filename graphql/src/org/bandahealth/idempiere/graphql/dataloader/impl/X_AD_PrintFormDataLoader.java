package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintForm;

/**
 * Data Loader for AD_PrintForm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintFormDataLoader extends PODataLoader<X_AD_PrintForm> {
	public static String AD_PrintForm_BY_ID_DATA_LOADER = "AD_PrintFormByIdDataLoader";
	public static String AD_PrintForm_BY_UUID_DATA_LOADER = "AD_PrintFormByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintForm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PrintForm_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PrintForm_BY_UUID_DATA_LOADER;
	}
}
