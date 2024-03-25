package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_CategoryUpdates;

/**
 * Data Loader for R_CategoryUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_CategoryUpdatesDataLoader extends PODataLoader<X_R_CategoryUpdates> {
	public static String DATALOADER_R_CategoryUpdates_BY_ID = "R_CategoryUpdatesByIdDataLoader";
	public static String DATALOADER_R_CategoryUpdates_BY_UUID = "R_CategoryUpdatesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_CategoryUpdates.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_CategoryUpdates_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_CategoryUpdates_BY_UUID;
	}
}
