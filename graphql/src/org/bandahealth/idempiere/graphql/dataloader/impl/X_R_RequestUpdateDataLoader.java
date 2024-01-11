package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestUpdate;

/**
 * Data Loader for R_RequestUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestUpdateDataLoader extends PODataLoader<MRequestUpdate> {
	public static String R_RequestUpdate_BY_ID_DATA_LOADER = "R_RequestUpdateByIdDataLoader";
	public static String R_RequestUpdate_BY_UUID_DATA_LOADER = "R_RequestUpdateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestUpdate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_RequestUpdate_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_RequestUpdate_BY_UUID_DATA_LOADER;
	}
}
