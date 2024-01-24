package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_BuyerFunds;

/**
 * Data Loader for B_BuyerFunds - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_BuyerFundsDataLoader extends PODataLoader<X_B_BuyerFunds> {
	public static String DATALOADER_B_BuyerFunds_BY_ID = "B_BuyerFundsByIdDataLoader";
	public static String DATALOADER_B_BuyerFunds_BY_UUID = "B_BuyerFundsByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_BuyerFunds.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_B_BuyerFunds_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_B_BuyerFunds_BY_UUID;
	}
}
