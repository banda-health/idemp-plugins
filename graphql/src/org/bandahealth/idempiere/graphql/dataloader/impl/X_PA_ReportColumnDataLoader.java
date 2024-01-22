package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MReportColumn_BH;

/**
 * Data Loader for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_ReportColumnDataLoader extends PODataLoader<MReportColumn_BH> {
	public static String DATALOADER_PA_ReportColumn_BY_ID = "PA_ReportColumnByIdDataLoader";
	public static String DATALOADER_PA_ReportColumn_BY_UUID = "PA_ReportColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReportColumn_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_ReportColumn_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_ReportColumn_BY_UUID;
	}
}
