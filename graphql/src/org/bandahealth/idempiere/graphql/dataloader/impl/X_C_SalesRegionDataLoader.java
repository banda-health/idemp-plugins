package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSalesRegion;

/**
 * Data Loader for C_SalesRegion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_SalesRegionDataLoader extends PODataLoader<MSalesRegion> {
	public static String DATALOADER_C_SalesRegion_BY_ID = "C_SalesRegionByIdDataLoader";
	public static String DATALOADER_C_SalesRegion_BY_UUID = "C_SalesRegionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSalesRegion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_SalesRegion_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_SalesRegion_BY_UUID;
	}
}
