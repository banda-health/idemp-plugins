package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Retirement;

/**
 * Data Loader for A_Asset_Retirement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_RetirementDataLoader extends PODataLoader<X_A_Asset_Retirement> {
	public static String DATALOADER_A_Asset_Retirement_BY_ID = "A_Asset_RetirementByIdDataLoader";
	public static String DATALOADER_A_Asset_Retirement_BY_UUID = "A_Asset_RetirementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Retirement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Retirement_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Retirement_BY_UUID;
	}
}
