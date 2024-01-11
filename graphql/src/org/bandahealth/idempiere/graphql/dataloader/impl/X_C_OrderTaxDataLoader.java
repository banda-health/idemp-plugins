package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOrderTax;

/**
 * Data Loader for C_OrderTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderTaxDataLoader extends PODataLoader<MOrderTax> {
	public static String C_OrderTax_BY_ID_DATA_LOADER = "C_OrderTaxByIdDataLoader";
	public static String C_OrderTax_BY_UUID_DATA_LOADER = "C_OrderTaxByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrderTax.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_OrderTax_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_OrderTax_BY_UUID_DATA_LOADER;
	}
}
