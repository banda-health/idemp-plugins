package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MContactInterest;

/**
 * Data Loader for R_ContactInterest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_ContactInterestDataLoader extends PODataLoader<MContactInterest> {
	public static String DATALOADER_R_ContactInterest_BY_ID = "R_ContactInterestByIdDataLoader";
	public static String DATALOADER_R_ContactInterest_BY_UUID = "R_ContactInterestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MContactInterest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_ContactInterest_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_ContactInterest_BY_UUID;
	}
}
