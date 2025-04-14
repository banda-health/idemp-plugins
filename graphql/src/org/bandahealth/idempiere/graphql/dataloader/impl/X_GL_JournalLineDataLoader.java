package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournalLine;

/**
 * Data Loader for GL_JournalLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_GL_JournalLineDataLoader extends PODataLoader<MJournalLine> {
	public static String DATALOADER_GL_JournalLine_BY_ID = "GL_JournalLineByIdDataLoader";
	public static String DATALOADER_GL_JournalLine_BY_UUID = "GL_JournalLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournalLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_JournalLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_JournalLine_BY_UUID;
	}
}
