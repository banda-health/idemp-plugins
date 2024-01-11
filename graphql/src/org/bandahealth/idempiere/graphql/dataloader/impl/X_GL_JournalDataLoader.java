package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournal;

/**
 * Data Loader for GL_Journal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalDataLoader extends PODataLoader<MJournal> {
	public static String GL_Journal_BY_ID_DATA_LOADER = "GL_JournalByIdDataLoader";
	public static String GL_Journal_BY_UUID_DATA_LOADER = "GL_JournalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_Journal_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_Journal_BY_UUID_DATA_LOADER;
	}
}
