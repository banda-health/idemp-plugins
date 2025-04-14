package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPriceList;

/**
 * Data Loader for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_PriceListDataLoader extends PODataLoader<MPriceList> {
	public static String DATALOADER_M_PriceList_BY_ID = "M_PriceListByIdDataLoader";
	public static String DATALOADER_M_PriceList_BY_UUID = "M_PriceListByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPriceList.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PriceList_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PriceList_BY_UUID;
	}
}
