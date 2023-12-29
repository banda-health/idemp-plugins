package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRegion;

/**
 * Data Loader for C_Region - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RegionDataLoader extends PODataLoader<MRegion> {
	public static String C_Region_BY_ID_DATA_LOADER = "C_RegionByIdDataLoader";
	public static String C_Region_BY_UUID_DATA_LOADER = "C_RegionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRegion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Region_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Region_BY_UUID_DATA_LOADER;
	}
}
