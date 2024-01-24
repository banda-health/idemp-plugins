package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.MDDOrder;

/**
 * Data Loader for DD_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_OrderDataLoader extends PODataLoader<MDDOrder> {
	public static String DATALOADER_DD_Order_BY_ID = "DD_OrderByIdDataLoader";
	public static String DATALOADER_DD_Order_BY_UUID = "DD_OrderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDDOrder.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_DD_Order_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_DD_Order_BY_UUID;
	}
}
