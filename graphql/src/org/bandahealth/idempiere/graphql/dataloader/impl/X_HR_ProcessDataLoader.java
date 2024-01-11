package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Process;

/**
 * Data Loader for HR_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ProcessDataLoader extends PODataLoader<X_HR_Process> {
	public static String HR_Process_BY_ID_DATA_LOADER = "HR_ProcessByIdDataLoader";
	public static String HR_Process_BY_UUID_DATA_LOADER = "HR_ProcessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Process.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Process_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Process_BY_UUID_DATA_LOADER;
	}
}
