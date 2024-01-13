package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStatus;

/**
 * Data Loader for R_Status - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_StatusDataLoader extends PODataLoader<MStatus> {
	public static String DATALOADER_R_Status_BY_ID = "R_StatusByIdDataLoader";
	public static String DATALOADER_R_Status_BY_UUID = "R_StatusByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStatus.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_Status_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_Status_BY_UUID;
	}
}
