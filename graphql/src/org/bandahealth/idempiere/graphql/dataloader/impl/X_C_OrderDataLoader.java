package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;

/**
 * Data Loader for C_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_OrderDataLoader extends PODataLoader<MOrder_BH> {
	public static String DATALOADER_C_Order_BY_ID = "C_OrderByIdDataLoader";
	public static String DATALOADER_C_Order_BY_UUID = "C_OrderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrder_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Order_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Order_BY_UUID;
	}
}
