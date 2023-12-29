package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_Cost;

/**
 * Data Loader for PP_Order_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_CostDataLoader extends PODataLoader<X_PP_Order_Cost> {
	public static String PP_Order_Cost_BY_ID_DATA_LOADER = "PP_Order_CostByIdDataLoader";
	public static String PP_Order_Cost_BY_UUID_DATA_LOADER = "PP_Order_CostByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_Cost.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Order_Cost_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Order_Cost_BY_UUID_DATA_LOADER;
	}
}
