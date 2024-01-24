package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ReportView_Col;

/**
 * Data Loader for AD_ReportView_Col - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReportView_ColDataLoader extends PODataLoader<X_AD_ReportView_Col> {
	public static String DATALOADER_AD_ReportView_Col_BY_ID = "AD_ReportView_ColByIdDataLoader";
	public static String DATALOADER_AD_ReportView_Col_BY_UUID = "AD_ReportView_ColByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ReportView_Col.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ReportView_Col_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ReportView_Col_BY_UUID;
	}
}
