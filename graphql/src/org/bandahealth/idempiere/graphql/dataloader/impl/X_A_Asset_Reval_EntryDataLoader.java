package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Reval_Entry;

/**
 * Data Loader for A_Asset_Reval_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Reval_EntryDataLoader extends PODataLoader<X_A_Asset_Reval_Entry> {
	public static String A_Asset_Reval_Entry_BY_ID_DATA_LOADER = "A_Asset_Reval_EntryByIdDataLoader";
	public static String A_Asset_Reval_Entry_BY_UUID_DATA_LOADER = "A_Asset_Reval_EntryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Reval_Entry.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Reval_Entry_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Reval_Entry_BY_UUID_DATA_LOADER;
	}
}
