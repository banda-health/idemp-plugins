package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_BankRegister;

/**
 * Data Loader for T_BankRegister - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_T_BankRegisterDataLoader extends PODataLoader<X_T_BankRegister> {
	public static String DATALOADER_T_BankRegister_BY_ID = "T_BankRegisterByIdDataLoader";
	public static String DATALOADER_T_BankRegister_BY_UUID = "T_BankRegisterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_BankRegister.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_BankRegister_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_BankRegister_BY_UUID;
	}
}
