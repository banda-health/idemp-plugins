package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPriceList;

/**
 * Data Loader for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PriceListDataLoader extends PODataLoader<MPriceList> {
	public static String M_PriceList_BY_ID_DATA_LOADER = "M_PriceListByIdDataLoader";
	public static String M_PriceList_BY_UUID_DATA_LOADER = "M_PriceListByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPriceList.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PriceList_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PriceList_BY_UUID_DATA_LOADER;
	}
}
