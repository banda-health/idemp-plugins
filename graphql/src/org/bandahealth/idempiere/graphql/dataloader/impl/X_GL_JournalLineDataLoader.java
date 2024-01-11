package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournalLine;

/**
 * Data Loader for GL_JournalLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalLineDataLoader extends PODataLoader<MJournalLine> {
	public static String GL_JournalLine_BY_ID_DATA_LOADER = "GL_JournalLineByIdDataLoader";
	public static String GL_JournalLine_BY_UUID_DATA_LOADER = "GL_JournalLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournalLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_JournalLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_JournalLine_BY_UUID_DATA_LOADER;
	}
}
