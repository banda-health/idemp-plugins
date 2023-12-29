package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_ReportLine;

/**
 * Data Loader for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportLineDataLoader extends PODataLoader<X_PA_ReportLine> {
	public static String PA_ReportLine_BY_ID_DATA_LOADER = "PA_ReportLineByIdDataLoader";
	public static String PA_ReportLine_BY_UUID_DATA_LOADER = "PA_ReportLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_ReportLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_ReportLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_ReportLine_BY_UUID_DATA_LOADER;
	}
}
