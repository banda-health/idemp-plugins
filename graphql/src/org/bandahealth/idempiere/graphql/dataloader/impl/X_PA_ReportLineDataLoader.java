package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.report.MReportLine;

/**
 * Data Loader for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportLineDataLoader extends PODataLoader<MReportLine> {
	public static String DATALOADER_PA_ReportLine_BY_ID = "PA_ReportLineByIdDataLoader";
	public static String DATALOADER_PA_ReportLine_BY_UUID = "PA_ReportLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReportLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_ReportLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_ReportLine_BY_UUID;
	}
}
