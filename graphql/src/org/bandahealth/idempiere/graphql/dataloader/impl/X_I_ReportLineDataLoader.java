package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_ReportLine;

/**
 * Data Loader for I_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_ReportLineDataLoader extends PODataLoader<X_I_ReportLine> {
	public static String I_ReportLine_BY_ID_DATA_LOADER = "I_ReportLineByIdDataLoader";
	public static String I_ReportLine_BY_UUID_DATA_LOADER = "I_ReportLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_ReportLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_ReportLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_ReportLine_BY_UUID_DATA_LOADER;
	}
}
