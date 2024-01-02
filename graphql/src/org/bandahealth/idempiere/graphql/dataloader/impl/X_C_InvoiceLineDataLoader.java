package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;

/**
 * Data Loader for C_InvoiceLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceLineDataLoader extends PODataLoader<MInvoiceLine_BH> {
	public static String C_InvoiceLine_BY_ID_DATA_LOADER = "C_InvoiceLineByIdDataLoader";
	public static String C_InvoiceLine_BY_UUID_DATA_LOADER = "C_InvoiceLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoiceLine_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_InvoiceLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_InvoiceLine_BY_UUID_DATA_LOADER;
	}
}
