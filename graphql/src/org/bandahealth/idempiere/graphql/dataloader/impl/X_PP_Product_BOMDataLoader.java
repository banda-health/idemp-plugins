package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.MPPProductBOM;

/**
 * Data Loader for PP_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Product_BOMDataLoader extends PODataLoader<MPPProductBOM> {
	public static String DATALOADER_PP_Product_BOM_BY_ID = "PP_Product_BOMByIdDataLoader";
	public static String DATALOADER_PP_Product_BOM_BY_UUID = "PP_Product_BOMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPPProductBOM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Product_BOM_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Product_BOM_BY_UUID;
	}
}
