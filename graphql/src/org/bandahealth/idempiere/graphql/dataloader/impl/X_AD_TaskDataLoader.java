package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTask;

/**
 * Data Loader for AD_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_TaskDataLoader extends PODataLoader<MTask> {
	public static String DATALOADER_AD_Task_BY_ID = "AD_TaskByIdDataLoader";
	public static String DATALOADER_AD_Task_BY_UUID = "AD_TaskByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTask.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Task_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Task_BY_UUID;
	}
}
