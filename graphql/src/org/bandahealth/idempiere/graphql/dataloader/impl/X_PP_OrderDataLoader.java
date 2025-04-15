package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order;

/**
 * Data Loader for PP_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_OrderDataLoader extends PODataLoader<X_PP_Order> {
	public static String DATALOADER_PP_Order_BY_ID = "PP_OrderByIdDataLoader";
	public static String DATALOADER_PP_Order_BY_UUID = "PP_OrderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Order_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Order_BY_UUID;
	}
}
