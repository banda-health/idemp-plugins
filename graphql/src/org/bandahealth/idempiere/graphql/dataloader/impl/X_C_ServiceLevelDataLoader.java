package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_ServiceLevel;

/**
 * Data Loader for C_ServiceLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ServiceLevelDataLoader extends PODataLoader<X_C_ServiceLevel> {
	public static String C_ServiceLevel_BY_ID_DATA_LOADER = "C_ServiceLevelByIdDataLoader";
	public static String C_ServiceLevel_BY_UUID_DATA_LOADER = "C_ServiceLevelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_ServiceLevel.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ServiceLevel_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ServiceLevel_BY_UUID_DATA_LOADER;
	}
}
