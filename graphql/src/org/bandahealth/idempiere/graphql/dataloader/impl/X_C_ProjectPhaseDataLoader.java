package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectPhase;

/**
 * Data Loader for C_ProjectPhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectPhaseDataLoader extends PODataLoader<MProjectPhase> {
	public static String C_ProjectPhase_BY_ID_DATA_LOADER = "C_ProjectPhaseByIdDataLoader";
	public static String C_ProjectPhase_BY_UUID_DATA_LOADER = "C_ProjectPhaseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectPhase.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ProjectPhase_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ProjectPhase_BY_UUID_DATA_LOADER;
	}
}
