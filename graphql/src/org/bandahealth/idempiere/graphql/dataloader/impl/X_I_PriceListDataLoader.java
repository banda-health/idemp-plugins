package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_PriceList;

/**
 * Data Loader for I_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_PriceListDataLoader extends PODataLoader<X_I_PriceList> {
	public static String I_PriceList_BY_ID_DATA_LOADER = "I_PriceListByIdDataLoader";
	public static String I_PriceList_BY_UUID_DATA_LOADER = "I_PriceListByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_PriceList.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_PriceList_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_PriceList_BY_UUID_DATA_LOADER;
	}
}
