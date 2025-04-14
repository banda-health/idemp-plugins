package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoicePaySchedule;

/**
 * Data Loader for C_InvoicePaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_InvoicePayScheduleDataLoader extends PODataLoader<MInvoicePaySchedule> {
	public static String DATALOADER_C_InvoicePaySchedule_BY_ID = "C_InvoicePayScheduleByIdDataLoader";
	public static String DATALOADER_C_InvoicePaySchedule_BY_UUID = "C_InvoicePayScheduleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoicePaySchedule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_InvoicePaySchedule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_InvoicePaySchedule_BY_UUID;
	}
}
