package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_RequestTypeUpdates;

/**
 * Data Loader for R_RequestTypeUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestTypeUpdatesDataLoader extends PODataLoader<X_R_RequestTypeUpdates> {
	public static String DATALOADER_R_RequestTypeUpdates_BY_ID = "R_RequestTypeUpdatesByIdDataLoader";
	public static String DATALOADER_R_RequestTypeUpdates_BY_UUID = "R_RequestTypeUpdatesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_RequestTypeUpdates.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_RequestTypeUpdates_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_RequestTypeUpdates_BY_UUID;
	}
}
