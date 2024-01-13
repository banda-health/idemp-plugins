package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBank;

/**
 * Data Loader for C_Bank - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankDataLoader extends PODataLoader<MBank> {
	public static String DATALOADER_C_Bank_BY_ID = "C_BankByIdDataLoader";
	public static String DATALOADER_C_Bank_BY_UUID = "C_BankByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBank.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Bank_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Bank_BY_UUID;
	}
}
