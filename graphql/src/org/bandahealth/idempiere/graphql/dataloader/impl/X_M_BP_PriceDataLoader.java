package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_BP_Price;

/**
 * Data Loader for M_BP_Price - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_BP_PriceDataLoader extends PODataLoader<X_M_BP_Price> {
	public static String M_BP_Price_BY_ID_DATA_LOADER = "M_BP_PriceByIdDataLoader";
	public static String M_BP_Price_BY_UUID_DATA_LOADER = "M_BP_PriceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_BP_Price.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_BP_Price_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_BP_Price_BY_UUID_DATA_LOADER;
	}
}
