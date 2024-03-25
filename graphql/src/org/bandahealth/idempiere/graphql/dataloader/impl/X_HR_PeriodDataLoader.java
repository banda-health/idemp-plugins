package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Period;

/**
 * Data Loader for HR_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_PeriodDataLoader extends PODataLoader<X_HR_Period> {
	public static String DATALOADER_HR_Period_BY_ID = "HR_PeriodByIdDataLoader";
	public static String DATALOADER_HR_Period_BY_UUID = "HR_PeriodByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Period.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Period_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Period_BY_UUID;
	}
}
