package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Job;

/**
 * Data Loader for HR_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_JobDataLoader extends PODataLoader<X_HR_Job> {
	public static String DATALOADER_HR_Job_BY_ID = "HR_JobByIdDataLoader";
	public static String DATALOADER_HR_Job_BY_UUID = "HR_JobByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Job.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Job_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Job_BY_UUID;
	}
}
