package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ImpFormat_Row;

/**
 * Data Loader for AD_ImpFormat_Row - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ImpFormat_RowDataLoader extends PODataLoader<X_AD_ImpFormat_Row> {
	public static String DATALOADER_AD_ImpFormat_Row_BY_ID = "AD_ImpFormat_RowByIdDataLoader";
	public static String DATALOADER_AD_ImpFormat_Row_BY_UUID = "AD_ImpFormat_RowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ImpFormat_Row.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ImpFormat_Row_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ImpFormat_Row_BY_UUID;
	}
}
