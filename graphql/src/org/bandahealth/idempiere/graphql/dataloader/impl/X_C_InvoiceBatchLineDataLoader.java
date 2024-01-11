package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoiceBatchLine;

/**
 * Data Loader for C_InvoiceBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceBatchLineDataLoader extends PODataLoader<MInvoiceBatchLine> {
	public static String C_InvoiceBatchLine_BY_ID_DATA_LOADER = "C_InvoiceBatchLineByIdDataLoader";
	public static String C_InvoiceBatchLine_BY_UUID_DATA_LOADER = "C_InvoiceBatchLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoiceBatchLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_InvoiceBatchLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_InvoiceBatchLine_BY_UUID_DATA_LOADER;
	}
}
