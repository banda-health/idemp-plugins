package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_BOMLine;

/**
 * Data Loader for PP_Order_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_BOMLineDataLoader extends PODataLoader<X_PP_Order_BOMLine> {
	public static String PP_Order_BOMLine_BY_ID_DATA_LOADER = "PP_Order_BOMLineByIdDataLoader";
	public static String PP_Order_BOMLine_BY_UUID_DATA_LOADER = "PP_Order_BOMLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_BOMLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Order_BOMLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Order_BOMLine_BY_UUID_DATA_LOADER;
	}
}
