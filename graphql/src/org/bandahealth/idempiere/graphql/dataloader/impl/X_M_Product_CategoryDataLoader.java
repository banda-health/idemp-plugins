package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProductCategory_BH;

/**
 * Data Loader for M_Product_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_Product_CategoryDataLoader extends PODataLoader<MProductCategory_BH> {
	public static String DATALOADER_M_Product_Category_BY_ID = "M_Product_CategoryByIdDataLoader";
	public static String DATALOADER_M_Product_Category_BY_UUID = "M_Product_CategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductCategory_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Product_Category_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Product_Category_BY_UUID;
	}
}
