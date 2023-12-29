package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MActivity;

/**
 * Data Loader for C_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ActivityDataLoader extends PODataLoader<MActivity> {
	public static String C_Activity_BY_ID_DATA_LOADER = "C_ActivityByIdDataLoader";
	public static String C_Activity_BY_UUID_DATA_LOADER = "C_ActivityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MActivity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Activity_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Activity_BY_UUID_DATA_LOADER;
	}
}
