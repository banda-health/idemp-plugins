package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoiceSchedule;

/**
 * Data Loader for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceScheduleDataLoader extends PODataLoader<MInvoiceSchedule> {
	public static String C_InvoiceSchedule_BY_ID_DATA_LOADER = "C_InvoiceScheduleByIdDataLoader";
	public static String C_InvoiceSchedule_BY_UUID_DATA_LOADER = "C_InvoiceScheduleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoiceSchedule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_InvoiceSchedule_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_InvoiceSchedule_BY_UUID_DATA_LOADER;
	}
}
