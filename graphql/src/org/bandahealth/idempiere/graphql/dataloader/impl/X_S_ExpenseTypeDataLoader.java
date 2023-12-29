package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MExpenseType;

/**
 * Data Loader for S_ExpenseType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ExpenseTypeDataLoader extends PODataLoader<MExpenseType> {
	public static String S_ExpenseType_BY_ID_DATA_LOADER = "S_ExpenseTypeByIdDataLoader";
	public static String S_ExpenseType_BY_UUID_DATA_LOADER = "S_ExpenseTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MExpenseType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return S_ExpenseType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return S_ExpenseType_BY_UUID_DATA_LOADER;
	}
}
