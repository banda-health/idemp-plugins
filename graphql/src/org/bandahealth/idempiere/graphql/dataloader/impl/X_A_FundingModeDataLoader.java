package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_FundingMode;

/**
 * Data Loader for A_FundingMode - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_FundingModeDataLoader extends PODataLoader<X_A_FundingMode> {
	public static String DATALOADER_A_FundingMode_BY_ID = "A_FundingModeByIdDataLoader";
	public static String DATALOADER_A_FundingMode_BY_UUID = "A_FundingModeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_FundingMode.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_FundingMode_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_FundingMode_BY_UUID;
	}
}
