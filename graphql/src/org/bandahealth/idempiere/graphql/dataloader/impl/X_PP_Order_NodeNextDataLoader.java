package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_NodeNext;

/**
 * Data Loader for PP_Order_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Order_NodeNextDataLoader extends PODataLoader<X_PP_Order_NodeNext> {
	public static String DATALOADER_PP_Order_NodeNext_BY_ID = "PP_Order_NodeNextByIdDataLoader";
	public static String DATALOADER_PP_Order_NodeNext_BY_UUID = "PP_Order_NodeNextByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_NodeNext.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Order_NodeNext_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Order_NodeNext_BY_UUID;
	}
}
