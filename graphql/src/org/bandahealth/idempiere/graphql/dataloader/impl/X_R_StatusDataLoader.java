package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStatus;

/**
 * Data Loader for R_Status - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_StatusDataLoader extends PODataLoader<MStatus> {
	public static String R_Status_BY_ID_DATA_LOADER = "R_StatusByIdDataLoader";
	public static String R_Status_BY_UUID_DATA_LOADER = "R_StatusByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStatus.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_Status_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_Status_BY_UUID_DATA_LOADER;
	}
}
