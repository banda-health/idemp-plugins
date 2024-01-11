package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MHouseKeeping;

/**
 * Data Loader for AD_HouseKeeping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_HouseKeepingDataLoader extends PODataLoader<MHouseKeeping> {
	public static String AD_HouseKeeping_BY_ID_DATA_LOADER = "AD_HouseKeepingByIdDataLoader";
	public static String AD_HouseKeeping_BY_UUID_DATA_LOADER = "AD_HouseKeepingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MHouseKeeping.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_HouseKeeping_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_HouseKeeping_BY_UUID_DATA_LOADER;
	}
}
