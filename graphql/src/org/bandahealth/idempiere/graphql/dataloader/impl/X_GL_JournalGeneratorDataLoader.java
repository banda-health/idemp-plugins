package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournalGenerator;

/**
 * Data Loader for GL_JournalGenerator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalGeneratorDataLoader extends PODataLoader<MJournalGenerator> {
	public static String GL_JournalGenerator_BY_ID_DATA_LOADER = "GL_JournalGeneratorByIdDataLoader";
	public static String GL_JournalGenerator_BY_UUID_DATA_LOADER = "GL_JournalGeneratorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournalGenerator.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_JournalGenerator_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_JournalGenerator_BY_UUID_DATA_LOADER;
	}
}
