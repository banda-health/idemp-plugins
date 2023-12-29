package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectTypePhase;

/**
 * Data Loader for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PhaseDataLoader extends PODataLoader<MProjectTypePhase> {
	public static String C_Phase_BY_ID_DATA_LOADER = "C_PhaseByIdDataLoader";
	public static String C_Phase_BY_UUID_DATA_LOADER = "C_PhaseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectTypePhase.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Phase_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Phase_BY_UUID_DATA_LOADER;
	}
}
