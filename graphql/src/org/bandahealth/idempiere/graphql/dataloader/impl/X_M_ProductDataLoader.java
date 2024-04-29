package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProduct_BH;

/**
 * Data Loader for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductDataLoader extends PODataLoader<MProduct_BH> {
	public static String DATALOADER_M_Product_BY_ID = "M_ProductByIdDataLoader";
	public static String DATALOADER_M_Product_BY_UUID = "M_ProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProduct_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Product_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Product_BY_UUID;
	}
}
