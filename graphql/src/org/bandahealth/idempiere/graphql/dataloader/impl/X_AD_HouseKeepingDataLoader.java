package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MHouseKeeping;

/**
 * Data Loader for AD_HouseKeeping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_HouseKeepingDataLoader extends PODataLoader<MHouseKeeping> {
	public static String DATALOADER_AD_HouseKeeping_BY_ID = "AD_HouseKeepingByIdDataLoader";
	public static String DATALOADER_AD_HouseKeeping_BY_UUID = "AD_HouseKeepingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MHouseKeeping.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_HouseKeeping_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_HouseKeeping_BY_UUID;
	}
}
