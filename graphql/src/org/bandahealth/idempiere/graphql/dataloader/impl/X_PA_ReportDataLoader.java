package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.report.MReport;

/**
 * Data Loader for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_ReportDataLoader extends PODataLoader<MReport> {
	public static String DATALOADER_PA_Report_BY_ID = "PA_ReportByIdDataLoader";
	public static String DATALOADER_PA_Report_BY_UUID = "PA_ReportByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReport.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_Report_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_Report_BY_UUID;
	}
}
