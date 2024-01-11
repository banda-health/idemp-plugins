package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoicePaySchedule;

/**
 * Data Loader for C_InvoicePaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoicePayScheduleDataLoader extends PODataLoader<MInvoicePaySchedule> {
	public static String C_InvoicePaySchedule_BY_ID_DATA_LOADER = "C_InvoicePayScheduleByIdDataLoader";
	public static String C_InvoicePaySchedule_BY_UUID_DATA_LOADER = "C_InvoicePayScheduleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoicePaySchedule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_InvoicePaySchedule_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_InvoicePaySchedule_BY_UUID_DATA_LOADER;
	}
}
