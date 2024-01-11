package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_Seller;

/**
 * Data Loader for B_Seller - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_SellerDataLoader extends PODataLoader<X_B_Seller> {
	public static String B_Seller_BY_ID_DATA_LOADER = "B_SellerByIdDataLoader";
	public static String B_Seller_BY_UUID_DATA_LOADER = "B_SellerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_Seller.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return B_Seller_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return B_Seller_BY_UUID_DATA_LOADER;
	}
}
