package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetProduct;

/**
 * Data Loader for A_Asset_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_ProductDataLoader extends PODataLoader<MAssetProduct> {
	public static String DATALOADER_A_Asset_Product_BY_ID = "A_Asset_ProductByIdDataLoader";
	public static String DATALOADER_A_Asset_Product_BY_UUID = "A_Asset_ProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetProduct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Product_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Product_BY_UUID;
	}
}
