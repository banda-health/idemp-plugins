package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_ServiceLevel;

/**
 * Data Loader for C_ServiceLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ServiceLevelDataLoader extends PODataLoader<X_C_ServiceLevel> {
	public static String DATALOADER_C_ServiceLevel_BY_ID = "C_ServiceLevelByIdDataLoader";
	public static String DATALOADER_C_ServiceLevel_BY_UUID = "C_ServiceLevelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_ServiceLevel.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ServiceLevel_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ServiceLevel_BY_UUID;
	}
}
