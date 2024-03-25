package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_BP_Price;

/**
 * Data Loader for M_BP_Price - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_BP_PriceDataLoader extends PODataLoader<X_M_BP_Price> {
	public static String DATALOADER_M_BP_Price_BY_ID = "M_BP_PriceByIdDataLoader";
	public static String DATALOADER_M_BP_Price_BY_UUID = "M_BP_PriceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_BP_Price.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_BP_Price_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_BP_Price_BY_UUID;
	}
}
