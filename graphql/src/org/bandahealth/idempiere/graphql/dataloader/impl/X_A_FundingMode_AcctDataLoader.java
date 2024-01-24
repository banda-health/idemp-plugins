package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_FundingMode_Acct;

/**
 * Data Loader for A_FundingMode_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_FundingMode_AcctDataLoader extends PODataLoader<X_A_FundingMode_Acct> {
	public static String DATALOADER_A_FundingMode_Acct_BY_ID = "A_FundingMode_AcctByIdDataLoader";
	public static String DATALOADER_A_FundingMode_Acct_BY_UUID = "A_FundingMode_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_FundingMode_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_FundingMode_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_FundingMode_Acct_BY_UUID;
	}
}
