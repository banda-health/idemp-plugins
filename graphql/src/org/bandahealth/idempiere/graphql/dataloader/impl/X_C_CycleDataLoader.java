package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Cycle;

/**
 * Data Loader for C_Cycle - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CycleDataLoader extends PODataLoader<X_C_Cycle> {
	public static String DATALOADER_C_Cycle_BY_ID = "C_CycleByIdDataLoader";
	public static String DATALOADER_C_Cycle_BY_UUID = "C_CycleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Cycle.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Cycle_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Cycle_BY_UUID;
	}
}
