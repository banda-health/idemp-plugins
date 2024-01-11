package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Task;

/**
 * Data Loader for ASP_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_TaskDataLoader extends PODataLoader<X_ASP_Task> {
	public static String ASP_Task_BY_ID_DATA_LOADER = "ASP_TaskByIdDataLoader";
	public static String ASP_Task_BY_UUID_DATA_LOADER = "ASP_TaskByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Task.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return ASP_Task_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return ASP_Task_BY_UUID_DATA_LOADER;
	}
}
