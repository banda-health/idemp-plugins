package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_Fact_Acct_Summary;

/**
 * Data Loader for Fact_Acct_Summary - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_Fact_Acct_SummaryDataLoader extends PODataLoader<X_Fact_Acct_Summary> {
	public static String Fact_Acct_Summary_BY_ID_DATA_LOADER = "Fact_Acct_SummaryByIdDataLoader";
	public static String Fact_Acct_Summary_BY_UUID_DATA_LOADER = "Fact_Acct_SummaryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_Fact_Acct_Summary.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return Fact_Acct_Summary_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return Fact_Acct_Summary_BY_UUID_DATA_LOADER;
	}
}
