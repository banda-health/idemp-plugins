package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectType;

/**
 * Data Loader for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectTypeDataLoader extends PODataLoader<MProjectType> {
	public static String C_ProjectType_BY_ID_DATA_LOADER = "C_ProjectTypeByIdDataLoader";
	public static String C_ProjectType_BY_UUID_DATA_LOADER = "C_ProjectTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ProjectType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ProjectType_BY_UUID_DATA_LOADER;
	}
}
