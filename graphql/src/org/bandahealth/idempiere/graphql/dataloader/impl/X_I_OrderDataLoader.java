package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Order;

/**
 * Data Loader for I_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_OrderDataLoader extends PODataLoader<X_I_Order> {
	public static String DATALOADER_I_Order_BY_ID = "I_OrderByIdDataLoader";
	public static String DATALOADER_I_Order_BY_UUID = "I_OrderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Order.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_Order_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_Order_BY_UUID;
	}
}
