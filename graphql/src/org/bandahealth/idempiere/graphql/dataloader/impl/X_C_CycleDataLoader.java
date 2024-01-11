package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Cycle;

/**
 * Data Loader for C_Cycle - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CycleDataLoader extends PODataLoader<X_C_Cycle> {
	public static String C_Cycle_BY_ID_DATA_LOADER = "C_CycleByIdDataLoader";
	public static String C_Cycle_BY_UUID_DATA_LOADER = "C_CycleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Cycle.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Cycle_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Cycle_BY_UUID_DATA_LOADER;
	}
}
