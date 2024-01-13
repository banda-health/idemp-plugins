package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournalGeneratorSource;

/**
 * Data Loader for GL_JournalGeneratorSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalGeneratorSourceDataLoader extends PODataLoader<MJournalGeneratorSource> {
	public static String DATALOADER_GL_JournalGeneratorSource_BY_ID = "GL_JournalGeneratorSourceByIdDataLoader";
	public static String DATALOADER_GL_JournalGeneratorSource_BY_UUID = "GL_JournalGeneratorSourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournalGeneratorSource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_JournalGeneratorSource_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_JournalGeneratorSource_BY_UUID;
	}
}
