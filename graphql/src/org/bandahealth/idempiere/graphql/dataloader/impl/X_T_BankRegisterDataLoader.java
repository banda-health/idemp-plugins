package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_BankRegister;

/**
 * Data Loader for T_BankRegister - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_BankRegisterDataLoader extends PODataLoader<X_T_BankRegister> {
	public static String T_BankRegister_BY_ID_DATA_LOADER = "T_BankRegisterByIdDataLoader";
	public static String T_BankRegister_BY_UUID_DATA_LOADER = "T_BankRegisterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_BankRegister.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_BankRegister_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_BankRegister_BY_UUID_DATA_LOADER;
	}
}
