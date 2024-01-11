package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_CyclePhase;

/**
 * Data Loader for C_CyclePhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CyclePhaseDataLoader extends PODataLoader<X_C_CyclePhase> {
	public static String C_CyclePhase_BY_ID_DATA_LOADER = "C_CyclePhaseByIdDataLoader";
	public static String C_CyclePhase_BY_UUID_DATA_LOADER = "C_CyclePhaseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_CyclePhase.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CyclePhase_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CyclePhase_BY_UUID_DATA_LOADER;
	}
}
