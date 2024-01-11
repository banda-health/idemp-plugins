package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOrderLandedCost;

/**
 * Data Loader for C_OrderLandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderLandedCostDataLoader extends PODataLoader<MOrderLandedCost> {
	public static String C_OrderLandedCost_BY_ID_DATA_LOADER = "C_OrderLandedCostByIdDataLoader";
	public static String C_OrderLandedCost_BY_UUID_DATA_LOADER = "C_OrderLandedCostByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrderLandedCost.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_OrderLandedCost_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_OrderLandedCost_BY_UUID_DATA_LOADER;
	}
}
