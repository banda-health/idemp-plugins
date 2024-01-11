package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBankStatementMatcher;

/**
 * Data Loader for C_BankStatementMatcher - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankStatementMatcherDataLoader extends PODataLoader<MBankStatementMatcher> {
	public static String C_BankStatementMatcher_BY_ID_DATA_LOADER = "C_BankStatementMatcherByIdDataLoader";
	public static String C_BankStatementMatcher_BY_UUID_DATA_LOADER = "C_BankStatementMatcherByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankStatementMatcher.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BankStatementMatcher_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BankStatementMatcher_BY_UUID_DATA_LOADER;
	}
}
