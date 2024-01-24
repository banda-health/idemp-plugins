package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Process;

/**
 * Data Loader for HR_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ProcessDataLoader extends PODataLoader<X_HR_Process> {
	public static String DATALOADER_HR_Process_BY_ID = "HR_ProcessByIdDataLoader";
	public static String DATALOADER_HR_Process_BY_UUID = "HR_ProcessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Process.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Process_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Process_BY_UUID;
	}
}
