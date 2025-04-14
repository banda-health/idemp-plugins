package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintPaper;

/**
 * Data Loader for AD_PrintPaper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PrintPaperDataLoader extends PODataLoader<X_AD_PrintPaper> {
	public static String DATALOADER_AD_PrintPaper_BY_ID = "AD_PrintPaperByIdDataLoader";
	public static String DATALOADER_AD_PrintPaper_BY_UUID = "AD_PrintPaperByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintPaper.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PrintPaper_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PrintPaper_BY_UUID;
	}
}
