package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStatusLineUsedIn;

/**
 * Data Loader for AD_StatusLineUsedIn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_StatusLineUsedInDataLoader extends PODataLoader<MStatusLineUsedIn> {
	public static String DATALOADER_AD_StatusLineUsedIn_BY_ID = "AD_StatusLineUsedInByIdDataLoader";
	public static String DATALOADER_AD_StatusLineUsedIn_BY_UUID = "AD_StatusLineUsedInByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStatusLineUsedIn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_StatusLineUsedIn_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_StatusLineUsedIn_BY_UUID;
	}
}
