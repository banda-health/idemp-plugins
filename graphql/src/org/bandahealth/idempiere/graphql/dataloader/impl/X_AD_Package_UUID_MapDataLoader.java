package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Package_UUID_Map;

/**
 * Data Loader for AD_Package_UUID_Map - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_UUID_MapDataLoader extends PODataLoader<X_AD_Package_UUID_Map> {
	public static String AD_Package_UUID_Map_BY_ID_DATA_LOADER = "AD_Package_UUID_MapByIdDataLoader";
	public static String AD_Package_UUID_Map_BY_UUID_DATA_LOADER = "AD_Package_UUID_MapByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Package_UUID_Map.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Package_UUID_Map_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Package_UUID_Map_BY_UUID_DATA_LOADER;
	}
}
