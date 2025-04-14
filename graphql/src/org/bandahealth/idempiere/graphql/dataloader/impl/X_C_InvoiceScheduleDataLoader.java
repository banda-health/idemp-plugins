package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoiceSchedule;

/**
 * Data Loader for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_InvoiceScheduleDataLoader extends PODataLoader<MInvoiceSchedule> {
	public static String DATALOADER_C_InvoiceSchedule_BY_ID = "C_InvoiceScheduleByIdDataLoader";
	public static String DATALOADER_C_InvoiceSchedule_BY_UUID = "C_InvoiceScheduleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoiceSchedule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_InvoiceSchedule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_InvoiceSchedule_BY_UUID;
	}
}
