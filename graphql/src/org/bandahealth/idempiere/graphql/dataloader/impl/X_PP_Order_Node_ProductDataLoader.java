package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_Node_Product;

/**
 * Data Loader for PP_Order_Node_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_Node_ProductDataLoader extends PODataLoader<X_PP_Order_Node_Product> {
	public static String PP_Order_Node_Product_BY_ID_DATA_LOADER = "PP_Order_Node_ProductByIdDataLoader";
	public static String PP_Order_Node_Product_BY_UUID_DATA_LOADER = "PP_Order_Node_ProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_Node_Product.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Order_Node_Product_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Order_Node_Product_BY_UUID_DATA_LOADER;
	}
}
