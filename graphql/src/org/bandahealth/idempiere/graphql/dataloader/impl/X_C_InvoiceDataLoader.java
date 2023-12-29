package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInvoice_BH;

/**
 * Data Loader for C_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceDataLoader extends PODataLoader<MInvoice_BH> {
	public static String C_Invoice_BY_ID_DATA_LOADER = "C_InvoiceByIdDataLoader";
	public static String C_Invoice_BY_UUID_DATA_LOADER = "C_InvoiceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoice_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Invoice_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Invoice_BY_UUID_DATA_LOADER;
	}
}
