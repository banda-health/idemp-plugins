package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ReportView_Column;

/**
 * Data Loader for AD_ReportView_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReportView_ColumnDataLoader extends PODataLoader<X_AD_ReportView_Column> {
	public static String DATALOADER_AD_ReportView_Column_BY_ID = "AD_ReportView_ColumnByIdDataLoader";
	public static String DATALOADER_AD_ReportView_Column_BY_UUID = "AD_ReportView_ColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ReportView_Column.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ReportView_Column_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ReportView_Column_BY_UUID;
	}
}
