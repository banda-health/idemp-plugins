package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournal;

/**
 * Data Loader for GL_Journal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_JournalDataLoader extends PODataLoader<MJournal> {
	public static String DATALOADER_GL_Journal_BY_ID = "GL_JournalByIdDataLoader";
	public static String DATALOADER_GL_Journal_BY_UUID = "GL_JournalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_Journal_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_Journal_BY_UUID;
	}
}
