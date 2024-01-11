package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLandedCost;

/**
 * Data Loader for C_LandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_LandedCostDataLoader extends PODataLoader<MLandedCost> {
	public static String C_LandedCost_BY_ID_DATA_LOADER = "C_LandedCostByIdDataLoader";
	public static String C_LandedCost_BY_UUID_DATA_LOADER = "C_LandedCostByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLandedCost.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_LandedCost_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_LandedCost_BY_UUID_DATA_LOADER;
	}
}
