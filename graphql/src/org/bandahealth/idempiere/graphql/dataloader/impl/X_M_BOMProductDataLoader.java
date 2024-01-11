package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBOMProduct;

/**
 * Data Loader for M_BOMProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_BOMProductDataLoader extends PODataLoader<MBOMProduct> {
	public static String M_BOMProduct_BY_ID_DATA_LOADER = "M_BOMProductByIdDataLoader";
	public static String M_BOMProduct_BY_UUID_DATA_LOADER = "M_BOMProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBOMProduct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_BOMProduct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_BOMProduct_BY_UUID_DATA_LOADER;
	}
}
