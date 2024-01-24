package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Product;

/**
 * Data Loader for I_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_ProductDataLoader extends PODataLoader<X_I_Product> {
	public static String DATALOADER_I_Product_BY_ID = "I_ProductByIdDataLoader";
	public static String DATALOADER_I_Product_BY_UUID = "I_ProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Product.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_Product_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_Product_BY_UUID;
	}
}
