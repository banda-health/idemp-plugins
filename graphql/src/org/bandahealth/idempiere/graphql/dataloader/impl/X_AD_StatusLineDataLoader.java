package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStatusLine;

/**
 * Data Loader for AD_StatusLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_StatusLineDataLoader extends PODataLoader<MStatusLine> {
	public static String AD_StatusLine_BY_ID_DATA_LOADER = "AD_StatusLineByIdDataLoader";
	public static String AD_StatusLine_BY_UUID_DATA_LOADER = "AD_StatusLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStatusLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_StatusLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_StatusLine_BY_UUID_DATA_LOADER;
	}
}
