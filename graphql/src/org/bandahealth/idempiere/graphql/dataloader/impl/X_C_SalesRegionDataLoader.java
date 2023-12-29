package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSalesRegion;

/**
 * Data Loader for C_SalesRegion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SalesRegionDataLoader extends PODataLoader<MSalesRegion> {
	public static String C_SalesRegion_BY_ID_DATA_LOADER = "C_SalesRegionByIdDataLoader";
	public static String C_SalesRegion_BY_UUID_DATA_LOADER = "C_SalesRegionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSalesRegion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_SalesRegion_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_SalesRegion_BY_UUID_DATA_LOADER;
	}
}
