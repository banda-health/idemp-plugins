package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoiceBatch;

/**
 * Data Loader for C_InvoiceBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceBatchDataLoader extends PODataLoader<MInvoiceBatch> {
	public static String C_InvoiceBatch_BY_ID_DATA_LOADER = "C_InvoiceBatchByIdDataLoader";
	public static String C_InvoiceBatch_BY_UUID_DATA_LOADER = "C_InvoiceBatchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoiceBatch.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_InvoiceBatch_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_InvoiceBatch_BY_UUID_DATA_LOADER;
	}
}
