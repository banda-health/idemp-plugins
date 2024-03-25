package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOrderLandedCost;

/**
 * Data Loader for C_OrderLandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OrderLandedCostDataLoader extends PODataLoader<MOrderLandedCost> {
	public static String DATALOADER_C_OrderLandedCost_BY_ID = "C_OrderLandedCostByIdDataLoader";
	public static String DATALOADER_C_OrderLandedCost_BY_UUID = "C_OrderLandedCostByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrderLandedCost.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_OrderLandedCost_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_OrderLandedCost_BY_UUID;
	}
}
