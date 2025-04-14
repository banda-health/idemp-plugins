package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MExpenseType;

/**
 * Data Loader for S_ExpenseType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_S_ExpenseTypeDataLoader extends PODataLoader<MExpenseType> {
	public static String DATALOADER_S_ExpenseType_BY_ID = "S_ExpenseTypeByIdDataLoader";
	public static String DATALOADER_S_ExpenseType_BY_UUID = "S_ExpenseTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MExpenseType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_S_ExpenseType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_S_ExpenseType_BY_UUID;
	}
}
