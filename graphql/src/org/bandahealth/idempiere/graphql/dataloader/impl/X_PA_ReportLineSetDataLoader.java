package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_ReportLineSet;

/**
 * Data Loader for PA_ReportLineSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportLineSetDataLoader extends PODataLoader<X_PA_ReportLineSet> {
	public static String PA_ReportLineSet_BY_ID_DATA_LOADER = "PA_ReportLineSetByIdDataLoader";
	public static String PA_ReportLineSet_BY_UUID_DATA_LOADER = "PA_ReportLineSetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_ReportLineSet.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_ReportLineSet_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_ReportLineSet_BY_UUID_DATA_LOADER;
	}
}
