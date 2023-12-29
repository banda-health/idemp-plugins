package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_FundingMode;

/**
 * Data Loader for A_FundingMode - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_FundingModeDataLoader extends PODataLoader<X_A_FundingMode> {
	public static String A_FundingMode_BY_ID_DATA_LOADER = "A_FundingModeByIdDataLoader";
	public static String A_FundingMode_BY_UUID_DATA_LOADER = "A_FundingModeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_FundingMode.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_FundingMode_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_FundingMode_BY_UUID_DATA_LOADER;
	}
}
