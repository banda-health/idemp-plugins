package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ProductPriceVendorBreak;

/**
 * Data Loader for M_ProductPriceVendorBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductPriceVendorBreakDataLoader extends PODataLoader<X_M_ProductPriceVendorBreak> {
	public static String DATALOADER_M_ProductPriceVendorBreak_BY_ID = "M_ProductPriceVendorBreakByIdDataLoader";
	public static String DATALOADER_M_ProductPriceVendorBreak_BY_UUID = "M_ProductPriceVendorBreakByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ProductPriceVendorBreak.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ProductPriceVendorBreak_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ProductPriceVendorBreak_BY_UUID;
	}
}
