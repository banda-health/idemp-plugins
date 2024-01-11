package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_CycleStep;

/**
 * Data Loader for C_CycleStep - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CycleStepDataLoader extends PODataLoader<X_C_CycleStep> {
	public static String C_CycleStep_BY_ID_DATA_LOADER = "C_CycleStepByIdDataLoader";
	public static String C_CycleStep_BY_UUID_DATA_LOADER = "C_CycleStepByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_CycleStep.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CycleStep_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CycleStep_BY_UUID_DATA_LOADER;
	}
}
