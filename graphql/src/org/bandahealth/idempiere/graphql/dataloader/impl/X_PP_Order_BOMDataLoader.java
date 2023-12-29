package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_BOM;

/**
 * Data Loader for PP_Order_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_BOMDataLoader extends PODataLoader<X_PP_Order_BOM> {
	public static String PP_Order_BOM_BY_ID_DATA_LOADER = "PP_Order_BOMByIdDataLoader";
	public static String PP_Order_BOM_BY_UUID_DATA_LOADER = "PP_Order_BOMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_BOM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Order_BOM_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Order_BOM_BY_UUID_DATA_LOADER;
	}
}
