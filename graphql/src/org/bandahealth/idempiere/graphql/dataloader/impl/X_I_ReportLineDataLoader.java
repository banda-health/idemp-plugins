package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_ReportLine;

/**
 * Data Loader for I_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_ReportLineDataLoader extends PODataLoader<X_I_ReportLine> {
	public static String DATALOADER_I_ReportLine_BY_ID = "I_ReportLineByIdDataLoader";
	public static String DATALOADER_I_ReportLine_BY_UUID = "I_ReportLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_ReportLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_ReportLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_ReportLine_BY_UUID;
	}
}
