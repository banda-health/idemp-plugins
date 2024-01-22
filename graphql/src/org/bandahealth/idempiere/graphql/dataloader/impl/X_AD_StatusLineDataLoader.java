package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStatusLine;

/**
 * Data Loader for AD_StatusLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_StatusLineDataLoader extends PODataLoader<MStatusLine> {
	public static String DATALOADER_AD_StatusLine_BY_ID = "AD_StatusLineByIdDataLoader";
	public static String DATALOADER_AD_StatusLine_BY_UUID = "AD_StatusLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStatusLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_StatusLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_StatusLine_BY_UUID;
	}
}
