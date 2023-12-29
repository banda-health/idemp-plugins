package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_Report;

/**
 * Data Loader for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportDataLoader extends PODataLoader<X_PA_Report> {
	public static String PA_Report_BY_ID_DATA_LOADER = "PA_ReportByIdDataLoader";
	public static String PA_Report_BY_UUID_DATA_LOADER = "PA_ReportByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_Report.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_Report_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_Report_BY_UUID_DATA_LOADER;
	}
}
