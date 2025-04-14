package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_Buyer;

/**
 * Data Loader for B_Buyer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_B_BuyerDataLoader extends PODataLoader<X_B_Buyer> {
	public static String DATALOADER_B_Buyer_BY_ID = "B_BuyerByIdDataLoader";
	public static String DATALOADER_B_Buyer_BY_UUID = "B_BuyerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_Buyer.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_B_Buyer_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_B_Buyer_BY_UUID;
	}
}
