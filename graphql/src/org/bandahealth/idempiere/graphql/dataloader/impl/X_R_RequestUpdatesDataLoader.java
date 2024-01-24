package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_RequestUpdates;

/**
 * Data Loader for R_RequestUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestUpdatesDataLoader extends PODataLoader<X_R_RequestUpdates> {
	public static String DATALOADER_R_RequestUpdates_BY_ID = "R_RequestUpdatesByIdDataLoader";
	public static String DATALOADER_R_RequestUpdates_BY_UUID = "R_RequestUpdatesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_RequestUpdates.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_RequestUpdates_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_RequestUpdates_BY_UUID;
	}
}
