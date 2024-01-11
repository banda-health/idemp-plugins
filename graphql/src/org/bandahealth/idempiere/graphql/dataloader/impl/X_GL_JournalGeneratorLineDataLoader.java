package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournalGeneratorLine;

/**
 * Data Loader for GL_JournalGeneratorLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalGeneratorLineDataLoader extends PODataLoader<MJournalGeneratorLine> {
	public static String GL_JournalGeneratorLine_BY_ID_DATA_LOADER = "GL_JournalGeneratorLineByIdDataLoader";
	public static String GL_JournalGeneratorLine_BY_UUID_DATA_LOADER = "GL_JournalGeneratorLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournalGeneratorLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_JournalGeneratorLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_JournalGeneratorLine_BY_UUID_DATA_LOADER;
	}
}
