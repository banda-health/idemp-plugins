package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_ClientLevel;

/**
 * Data Loader for ASP_ClientLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_ASP_ClientLevelDataLoader extends PODataLoader<X_ASP_ClientLevel> {
	public static String DATALOADER_ASP_ClientLevel_BY_ID = "ASP_ClientLevelByIdDataLoader";
	public static String DATALOADER_ASP_ClientLevel_BY_UUID = "ASP_ClientLevelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_ClientLevel.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_ClientLevel_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_ClientLevel_BY_UUID;
	}
}
