package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_Node;

/**
 * Data Loader for PP_Order_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Order_NodeDataLoader extends PODataLoader<X_PP_Order_Node> {
	public static String DATALOADER_PP_Order_Node_BY_ID = "PP_Order_NodeByIdDataLoader";
	public static String DATALOADER_PP_Order_Node_BY_UUID = "PP_Order_NodeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_Node.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Order_Node_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Order_Node_BY_UUID;
	}
}
