package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MActivity;

/**
 * Data Loader for C_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ActivityDataLoader extends PODataLoader<MActivity> {
	public static String DATALOADER_C_Activity_BY_ID = "C_ActivityByIdDataLoader";
	public static String DATALOADER_C_Activity_BY_UUID = "C_ActivityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MActivity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Activity_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Activity_BY_UUID;
	}
}
