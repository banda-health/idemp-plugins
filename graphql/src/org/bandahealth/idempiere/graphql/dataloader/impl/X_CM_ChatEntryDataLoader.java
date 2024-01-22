package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChatEntry;

/**
 * Data Loader for CM_ChatEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatEntryDataLoader extends PODataLoader<MChatEntry> {
	public static String DATALOADER_CM_ChatEntry_BY_ID = "CM_ChatEntryByIdDataLoader";
	public static String DATALOADER_CM_ChatEntry_BY_UUID = "CM_ChatEntryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChatEntry.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_CM_ChatEntry_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_CM_ChatEntry_BY_UUID;
	}
}
