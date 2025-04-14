package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectType;

/**
 * Data Loader for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_ProjectTypeDataLoader extends PODataLoader<MProjectType> {
	public static String DATALOADER_C_ProjectType_BY_ID = "C_ProjectTypeByIdDataLoader";
	public static String DATALOADER_C_ProjectType_BY_UUID = "C_ProjectTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ProjectType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ProjectType_BY_UUID;
	}
}
