package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_InterOrg_Acct;

/**
 * Data Loader for C_InterOrg_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InterOrg_AcctDataLoader extends PODataLoader<X_C_InterOrg_Acct> {
	public static String DATALOADER_C_InterOrg_Acct_BY_ID = "C_InterOrg_AcctByIdDataLoader";
	public static String DATALOADER_C_InterOrg_Acct_BY_UUID = "C_InterOrg_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_InterOrg_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_InterOrg_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_InterOrg_Acct_BY_UUID;
	}
}
