package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProductCategory_BH;

/**
 * Data Loader for M_Product_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_CategoryDataLoader extends PODataLoader<MProductCategory_BH> {
	public static String M_Product_Category_BY_ID_DATA_LOADER = "M_Product_CategoryByIdDataLoader";
	public static String M_Product_Category_BY_UUID_DATA_LOADER = "M_Product_CategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductCategory_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Product_Category_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Product_Category_BY_UUID_DATA_LOADER;
	}
}
