package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MNote;

/**
 * Data Loader for AD_Note - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_NoteDataLoader extends PODataLoader<MNote> {
	public static String AD_Note_BY_ID_DATA_LOADER = "AD_NoteByIdDataLoader";
	public static String AD_Note_BY_UUID_DATA_LOADER = "AD_NoteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MNote.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Note_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Note_BY_UUID_DATA_LOADER;
	}
}
