package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProductPrice_BH;

/**
 * Data Loader for M_ProductPrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductPriceDataLoader extends PODataLoader<MProductPrice_BH> {
	public static String M_ProductPrice_BY_ID_DATA_LOADER = "M_ProductPriceByIdDataLoader";
	public static String M_ProductPrice_BY_UUID_DATA_LOADER = "M_ProductPriceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductPrice_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ProductPrice_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ProductPrice_BY_UUID_DATA_LOADER;
	}
}
