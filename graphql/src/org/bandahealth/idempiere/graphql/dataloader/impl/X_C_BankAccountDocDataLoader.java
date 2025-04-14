package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_BankAccountDoc;

/**
 * Data Loader for C_BankAccountDoc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BankAccountDocDataLoader extends PODataLoader<X_C_BankAccountDoc> {
	public static String DATALOADER_C_BankAccountDoc_BY_ID = "C_BankAccountDocByIdDataLoader";
	public static String DATALOADER_C_BankAccountDoc_BY_UUID = "C_BankAccountDocByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_BankAccountDoc.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BankAccountDoc_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BankAccountDoc_BY_UUID;
	}
}
