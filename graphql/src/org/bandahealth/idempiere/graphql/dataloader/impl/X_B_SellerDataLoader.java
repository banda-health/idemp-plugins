package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_Seller;

/**
 * Data Loader for B_Seller - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_B_SellerDataLoader extends PODataLoader<X_B_Seller> {
	public static String DATALOADER_B_Seller_BY_ID = "B_SellerByIdDataLoader";
	public static String DATALOADER_B_Seller_BY_UUID = "B_SellerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_Seller.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_B_Seller_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_B_Seller_BY_UUID;
	}
}
