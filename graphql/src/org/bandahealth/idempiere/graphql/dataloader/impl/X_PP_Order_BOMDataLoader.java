package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_BOM;

/**
 * Data Loader for PP_Order_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_Order_BOMDataLoader extends PODataLoader<X_PP_Order_BOM> {
	public static String DATALOADER_PP_Order_BOM_BY_ID = "PP_Order_BOMByIdDataLoader";
	public static String DATALOADER_PP_Order_BOM_BY_UUID = "PP_Order_BOMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_BOM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Order_BOM_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Order_BOM_BY_UUID;
	}
}
