package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournalGeneratorSource;

/**
 * Data Loader for GL_JournalGeneratorSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalGeneratorSourceDataLoader extends PODataLoader<MJournalGeneratorSource> {
	public static String GL_JournalGeneratorSource_BY_ID_DATA_LOADER = "GL_JournalGeneratorSourceByIdDataLoader";
	public static String GL_JournalGeneratorSource_BY_UUID_DATA_LOADER = "GL_JournalGeneratorSourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournalGeneratorSource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_JournalGeneratorSource_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_JournalGeneratorSource_BY_UUID_DATA_LOADER;
	}
}
