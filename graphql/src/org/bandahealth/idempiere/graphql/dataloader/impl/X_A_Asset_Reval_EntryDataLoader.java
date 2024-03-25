package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Reval_Entry;

/**
 * Data Loader for A_Asset_Reval_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_Reval_EntryDataLoader extends PODataLoader<X_A_Asset_Reval_Entry> {
	public static String DATALOADER_A_Asset_Reval_Entry_BY_ID = "A_Asset_Reval_EntryByIdDataLoader";
	public static String DATALOADER_A_Asset_Reval_Entry_BY_UUID = "A_Asset_Reval_EntryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Reval_Entry.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Reval_Entry_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Reval_Entry_BY_UUID;
	}
}
