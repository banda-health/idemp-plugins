package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectTypePhase;

/**
 * Data Loader for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PhaseDataLoader extends PODataLoader<MProjectTypePhase> {
	public static String DATALOADER_C_Phase_BY_ID = "C_PhaseByIdDataLoader";
	public static String DATALOADER_C_Phase_BY_UUID = "C_PhaseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectTypePhase.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Phase_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Phase_BY_UUID;
	}
}
