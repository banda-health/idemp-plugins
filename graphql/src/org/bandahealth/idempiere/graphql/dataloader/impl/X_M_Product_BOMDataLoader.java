package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProductBOM;

/**
 * Data Loader for M_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_BOMDataLoader extends PODataLoader<MProductBOM> {
	public static String DATALOADER_M_Product_BOM_BY_ID = "M_Product_BOMByIdDataLoader";
	public static String DATALOADER_M_Product_BOM_BY_UUID = "M_Product_BOMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductBOM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Product_BOM_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Product_BOM_BY_UUID;
	}
}
