package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ProductPriceVendorBreak;

/**
 * Data Loader for M_ProductPriceVendorBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductPriceVendorBreakDataLoader extends PODataLoader<X_M_ProductPriceVendorBreak> {
	public static String M_ProductPriceVendorBreak_BY_ID_DATA_LOADER = "M_ProductPriceVendorBreakByIdDataLoader";
	public static String M_ProductPriceVendorBreak_BY_UUID_DATA_LOADER = "M_ProductPriceVendorBreakByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ProductPriceVendorBreak.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ProductPriceVendorBreak_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ProductPriceVendorBreak_BY_UUID_DATA_LOADER;
	}
}
