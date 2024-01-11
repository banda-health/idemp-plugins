package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_BankStatement;

/**
 * Data Loader for I_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_BankStatementDataLoader extends PODataLoader<X_I_BankStatement> {
	public static String I_BankStatement_BY_ID_DATA_LOADER = "I_BankStatementByIdDataLoader";
	public static String I_BankStatement_BY_UUID_DATA_LOADER = "I_BankStatementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_BankStatement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_BankStatement_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_BankStatement_BY_UUID_DATA_LOADER;
	}
}
