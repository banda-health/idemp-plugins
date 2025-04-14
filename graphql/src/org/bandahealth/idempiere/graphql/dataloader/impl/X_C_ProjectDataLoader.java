package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProject;

/**
 * Data Loader for C_Project - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_ProjectDataLoader extends PODataLoader<MProject> {
	public static String DATALOADER_C_Project_BY_ID = "C_ProjectByIdDataLoader";
	public static String DATALOADER_C_Project_BY_UUID = "C_ProjectByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProject.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Project_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Project_BY_UUID;
	}
}
