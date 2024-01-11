package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoiceTax;

/**
 * Data Loader for C_InvoiceTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceTaxDataLoader extends PODataLoader<MInvoiceTax> {
	public static String C_InvoiceTax_BY_ID_DATA_LOADER = "C_InvoiceTaxByIdDataLoader";
	public static String C_InvoiceTax_BY_UUID_DATA_LOADER = "C_InvoiceTaxByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoiceTax.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_InvoiceTax_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_InvoiceTax_BY_UUID_DATA_LOADER;
	}
}
