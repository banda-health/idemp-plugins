package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Invoice;

/**
 * Data Loader for I_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_InvoiceDataLoader extends PODataLoader<X_I_Invoice> {
	public static String I_Invoice_BY_ID_DATA_LOADER = "I_InvoiceByIdDataLoader";
	public static String I_Invoice_BY_UUID_DATA_LOADER = "I_InvoiceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Invoice.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_Invoice_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_Invoice_BY_UUID_DATA_LOADER;
	}
}
