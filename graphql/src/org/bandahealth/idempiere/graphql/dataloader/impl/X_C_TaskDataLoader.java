package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectTypeTask;

/**
 * Data Loader for C_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_TaskDataLoader extends PODataLoader<MProjectTypeTask> {
	public static String DATALOADER_C_Task_BY_ID = "C_TaskByIdDataLoader";
	public static String DATALOADER_C_Task_BY_UUID = "C_TaskByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectTypeTask.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Task_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Task_BY_UUID;
	}
}
