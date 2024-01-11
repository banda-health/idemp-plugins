package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.MPPProductBOMLine;

/**
 * Data Loader for PP_Product_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Product_BOMLineDataLoader extends PODataLoader<MPPProductBOMLine> {
	public static String PP_Product_BOMLine_BY_ID_DATA_LOADER = "PP_Product_BOMLineByIdDataLoader";
	public static String PP_Product_BOMLine_BY_UUID_DATA_LOADER = "PP_Product_BOMLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPPProductBOMLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Product_BOMLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Product_BOMLine_BY_UUID_DATA_LOADER;
	}
}
