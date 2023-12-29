package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;

/**
 * Data Loader for C_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderDataLoader extends PODataLoader<MOrder_BH> {
	public static String C_Order_BY_ID_DATA_LOADER = "C_OrderByIdDataLoader";
	public static String C_Order_BY_UUID_DATA_LOADER = "C_OrderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrder_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Order_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Order_BY_UUID_DATA_LOADER;
	}
}
