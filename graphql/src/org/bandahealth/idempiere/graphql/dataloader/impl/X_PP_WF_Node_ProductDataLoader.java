package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_WF_Node_Product;

/**
 * Data Loader for PP_WF_Node_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_WF_Node_ProductDataLoader extends PODataLoader<X_PP_WF_Node_Product> {
	public static String DATALOADER_PP_WF_Node_Product_BY_ID = "PP_WF_Node_ProductByIdDataLoader";
	public static String DATALOADER_PP_WF_Node_Product_BY_UUID = "PP_WF_Node_ProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_WF_Node_Product.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_WF_Node_Product_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_WF_Node_Product_BY_UUID;
	}
}
