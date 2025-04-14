package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoiceLine;

/**
 * Data Loader for C_InvoiceLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_InvoiceLineDataLoader extends PODataLoader<MInvoiceLine> {
	public static String DATALOADER_C_InvoiceLine_BY_ID = "C_InvoiceLineByIdDataLoader";
	public static String DATALOADER_C_InvoiceLine_BY_UUID = "C_InvoiceLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoiceLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_InvoiceLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_InvoiceLine_BY_UUID;
	}
}
