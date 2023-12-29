package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order;

/**
 * Data Loader for PP_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_OrderDataLoader extends PODataLoader<X_PP_Order> {
	public static String PP_Order_BY_ID_DATA_LOADER = "PP_OrderByIdDataLoader";
	public static String PP_Order_BY_UUID_DATA_LOADER = "PP_OrderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Order_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Order_BY_UUID_DATA_LOADER;
	}
}
