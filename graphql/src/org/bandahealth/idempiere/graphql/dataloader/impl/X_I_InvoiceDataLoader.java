package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Invoice;

/**
 * Data Loader for I_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_InvoiceDataLoader extends PODataLoader<X_I_Invoice> {
	public static String DATALOADER_I_Invoice_BY_ID = "I_InvoiceByIdDataLoader";
	public static String DATALOADER_I_Invoice_BY_UUID = "I_InvoiceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Invoice.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_Invoice_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_Invoice_BY_UUID;
	}
}
