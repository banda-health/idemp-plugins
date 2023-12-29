package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTask;

/**
 * Data Loader for AD_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TaskDataLoader extends PODataLoader<MTask> {
	public static String AD_Task_BY_ID_DATA_LOADER = "AD_TaskByIdDataLoader";
	public static String AD_Task_BY_UUID_DATA_LOADER = "AD_TaskByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTask.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Task_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Task_BY_UUID_DATA_LOADER;
	}
}
