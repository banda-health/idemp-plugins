package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPeriod;

/**
 * Data Loader for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PeriodDataLoader extends PODataLoader<MPeriod> {
	public static String DATALOADER_C_Period_BY_ID = "C_PeriodByIdDataLoader";
	public static String DATALOADER_C_Period_BY_UUID = "C_PeriodByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPeriod.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Period_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Period_BY_UUID;
	}
}
