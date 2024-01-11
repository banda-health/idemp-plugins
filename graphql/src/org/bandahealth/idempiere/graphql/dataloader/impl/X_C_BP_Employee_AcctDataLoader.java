package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_BP_Employee_Acct;

/**
 * Data Loader for C_BP_Employee_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_Employee_AcctDataLoader extends PODataLoader<X_C_BP_Employee_Acct> {
	public static String C_BP_Employee_Acct_BY_ID_DATA_LOADER = "C_BP_Employee_AcctByIdDataLoader";
	public static String C_BP_Employee_Acct_BY_UUID_DATA_LOADER = "C_BP_Employee_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_BP_Employee_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BP_Employee_Acct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BP_Employee_Acct_BY_UUID_DATA_LOADER;
	}
}
