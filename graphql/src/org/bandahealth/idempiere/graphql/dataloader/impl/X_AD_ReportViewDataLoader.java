package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReportView;

/**
 * Data Loader for AD_ReportView - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReportViewDataLoader extends PODataLoader<MReportView> {
	public static String DATALOADER_AD_ReportView_BY_ID = "AD_ReportViewByIdDataLoader";
	public static String DATALOADER_AD_ReportView_BY_UUID = "AD_ReportViewByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReportView.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ReportView_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ReportView_BY_UUID;
	}
}
