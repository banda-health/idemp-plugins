package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_AllUsers_V;

/**
 * Data Loader for AD_AllUsers_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AllUsers_VDataLoader extends PODataLoader<X_AD_AllUsers_V> {
	public static String AD_AllUsers_V_BY_ID_DATA_LOADER = "AD_AllUsers_VByIdDataLoader";
	public static String AD_AllUsers_V_BY_UUID_DATA_LOADER = "AD_AllUsers_VByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_AllUsers_V.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_AllUsers_V_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_AllUsers_V_BY_UUID_DATA_LOADER;
	}
}
