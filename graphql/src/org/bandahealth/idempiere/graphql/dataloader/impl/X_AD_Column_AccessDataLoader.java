package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MColumnAccess;

/**
 * Data Loader for AD_Column_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Column_AccessDataLoader extends PODataLoader<MColumnAccess> {
	public static String AD_Column_Access_BY_ID_DATA_LOADER = "AD_Column_AccessByIdDataLoader";
	public static String AD_Column_Access_BY_UUID_DATA_LOADER = "AD_Column_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MColumnAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Column_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Column_Access_BY_UUID_DATA_LOADER;
	}
}
