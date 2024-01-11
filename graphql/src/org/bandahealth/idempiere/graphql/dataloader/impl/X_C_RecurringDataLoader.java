package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRecurring;

/**
 * Data Loader for C_Recurring - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RecurringDataLoader extends PODataLoader<MRecurring> {
	public static String C_Recurring_BY_ID_DATA_LOADER = "C_RecurringByIdDataLoader";
	public static String C_Recurring_BY_UUID_DATA_LOADER = "C_RecurringByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRecurring.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Recurring_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Recurring_BY_UUID_DATA_LOADER;
	}
}
