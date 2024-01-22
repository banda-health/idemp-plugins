package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Charge_Acct;

/**
 * Data Loader for C_Charge_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_Charge_AcctDataLoader extends PODataLoader<X_C_Charge_Acct> {
	public static String DATALOADER_C_Charge_Acct_BY_ID = "C_Charge_AcctByIdDataLoader";
	public static String DATALOADER_C_Charge_Acct_BY_UUID = "C_Charge_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Charge_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Charge_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Charge_Acct_BY_UUID;
	}
}
