package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTimeExpense;

/**
 * Data Loader for S_TimeExpense - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_S_TimeExpenseDataLoader extends PODataLoader<MTimeExpense> {
	public static String DATALOADER_S_TimeExpense_BY_ID = "S_TimeExpenseByIdDataLoader";
	public static String DATALOADER_S_TimeExpense_BY_UUID = "S_TimeExpenseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTimeExpense.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_S_TimeExpense_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_S_TimeExpense_BY_UUID;
	}
}
