package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReportView;

/**
 * Data Loader for AD_ReportView - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReportViewDataLoader extends PODataLoader<MReportView> {
	public static String AD_ReportView_BY_ID_DATA_LOADER = "AD_ReportViewByIdDataLoader";
	public static String AD_ReportView_BY_UUID_DATA_LOADER = "AD_ReportViewByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReportView.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ReportView_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ReportView_BY_UUID_DATA_LOADER;
	}
}
