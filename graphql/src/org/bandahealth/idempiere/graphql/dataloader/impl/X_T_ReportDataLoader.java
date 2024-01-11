package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_Report;

/**
 * Data Loader for T_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_ReportDataLoader extends PODataLoader<X_T_Report> {
	public static String T_Report_BY_ID_DATA_LOADER = "T_ReportByIdDataLoader";
	public static String T_Report_BY_UUID_DATA_LOADER = "T_ReportByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_Report.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_Report_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_Report_BY_UUID_DATA_LOADER;
	}
}
