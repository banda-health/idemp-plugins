package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProduct_BH;

/**
 * Data Loader for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductDataLoader extends PODataLoader<MProduct_BH> {
	public static String M_Product_BY_ID_DATA_LOADER = "M_ProductByIdDataLoader";
	public static String M_Product_BY_UUID_DATA_LOADER = "M_ProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProduct_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Product_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Product_BY_UUID_DATA_LOADER;
	}
}
