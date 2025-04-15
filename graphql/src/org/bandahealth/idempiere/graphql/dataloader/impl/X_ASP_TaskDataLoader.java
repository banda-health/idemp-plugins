package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Task;

/**
 * Data Loader for ASP_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_ASP_TaskDataLoader extends PODataLoader<X_ASP_Task> {
	public static String DATALOADER_ASP_Task_BY_ID = "ASP_TaskByIdDataLoader";
	public static String DATALOADER_ASP_Task_BY_UUID = "ASP_TaskByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Task.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Task_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Task_BY_UUID;
	}
}
