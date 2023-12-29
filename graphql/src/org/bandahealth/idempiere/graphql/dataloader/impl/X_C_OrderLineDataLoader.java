package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;

/**
 * Data Loader for C_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderLineDataLoader extends PODataLoader<MOrderLine_BH> {
	public static String C_OrderLine_BY_ID_DATA_LOADER = "C_OrderLineByIdDataLoader";
	public static String C_OrderLine_BY_UUID_DATA_LOADER = "C_OrderLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrderLine_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_OrderLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_OrderLine_BY_UUID_DATA_LOADER;
	}
}
