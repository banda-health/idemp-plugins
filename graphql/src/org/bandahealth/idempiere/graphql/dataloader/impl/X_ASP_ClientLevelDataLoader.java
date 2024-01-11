package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_ClientLevel;

/**
 * Data Loader for ASP_ClientLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_ClientLevelDataLoader extends PODataLoader<X_ASP_ClientLevel> {
	public static String ASP_ClientLevel_BY_ID_DATA_LOADER = "ASP_ClientLevelByIdDataLoader";
	public static String ASP_ClientLevel_BY_UUID_DATA_LOADER = "ASP_ClientLevelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_ClientLevel.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return ASP_ClientLevel_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return ASP_ClientLevel_BY_UUID_DATA_LOADER;
	}
}
