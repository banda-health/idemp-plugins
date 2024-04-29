package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.MPPProductBOMLine;

/**
 * Data Loader for PP_Product_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Product_BOMLineDataLoader extends PODataLoader<MPPProductBOMLine> {
	public static String DATALOADER_PP_Product_BOMLine_BY_ID = "PP_Product_BOMLineByIdDataLoader";
	public static String DATALOADER_PP_Product_BOMLine_BY_UUID = "PP_Product_BOMLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPPProductBOMLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Product_BOMLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Product_BOMLine_BY_UUID;
	}
}
