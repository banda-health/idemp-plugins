package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoiceBatchLine;

/**
 * Data Loader for C_InvoiceBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_InvoiceBatchLineDataLoader extends PODataLoader<MInvoiceBatchLine> {
	public static String DATALOADER_C_InvoiceBatchLine_BY_ID = "C_InvoiceBatchLineByIdDataLoader";
	public static String DATALOADER_C_InvoiceBatchLine_BY_UUID = "C_InvoiceBatchLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoiceBatchLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_InvoiceBatchLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_InvoiceBatchLine_BY_UUID;
	}
}
