package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.MDDOrder;

/**
 * Data Loader for DD_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_OrderDataLoader extends PODataLoader<MDDOrder> {
	public static String DD_Order_BY_ID_DATA_LOADER = "DD_OrderByIdDataLoader";
	public static String DD_Order_BY_UUID_DATA_LOADER = "DD_OrderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDDOrder.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DD_Order_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DD_Order_BY_UUID_DATA_LOADER;
	}
}
