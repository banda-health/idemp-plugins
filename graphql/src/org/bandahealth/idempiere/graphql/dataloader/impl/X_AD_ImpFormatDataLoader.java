package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ImpFormat;

/**
 * Data Loader for AD_ImpFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ImpFormatDataLoader extends PODataLoader<X_AD_ImpFormat> {
	public static String DATALOADER_AD_ImpFormat_BY_ID = "AD_ImpFormatByIdDataLoader";
	public static String DATALOADER_AD_ImpFormat_BY_UUID = "AD_ImpFormatByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ImpFormat.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ImpFormat_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ImpFormat_BY_UUID;
	}
}
