package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRegion;

/**
 * Data Loader for C_Region - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_RegionDataLoader extends PODataLoader<MRegion> {
	public static String DATALOADER_C_Region_BY_ID = "C_RegionByIdDataLoader";
	public static String DATALOADER_C_Region_BY_UUID = "C_RegionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRegion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Region_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Region_BY_UUID;
	}
}
