package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHProductCategoryDefault;

/**
 * Data Loader for BH_Product_CategoryDefault - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Product_CategoryDefaultDataLoader extends PODataLoader<MBHProductCategoryDefault> {
	public static String DATALOADER_BH_Product_CategoryDefault_BY_ID = "BH_Product_CategoryDefaultByIdDataLoader";
	public static String DATALOADER_BH_Product_CategoryDefault_BY_UUID = "BH_Product_CategoryDefaultByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHProductCategoryDefault.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Product_CategoryDefault_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Product_CategoryDefault_BY_UUID;
	}
}
