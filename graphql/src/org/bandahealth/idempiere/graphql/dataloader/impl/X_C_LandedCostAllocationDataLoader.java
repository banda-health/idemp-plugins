package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLandedCostAllocation;

/**
 * Data Loader for C_LandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_LandedCostAllocationDataLoader extends PODataLoader<MLandedCostAllocation> {
	public static String DATALOADER_C_LandedCostAllocation_BY_ID = "C_LandedCostAllocationByIdDataLoader";
	public static String DATALOADER_C_LandedCostAllocation_BY_UUID = "C_LandedCostAllocationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLandedCostAllocation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_LandedCostAllocation_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_LandedCostAllocation_BY_UUID;
	}
}
