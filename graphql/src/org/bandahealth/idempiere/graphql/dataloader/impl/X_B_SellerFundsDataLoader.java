package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_SellerFunds;

/**
 * Data Loader for B_SellerFunds - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_B_SellerFundsDataLoader extends PODataLoader<X_B_SellerFunds> {
	public static String DATALOADER_B_SellerFunds_BY_ID = "B_SellerFundsByIdDataLoader";
	public static String DATALOADER_B_SellerFunds_BY_UUID = "B_SellerFundsByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_SellerFunds.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_B_SellerFunds_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_B_SellerFunds_BY_UUID;
	}
}
