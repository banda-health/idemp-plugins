package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoiceBatch;

/**
 * Data Loader for C_InvoiceBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoiceBatchDataLoader extends PODataLoader<MInvoiceBatch> {
	public static String DATALOADER_C_InvoiceBatch_BY_ID = "C_InvoiceBatchByIdDataLoader";
	public static String DATALOADER_C_InvoiceBatch_BY_UUID = "C_InvoiceBatchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoiceBatch.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_InvoiceBatch_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_InvoiceBatch_BY_UUID;
	}
}
