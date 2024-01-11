package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_Bid;

/**
 * Data Loader for B_Bid - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_BidDataLoader extends PODataLoader<X_B_Bid> {
	public static String B_Bid_BY_ID_DATA_LOADER = "B_BidByIdDataLoader";
	public static String B_Bid_BY_UUID_DATA_LOADER = "B_BidByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_Bid.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return B_Bid_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return B_Bid_BY_UUID_DATA_LOADER;
	}
}
