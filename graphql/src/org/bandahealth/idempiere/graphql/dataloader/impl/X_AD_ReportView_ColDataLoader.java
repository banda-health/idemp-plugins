package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ReportView_Col;

/**
 * Data Loader for AD_ReportView_Col - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReportView_ColDataLoader extends PODataLoader<X_AD_ReportView_Col> {
	public static String AD_ReportView_Col_BY_ID_DATA_LOADER = "AD_ReportView_ColByIdDataLoader";
	public static String AD_ReportView_Col_BY_UUID_DATA_LOADER = "AD_ReportView_ColByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ReportView_Col.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ReportView_Col_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ReportView_Col_BY_UUID_DATA_LOADER;
	}
}
