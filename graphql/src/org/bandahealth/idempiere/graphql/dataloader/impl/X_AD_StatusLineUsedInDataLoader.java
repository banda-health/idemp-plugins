package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStatusLineUsedIn;

/**
 * Data Loader for AD_StatusLineUsedIn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_StatusLineUsedInDataLoader extends PODataLoader<MStatusLineUsedIn> {
	public static String AD_StatusLineUsedIn_BY_ID_DATA_LOADER = "AD_StatusLineUsedInByIdDataLoader";
	public static String AD_StatusLineUsedIn_BY_UUID_DATA_LOADER = "AD_StatusLineUsedInByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStatusLineUsedIn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_StatusLineUsedIn_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_StatusLineUsedIn_BY_UUID_DATA_LOADER;
	}
}
