package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_ReportSource;

/**
 * Data Loader for PA_ReportSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportSourceDataLoader extends PODataLoader<X_PA_ReportSource> {
	public static String DATALOADER_PA_ReportSource_BY_ID = "PA_ReportSourceByIdDataLoader";
	public static String DATALOADER_PA_ReportSource_BY_UUID = "PA_ReportSourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_ReportSource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_ReportSource_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_ReportSource_BY_UUID;
	}
}
