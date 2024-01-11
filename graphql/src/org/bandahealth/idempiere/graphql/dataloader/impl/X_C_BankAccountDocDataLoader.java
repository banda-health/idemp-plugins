package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_BankAccountDoc;

/**
 * Data Loader for C_BankAccountDoc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankAccountDocDataLoader extends PODataLoader<X_C_BankAccountDoc> {
	public static String C_BankAccountDoc_BY_ID_DATA_LOADER = "C_BankAccountDocByIdDataLoader";
	public static String C_BankAccountDoc_BY_UUID_DATA_LOADER = "C_BankAccountDocByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_BankAccountDoc.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BankAccountDoc_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BankAccountDoc_BY_UUID_DATA_LOADER;
	}
}
