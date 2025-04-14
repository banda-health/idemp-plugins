package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPeriodControl;

/**
 * Data Loader for C_PeriodControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PeriodControlDataLoader extends PODataLoader<MPeriodControl> {
	public static String DATALOADER_C_PeriodControl_BY_ID = "C_PeriodControlByIdDataLoader";
	public static String DATALOADER_C_PeriodControl_BY_UUID = "C_PeriodControlByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPeriodControl.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_PeriodControl_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_PeriodControl_BY_UUID;
	}
}
