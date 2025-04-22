package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_BankStatement;

/**
 * Data Loader for I_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_BankStatementDataLoader extends PODataLoader<X_I_BankStatement> {
	public static String DATALOADER_I_BankStatement_BY_ID = "I_BankStatementByIdDataLoader";
	public static String DATALOADER_I_BankStatement_BY_UUID = "I_BankStatementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_BankStatement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_BankStatement_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_BankStatement_BY_UUID;
	}
}
