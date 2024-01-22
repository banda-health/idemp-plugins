package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_Cost;

/**
 * Data Loader for PP_Order_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_Order_CostDataLoader extends PODataLoader<X_PP_Order_Cost> {
	public static String DATALOADER_PP_Order_Cost_BY_ID = "PP_Order_CostByIdDataLoader";
	public static String DATALOADER_PP_Order_Cost_BY_UUID = "PP_Order_CostByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_Cost.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Order_Cost_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Order_Cost_BY_UUID;
	}
}
