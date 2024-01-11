package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_SellerFunds;

/**
 * Data Loader for B_SellerFunds - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_SellerFundsDataLoader extends PODataLoader<X_B_SellerFunds> {
	public static String B_SellerFunds_BY_ID_DATA_LOADER = "B_SellerFundsByIdDataLoader";
	public static String B_SellerFunds_BY_UUID_DATA_LOADER = "B_SellerFundsByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_SellerFunds.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return B_SellerFunds_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return B_SellerFunds_BY_UUID_DATA_LOADER;
	}
}
