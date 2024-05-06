package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_Bid;

/**
 * Data Loader for B_Bid - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_BidDataLoader extends PODataLoader<X_B_Bid> {
	public static String DATALOADER_B_Bid_BY_ID = "B_BidByIdDataLoader";
	public static String DATALOADER_B_Bid_BY_UUID = "B_BidByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_Bid.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_B_Bid_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_B_Bid_BY_UUID;
	}
}
