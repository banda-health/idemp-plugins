package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournalGeneratorLine;

/**
 * Data Loader for GL_JournalGeneratorLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalGeneratorLineDataLoader extends PODataLoader<MJournalGeneratorLine> {
	public static String DATALOADER_GL_JournalGeneratorLine_BY_ID = "GL_JournalGeneratorLineByIdDataLoader";
	public static String DATALOADER_GL_JournalGeneratorLine_BY_UUID = "GL_JournalGeneratorLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournalGeneratorLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_JournalGeneratorLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_JournalGeneratorLine_BY_UUID;
	}
}
