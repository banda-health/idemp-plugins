package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFactAcct;

/**
 * Data Loader for Fact_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_Fact_AcctDataLoader extends PODataLoader<MFactAcct> {
	public static String DATALOADER_Fact_Acct_BY_ID = "Fact_AcctByIdDataLoader";
	public static String DATALOADER_Fact_Acct_BY_UUID = "Fact_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFactAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_Fact_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_Fact_Acct_BY_UUID;
	}
}
