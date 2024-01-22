package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_Report;

/**
 * Data Loader for T_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_ReportDataLoader extends PODataLoader<X_T_Report> {
	public static String DATALOADER_T_Report_BY_ID = "T_ReportByIdDataLoader";
	public static String DATALOADER_T_Report_BY_UUID = "T_ReportByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_Report.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_Report_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_Report_BY_UUID;
	}
}
