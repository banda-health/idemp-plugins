package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_Report;

/**
 * Data Loader for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportDataLoader extends PODataLoader<X_PA_Report> {
	public static String DATALOADER_PA_Report_BY_ID = "PA_ReportByIdDataLoader";
	public static String DATALOADER_PA_Report_BY_UUID = "PA_ReportByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_Report.Table_Name;
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
