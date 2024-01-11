package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_FundingMode_Acct;

/**
 * Data Loader for A_FundingMode_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_FundingMode_AcctDataLoader extends PODataLoader<X_A_FundingMode_Acct> {
	public static String A_FundingMode_Acct_BY_ID_DATA_LOADER = "A_FundingMode_AcctByIdDataLoader";
	public static String A_FundingMode_Acct_BY_UUID_DATA_LOADER = "A_FundingMode_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_FundingMode_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_FundingMode_Acct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_FundingMode_Acct_BY_UUID_DATA_LOADER;
	}
}
