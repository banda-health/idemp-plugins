package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Order;

/**
 * Data Loader for I_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_OrderDataLoader extends PODataLoader<X_I_Order> {
	public static String I_Order_BY_ID_DATA_LOADER = "I_OrderByIdDataLoader";
	public static String I_Order_BY_UUID_DATA_LOADER = "I_OrderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Order.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_Order_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_Order_BY_UUID_DATA_LOADER;
	}
}
