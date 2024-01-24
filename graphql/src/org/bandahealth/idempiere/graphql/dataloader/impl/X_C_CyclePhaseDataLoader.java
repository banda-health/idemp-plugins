package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_CyclePhase;

/**
 * Data Loader for C_CyclePhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CyclePhaseDataLoader extends PODataLoader<X_C_CyclePhase> {
	public static String DATALOADER_C_CyclePhase_BY_ID = "C_CyclePhaseByIdDataLoader";
	public static String DATALOADER_C_CyclePhase_BY_UUID = "C_CyclePhaseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_CyclePhase.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CyclePhase_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CyclePhase_BY_UUID;
	}
}
