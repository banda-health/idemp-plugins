package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFactAcct;

/**
 * Data Loader for Fact_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_Fact_AcctDataLoader extends PODataLoader<MFactAcct> {
	public static String Fact_Acct_BY_ID_DATA_LOADER = "Fact_AcctByIdDataLoader";
	public static String Fact_Acct_BY_UUID_DATA_LOADER = "Fact_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFactAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return Fact_Acct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return Fact_Acct_BY_UUID_DATA_LOADER;
	}
}
