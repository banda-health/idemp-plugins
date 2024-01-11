package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTableAccess;

/**
 * Data Loader for AD_Table_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Table_AccessDataLoader extends PODataLoader<MTableAccess> {
	public static String AD_Table_Access_BY_ID_DATA_LOADER = "AD_Table_AccessByIdDataLoader";
	public static String AD_Table_Access_BY_UUID_DATA_LOADER = "AD_Table_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTableAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Table_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Table_Access_BY_UUID_DATA_LOADER;
	}
}
