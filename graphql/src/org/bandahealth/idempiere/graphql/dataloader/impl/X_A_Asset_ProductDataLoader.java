package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetProduct;

/**
 * Data Loader for A_Asset_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_ProductDataLoader extends PODataLoader<MAssetProduct> {
	public static String A_Asset_Product_BY_ID_DATA_LOADER = "A_Asset_ProductByIdDataLoader";
	public static String A_Asset_Product_BY_UUID_DATA_LOADER = "A_Asset_ProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetProduct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Product_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Product_BY_UUID_DATA_LOADER;
	}
}
