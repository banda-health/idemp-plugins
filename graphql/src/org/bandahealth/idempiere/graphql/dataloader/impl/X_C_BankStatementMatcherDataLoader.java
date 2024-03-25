package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBankStatementMatcher;

/**
 * Data Loader for C_BankStatementMatcher - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankStatementMatcherDataLoader extends PODataLoader<MBankStatementMatcher> {
	public static String DATALOADER_C_BankStatementMatcher_BY_ID = "C_BankStatementMatcherByIdDataLoader";
	public static String DATALOADER_C_BankStatementMatcher_BY_UUID = "C_BankStatementMatcherByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankStatementMatcher.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BankStatementMatcher_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BankStatementMatcher_BY_UUID;
	}
}
