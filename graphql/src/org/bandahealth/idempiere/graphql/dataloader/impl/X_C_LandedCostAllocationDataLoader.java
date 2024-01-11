package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLandedCostAllocation;

/**
 * Data Loader for C_LandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_LandedCostAllocationDataLoader extends PODataLoader<MLandedCostAllocation> {
	public static String C_LandedCostAllocation_BY_ID_DATA_LOADER = "C_LandedCostAllocationByIdDataLoader";
	public static String C_LandedCostAllocation_BY_UUID_DATA_LOADER = "C_LandedCostAllocationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLandedCostAllocation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_LandedCostAllocation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_LandedCostAllocation_BY_UUID_DATA_LOADER;
	}
}
