package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MWindowAccess_BH;

/**
 * Data Loader for AD_Window_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Window_AccessDataLoader extends PODataLoader<MWindowAccess_BH> {
	public static String AD_Window_Access_BY_ID_DATA_LOADER = "AD_Window_AccessByIdDataLoader";
	public static String AD_Window_Access_BY_UUID_DATA_LOADER = "AD_Window_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWindowAccess_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Window_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Window_Access_BY_UUID_DATA_LOADER;
	}
}
