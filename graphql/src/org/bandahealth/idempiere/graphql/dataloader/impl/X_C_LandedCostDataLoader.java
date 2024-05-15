package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLandedCost;

/**
 * Data Loader for C_LandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_LandedCostDataLoader extends PODataLoader<MLandedCost> {
	public static String DATALOADER_C_LandedCost_BY_ID = "C_LandedCostByIdDataLoader";
	public static String DATALOADER_C_LandedCost_BY_UUID = "C_LandedCostByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLandedCost.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_LandedCost_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_LandedCost_BY_UUID;
	}
}
