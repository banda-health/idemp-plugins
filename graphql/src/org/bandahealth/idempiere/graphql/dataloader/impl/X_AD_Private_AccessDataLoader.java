package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPrivateAccess;

/**
 * Data Loader for AD_Private_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Private_AccessDataLoader extends PODataLoader<MPrivateAccess> {
	public static String AD_Private_Access_BY_ID_DATA_LOADER = "AD_Private_AccessByIdDataLoader";
	public static String AD_Private_Access_BY_UUID_DATA_LOADER = "AD_Private_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPrivateAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Private_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Private_Access_BY_UUID_DATA_LOADER;
	}
}
