package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintHeaderFooter;

/**
 * Data Loader for AD_PrintHeaderFooter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintHeaderFooterDataLoader extends PODataLoader<X_AD_PrintHeaderFooter> {
	public static String DATALOADER_AD_PrintHeaderFooter_BY_ID = "AD_PrintHeaderFooterByIdDataLoader";
	public static String DATALOADER_AD_PrintHeaderFooter_BY_UUID = "AD_PrintHeaderFooterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintHeaderFooter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PrintHeaderFooter_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PrintHeaderFooter_BY_UUID;
	}
}
