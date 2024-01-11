package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_Buyer;

/**
 * Data Loader for B_Buyer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_BuyerDataLoader extends PODataLoader<X_B_Buyer> {
	public static String B_Buyer_BY_ID_DATA_LOADER = "B_BuyerByIdDataLoader";
	public static String B_Buyer_BY_UUID_DATA_LOADER = "B_BuyerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_Buyer.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return B_Buyer_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return B_Buyer_BY_UUID_DATA_LOADER;
	}
}
