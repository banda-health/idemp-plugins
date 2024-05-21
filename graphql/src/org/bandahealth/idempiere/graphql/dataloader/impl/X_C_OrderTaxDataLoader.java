package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOrderTax;

/**
 * Data Loader for C_OrderTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OrderTaxDataLoader extends PODataLoader<MOrderTax> {
	public static String DATALOADER_C_OrderTax_BY_ID = "C_OrderTaxByIdDataLoader";
	public static String DATALOADER_C_OrderTax_BY_UUID = "C_OrderTaxByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrderTax.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_OrderTax_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_OrderTax_BY_UUID;
	}
}
