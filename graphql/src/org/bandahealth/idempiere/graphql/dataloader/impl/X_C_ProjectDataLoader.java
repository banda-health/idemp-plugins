package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProject;

/**
 * Data Loader for C_Project - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectDataLoader extends PODataLoader<MProject> {
	public static String C_Project_BY_ID_DATA_LOADER = "C_ProjectByIdDataLoader";
	public static String C_Project_BY_UUID_DATA_LOADER = "C_ProjectByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProject.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Project_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Project_BY_UUID_DATA_LOADER;
	}
}
