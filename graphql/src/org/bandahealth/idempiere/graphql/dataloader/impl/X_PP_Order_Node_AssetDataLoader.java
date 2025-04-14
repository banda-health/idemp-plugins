package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_Node_Asset;

/**
 * Data Loader for PP_Order_Node_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Order_Node_AssetDataLoader extends PODataLoader<X_PP_Order_Node_Asset> {
	public static String DATALOADER_PP_Order_Node_Asset_BY_ID = "PP_Order_Node_AssetByIdDataLoader";
	public static String DATALOADER_PP_Order_Node_Asset_BY_UUID = "PP_Order_Node_AssetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_Node_Asset.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Order_Node_Asset_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Order_Node_Asset_BY_UUID;
	}
}
