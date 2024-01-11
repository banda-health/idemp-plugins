package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ReportView_Column;

/**
 * Data Loader for AD_ReportView_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReportView_ColumnDataLoader extends PODataLoader<X_AD_ReportView_Column> {
	public static String AD_ReportView_Column_BY_ID_DATA_LOADER = "AD_ReportView_ColumnByIdDataLoader";
	public static String AD_ReportView_Column_BY_UUID_DATA_LOADER = "AD_ReportView_ColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ReportView_Column.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ReportView_Column_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ReportView_Column_BY_UUID_DATA_LOADER;
	}
}
