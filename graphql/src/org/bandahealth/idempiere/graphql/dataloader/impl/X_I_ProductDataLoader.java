package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Product;

/**
 * Data Loader for I_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_ProductDataLoader extends PODataLoader<X_I_Product> {
	public static String I_Product_BY_ID_DATA_LOADER = "I_ProductByIdDataLoader";
	public static String I_Product_BY_UUID_DATA_LOADER = "I_ProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Product.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_Product_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_Product_BY_UUID_DATA_LOADER;
	}
}
