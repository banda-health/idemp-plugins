package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInvoice_BH;

/**
 * Data Loader for C_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_InvoiceDataLoader extends PODataLoader<MInvoice_BH> {
	public static String DATALOADER_C_Invoice_BY_ID = "C_InvoiceByIdDataLoader";
	public static String DATALOADER_C_Invoice_BY_UUID = "C_InvoiceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoice_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Invoice_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Invoice_BY_UUID;
	}
}
