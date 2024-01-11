package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChatEntry;

/**
 * Data Loader for CM_ChatEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_CM_ChatEntryDataLoader extends PODataLoader<MChatEntry> {
	public static String CM_ChatEntry_BY_ID_DATA_LOADER = "CM_ChatEntryByIdDataLoader";
	public static String CM_ChatEntry_BY_UUID_DATA_LOADER = "CM_ChatEntryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChatEntry.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return CM_ChatEntry_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return CM_ChatEntry_BY_UUID_DATA_LOADER;
	}
}
