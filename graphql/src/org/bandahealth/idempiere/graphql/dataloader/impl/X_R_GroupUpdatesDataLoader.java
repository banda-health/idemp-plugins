package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_GroupUpdates;

/**
 * Data Loader for R_GroupUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_GroupUpdatesDataLoader extends PODataLoader<X_R_GroupUpdates> {
	public static String DATALOADER_R_GroupUpdates_BY_ID = "R_GroupUpdatesByIdDataLoader";
	public static String DATALOADER_R_GroupUpdates_BY_UUID = "R_GroupUpdatesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_GroupUpdates.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_GroupUpdates_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_GroupUpdates_BY_UUID;
	}
}
