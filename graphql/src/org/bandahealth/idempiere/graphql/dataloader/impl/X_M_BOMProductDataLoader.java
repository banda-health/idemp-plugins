package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBOMProduct;

/**
 * Data Loader for M_BOMProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_BOMProductDataLoader extends PODataLoader<MBOMProduct> {
	public static String DATALOADER_M_BOMProduct_BY_ID = "M_BOMProductByIdDataLoader";
	public static String DATALOADER_M_BOMProduct_BY_UUID = "M_BOMProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBOMProduct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_BOMProduct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_BOMProduct_BY_UUID;
	}
}
