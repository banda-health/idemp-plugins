package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOrderLandedCostAllocation;

/**
 * Data Loader for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrderLandedCostAllocationDataLoader extends PODataLoader<MOrderLandedCostAllocation> {
	public static String DATALOADER_C_OrderLandedCostAllocation_BY_ID = "C_OrderLandedCostAllocationByIdDataLoader";
	public static String DATALOADER_C_OrderLandedCostAllocation_BY_UUID = "C_OrderLandedCostAllocationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrderLandedCostAllocation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_OrderLandedCostAllocation_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_OrderLandedCostAllocation_BY_UUID;
	}
}
