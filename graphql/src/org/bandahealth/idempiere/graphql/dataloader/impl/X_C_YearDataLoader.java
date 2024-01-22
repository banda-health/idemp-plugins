package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MYear;

/**
 * Data Loader for C_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_YearDataLoader extends PODataLoader<MYear> {
	public static String DATALOADER_C_Year_BY_ID = "C_YearByIdDataLoader";
	public static String DATALOADER_C_Year_BY_UUID = "C_YearByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MYear.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Year_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Year_BY_UUID;
	}
}
