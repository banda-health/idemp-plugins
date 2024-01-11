package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MContactInterest;

/**
 * Data Loader for R_ContactInterest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_ContactInterestDataLoader extends PODataLoader<MContactInterest> {
	public static String R_ContactInterest_BY_ID_DATA_LOADER = "R_ContactInterestByIdDataLoader";
	public static String R_ContactInterest_BY_UUID_DATA_LOADER = "R_ContactInterestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MContactInterest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_ContactInterest_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_ContactInterest_BY_UUID_DATA_LOADER;
	}
}
