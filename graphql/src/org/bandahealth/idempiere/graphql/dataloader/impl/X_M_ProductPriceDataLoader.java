package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProductPrice_BH;

/**
 * Data Loader for M_ProductPrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ProductPriceDataLoader extends PODataLoader<MProductPrice_BH> {
	public static String DATALOADER_M_ProductPrice_BY_ID = "M_ProductPriceByIdDataLoader";
	public static String DATALOADER_M_ProductPrice_BY_UUID = "M_ProductPriceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductPrice_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ProductPrice_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ProductPrice_BY_UUID;
	}
}
