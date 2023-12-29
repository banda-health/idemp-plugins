package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectTask;

/**
 * Data Loader for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectTaskDataLoader extends PODataLoader<MProjectTask> {
	public static String C_ProjectTask_BY_ID_DATA_LOADER = "C_ProjectTaskByIdDataLoader";
	public static String C_ProjectTask_BY_UUID_DATA_LOADER = "C_ProjectTaskByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectTask.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ProjectTask_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ProjectTask_BY_UUID_DATA_LOADER;
	}
}
