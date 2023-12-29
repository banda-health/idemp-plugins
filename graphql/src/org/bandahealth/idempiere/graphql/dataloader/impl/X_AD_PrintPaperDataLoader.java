package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintPaper;

/**
 * Data Loader for AD_PrintPaper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintPaperDataLoader extends PODataLoader<X_AD_PrintPaper> {
	public static String AD_PrintPaper_BY_ID_DATA_LOADER = "AD_PrintPaperByIdDataLoader";
	public static String AD_PrintPaper_BY_UUID_DATA_LOADER = "AD_PrintPaperByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintPaper.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PrintPaper_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PrintPaper_BY_UUID_DATA_LOADER;
	}
}
