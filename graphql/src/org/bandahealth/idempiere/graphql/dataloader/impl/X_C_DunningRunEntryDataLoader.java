package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDunningRunEntry;

/**
 * Data Loader for C_DunningRunEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_DunningRunEntryDataLoader extends PODataLoader<MDunningRunEntry> {
	public static String DATALOADER_C_DunningRunEntry_BY_ID = "C_DunningRunEntryByIdDataLoader";
	public static String DATALOADER_C_DunningRunEntry_BY_UUID = "C_DunningRunEntryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDunningRunEntry.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_DunningRunEntry_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_DunningRunEntry_BY_UUID;
	}
}
