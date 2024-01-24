package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.report.MReportLineSet;

/**
 * Data Loader for PA_ReportLineSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportLineSetDataLoader extends PODataLoader<MReportLineSet> {
	public static String DATALOADER_PA_ReportLineSet_BY_ID = "PA_ReportLineSetByIdDataLoader";
	public static String DATALOADER_PA_ReportLineSet_BY_UUID = "PA_ReportLineSetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReportLineSet.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_ReportLineSet_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_ReportLineSet_BY_UUID;
	}
}
