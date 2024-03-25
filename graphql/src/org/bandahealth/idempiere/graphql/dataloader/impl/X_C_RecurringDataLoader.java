package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRecurring;

/**
 * Data Loader for C_Recurring - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RecurringDataLoader extends PODataLoader<MRecurring> {
	public static String DATALOADER_C_Recurring_BY_ID = "C_RecurringByIdDataLoader";
	public static String DATALOADER_C_Recurring_BY_UUID = "C_RecurringByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRecurring.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Recurring_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Recurring_BY_UUID;
	}
}
