package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_CycleStep;

/**
 * Data Loader for C_CycleStep - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CycleStepDataLoader extends PODataLoader<X_C_CycleStep> {
	public static String DATALOADER_C_CycleStep_BY_ID = "C_CycleStepByIdDataLoader";
	public static String DATALOADER_C_CycleStep_BY_UUID = "C_CycleStepByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_CycleStep.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CycleStep_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CycleStep_BY_UUID;
	}
}
