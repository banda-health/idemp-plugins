package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MNote;

/**
 * Data Loader for AD_Note - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_NoteDataLoader extends PODataLoader<MNote> {
	public static String DATALOADER_AD_Note_BY_ID = "AD_NoteByIdDataLoader";
	public static String DATALOADER_AD_Note_BY_UUID = "AD_NoteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MNote.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Note_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Note_BY_UUID;
	}
}
