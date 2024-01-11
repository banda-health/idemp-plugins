package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOrderLandedCostAllocation;

/**
 * Data Loader for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderLandedCostAllocationDataLoader extends PODataLoader<MOrderLandedCostAllocation> {
	public static String C_OrderLandedCostAllocation_BY_ID_DATA_LOADER = "C_OrderLandedCostAllocationByIdDataLoader";
	public static String C_OrderLandedCostAllocation_BY_UUID_DATA_LOADER = "C_OrderLandedCostAllocationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrderLandedCostAllocation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_OrderLandedCostAllocation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_OrderLandedCostAllocation_BY_UUID_DATA_LOADER;
	}
}
