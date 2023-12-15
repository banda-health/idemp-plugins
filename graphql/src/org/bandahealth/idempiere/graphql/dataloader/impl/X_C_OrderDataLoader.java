package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;

public class X_C_OrderDataLoader extends PODataLoader<MOrder_BH> {
	public static String C_ORDER_BY_ID_DATA_LOADER = "C_OrderByIdDataLoader";
	public static String C_ORDER_BY_UUID_DATA_LOADER = "C_OrderByUuidDataLoader";

	@Override
	protected String getByIdDataLoaderName() {
		return C_ORDER_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ORDER_BY_UUID_DATA_LOADER;
	}

	@Override
	protected String getEntityTableName() {
		return MOrder_BH.Table_Name;
	}
}
