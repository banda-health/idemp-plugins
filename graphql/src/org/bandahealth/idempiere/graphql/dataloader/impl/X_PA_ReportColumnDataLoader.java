package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_ReportColumn;

/**
 * Data Loader for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportColumnDataLoader extends PODataLoader<X_PA_ReportColumn> {
	public static String DATALOADER_PA_ReportColumn_BY_ID = "PA_ReportColumnByIdDataLoader";
	public static String DATALOADER_PA_ReportColumn_BY_UUID = "PA_ReportColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_ReportColumn.Table_Name;
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
