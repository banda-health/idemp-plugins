package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.MPPProductBOM;

/**
 * Data Loader for PP_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Product_BOMDataLoader extends PODataLoader<MPPProductBOM> {
	public static String PP_Product_BOM_BY_ID_DATA_LOADER = "PP_Product_BOMByIdDataLoader";
	public static String PP_Product_BOM_BY_UUID_DATA_LOADER = "PP_Product_BOMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPPProductBOM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Product_BOM_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Product_BOM_BY_UUID_DATA_LOADER;
	}
}
