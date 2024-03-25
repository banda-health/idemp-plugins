package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Job;

/**
 * Data Loader for C_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_JobDataLoader extends PODataLoader<X_C_Job> {
	public static String DATALOADER_C_Job_BY_ID = "C_JobByIdDataLoader";
	public static String DATALOADER_C_Job_BY_UUID = "C_JobByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Job.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Job_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Job_BY_UUID;
	}
}
