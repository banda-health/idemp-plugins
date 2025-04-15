package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectTask;

/**
 * Data Loader for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ProjectTaskDataLoader extends PODataLoader<MProjectTask> {
	public static String DATALOADER_C_ProjectTask_BY_ID = "C_ProjectTaskByIdDataLoader";
	public static String DATALOADER_C_ProjectTask_BY_UUID = "C_ProjectTaskByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectTask.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ProjectTask_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ProjectTask_BY_UUID;
	}
}
