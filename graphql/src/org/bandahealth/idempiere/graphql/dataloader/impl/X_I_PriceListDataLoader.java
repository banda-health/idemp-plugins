package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_PriceList;

/**
 * Data Loader for I_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_PriceListDataLoader extends PODataLoader<X_I_PriceList> {
	public static String DATALOADER_I_PriceList_BY_ID = "I_PriceListByIdDataLoader";
	public static String DATALOADER_I_PriceList_BY_UUID = "I_PriceListByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_PriceList.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_PriceList_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_PriceList_BY_UUID;
	}
}
