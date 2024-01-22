package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectPhase;

/**
 * Data Loader for C_ProjectPhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ProjectPhaseDataLoader extends PODataLoader<MProjectPhase> {
	public static String DATALOADER_C_ProjectPhase_BY_ID = "C_ProjectPhaseByIdDataLoader";
	public static String DATALOADER_C_ProjectPhase_BY_UUID = "C_ProjectPhaseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectPhase.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ProjectPhase_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ProjectPhase_BY_UUID;
	}
}
