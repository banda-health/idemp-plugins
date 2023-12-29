package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_ReportColumnSet;

/**
 * Data Loader for PA_ReportColumnSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportColumnSetDataLoader extends PODataLoader<X_PA_ReportColumnSet> {
	public static String PA_ReportColumnSet_BY_ID_DATA_LOADER = "PA_ReportColumnSetByIdDataLoader";
	public static String PA_ReportColumnSet_BY_UUID_DATA_LOADER = "PA_ReportColumnSetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_ReportColumnSet.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_ReportColumnSet_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_ReportColumnSet_BY_UUID_DATA_LOADER;
	}
}
