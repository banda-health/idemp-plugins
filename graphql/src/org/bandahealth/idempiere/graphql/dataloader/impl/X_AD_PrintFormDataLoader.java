package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintForm;

/**
 * Data Loader for AD_PrintForm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintFormDataLoader extends PODataLoader<X_AD_PrintForm> {
	public static String DATALOADER_AD_PrintForm_BY_ID = "AD_PrintFormByIdDataLoader";
	public static String DATALOADER_AD_PrintForm_BY_UUID = "AD_PrintFormByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintForm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PrintForm_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PrintForm_BY_UUID;
	}
}
