package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_ReportColumn;

/**
 * Data Loader for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportColumnDataLoader extends PODataLoader<X_PA_ReportColumn> {
	public static String PA_ReportColumn_BY_ID_DATA_LOADER = "PA_ReportColumnByIdDataLoader";
	public static String PA_ReportColumn_BY_UUID_DATA_LOADER = "PA_ReportColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_ReportColumn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_ReportColumn_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_ReportColumn_BY_UUID_DATA_LOADER;
	}
}
